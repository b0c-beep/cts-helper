# Subiect de Lucru: Șablonul Proxy

## 🏢 Scenariul: Filtrarea accesului la Internet

Compania la care lucrezi are un modul standard prin care angajații pot accesa diverse site-uri web (`RealInternetConnection`). Datorită scăderii productivității, managementul a cerut blocarea accesului la anumite rețele sociale (ex: "facebook.com", "instagram.com", "tiktok.com").

Regula de aur a departamentului IT: **Nu ai voie să modifici codul sursă al clasei `RealInternetConnection`**, deoarece ea este folosită și de serverele companiei care au nevoie de acces complet, nelimitat.

Trebuie să implementezi un **Proxy de Protecție** care să intercepteze cererile de navigare ale angajaților și să le filtreze.

---

## 💻 Codul de pornire (Situația curentă)

```java
// 1. Interfața comună (Contractul)
public interface IInternetConnection {
    void connectTo(String serverHost);
}

// 2. Obiectul Real (Sistemul de bază, de nemodificat)
public class RealInternetConnection implements IInternetConnection {
    @Override
    public void connectTo(String serverHost) {
        System.out.println("Conexiune stabilită cu succes la: " + serverHost);
    }
}
```

## 📝 Cerințe de rezolvare

Trebuie să creezi mecanismul de filtrare folosind șablonul Proxy:

### 1. Clasa Proxy (`InternetProxy`)
* Trebuie să implementeze interfața `IInternetConnection`.
* Să primească prin constructor și să păstreze intern o referință către conexiunea reală (tipul `IInternetConnection`).
* Să conțină o listă (sau un array de string-uri) cu site-urile interzise. Ex: `"facebook.com"`, `"instagram.com"`, `"tiktok.com"`.
* **Logica metodei `connectTo`:**
    * Verifică dacă `serverHost` face parte din lista site-urilor interzise (poți transforma totul în litere mici cu `.toLowerCase()` pentru o verificare corectă).
    * Dacă este interzis, afișează mesajul: `"ACCES RESPINS: Site-ul este blocat la locul de muncă!"` și blochează execuția (NU apela obiectul real).
    * Dacă site-ul este permis, deleagă (pasează) apelul către metoda `connectTo` a conexiunii reale.

### 2. Clasa Main (Clientul)
* Instanțiază conexiunea reală (`RealInternetConnection`).
* Încapsulează conexiunea reală în `InternetProxy`.
* Testează proxy-ul apelând metoda `connectTo` pentru un site permis (ex: `"google.com"`, `"ase.ro"`) și apoi pentru unul interzis (ex: `"facebook.com"`).