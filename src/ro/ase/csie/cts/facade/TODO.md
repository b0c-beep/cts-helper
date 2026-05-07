# Subiect de Lucru: Șablonul Facade

## 🏢 Scenariul: Sistemul Smart Home

Te-ai mutat într-o casă inteligentă (Smart Home) dotată cu mai multe sisteme independente: Încălzire, Securitate și Iluminat. Când pleci la muncă dimineața sau când te întorci seara, ești nevoit să deschizi 3 aplicații diferite pe telefon pentru a regla fiecare sistem în parte.

Pentru a-ți face viața mai ușoară, vrei să creezi o aplicație unică (o **Fațadă**) care să aibă doar două butoane mari: "Plecare de acasă" și "Sosire acasă".

---

## 💻 Codul de pornire (Subsistemul Complex)

Acestea sunt clasele care controlează componentele casei. Ai voie să le folosești, dar, fiind codul producătorilor de hardware, este bine să nu le modifici.

```java
class SistemIncalzire {
    public void seteazaTemperatura(int grade) {
        System.out.println("Termostat: Temperatura setată la " + grade + " grade.");
    }
}

class SistemSecuritate {
    public void armeaza() {
        System.out.println("Alarma: Sistemul de securitate este ARMAT.");
    }
    public void dezarmeaza() {
        System.out.println("Alarma: Sistemul de securitate este DEZARMAT.");
    }
}

class SistemIluminat {
    public void stingeTot() {
        System.out.println("Lumini: Toate becurile au fost STINSE.");
    }
    public void aprindeHol() {
        System.out.println("Lumini: Becul de pe hol a fost APRINS.");
    }
}
```

## 📝 Cerințe de rezolvare

Trebuie să implementezi șablonul Facade pentru a simplifica utilizarea casei:

### 1. Clasa Fațadă (`SmartHomeFacade`)
* Creează clasa `SmartHomeFacade`.
* Trebuie să conțină instanțe (obiecte) ale celor trei clase din subsistem (`SistemIncalzire`, `SistemSecuritate`, `SistemIluminat`). Poți să le instanțiezi direct în clasă sau să le primești prin constructor.
* **Implementează metoda `pleacaDeAcasa()`:**
    * Stinge toate luminile.
    * Setează temperatura la 18 grade (mod economic).
    * Armează sistemul de securitate.
* **Implementează metoda `ajungeAcasa()`:**
    * Dezarmează sistemul de securitate.
    * Setează temperatura la 22 de grade (mod confort).
    * Aprinde lumina pe hol.

### 2. Clasa Main (Clientul)
* Creează clasa `Main`.
* Instanțiază `SmartHomeFacade`.
* Simulează rutina zilnică apelând doar cele două metode simple din fațadă (`pleacaDeAcasa` și apoi `ajungeAcasa`), fără a interacționa direct cu sistemele individuale.