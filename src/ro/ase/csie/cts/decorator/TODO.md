# Subiect de Lucru: Șablonul Decorator

## 🏢 Scenariul: Echiparea personajelor într-un joc RPG

Lucrezi la un joc de tip RPG. Personajele tale încep la nivelul 1 fiind complet neechipate (doar cu abilitățile de bază de a ataca și a se apăra). Pe parcursul jocului, jucătorii pot găsi și echipa diverse obiecte (un scut, o sabie magică etc.).

Pentru a nu crea zeci de clase de genul `RazboinicCuSabie`, `RazboinicCuScut`, `RazboinicCuSabieSiScut`, vei folosi șablonul Decorator pentru a "împacheta" personajul cu aceste echipamente la runtime, adăugându-i comportamente sau atribute noi.

---

## 💻 Codul de pornire (Baza)

Acesta este contractul și personajul de bază. Nu le modifica!

```java
// 1. Interfața comună (Componenta)
public interface IPersonaj {
    void ataca();
    void apara();
}

// 2. Obiectul de bază (Componenta Concretă)
public class Razboinic implements IPersonaj {
    @Override
    public void ataca() {
        System.out.println("Războinicul atacă cu pumnii.");
    }

    @Override
    public void apara() {
        System.out.println("Războinicul se apără cu brațele.");
    }
}
```

## 📝 Cerințe de rezolvare

Trebuie să implementezi sistemul de echipamente folosind Decorator:

### 1. Decoratorul Abstract (`EchipamentDecorator`)
* Creează clasa abstractă `EchipamentDecorator` care implementează `IPersonaj`.
* Trebuie să conțină o referință privată către un `IPersonaj` (personajul pe care îl decorează).
* Creează un constructor care primește această referință.
* Suprascrie metodele `ataca()` și `apara()` delegând apelurile către referința internă (exact cum a fost la `CarDecorator`).

### 2. Decoratorul Concret 1: Adăugarea unui comportament (`Scut`)
* Creează clasa `Scut` care extinde `EchipamentDecorator`.
* Suprascrie metoda `apara()`:
    * Cheamă metoda de bază (din superclasă).
    * Afișează la consolă un comportament suplimentar: `" + Blocaj cu scutul de oțel!"`.
* *(Acest decorator este similar cu `CarWithAlarm` din exemplul tău).*

### 3. Decoratorul Concret 2: Adăugarea unei stări (`SabieMagica`)
* Creează clasa `SabieMagica` care extinde `EchipamentDecorator`.
* Adaugă un atribut nou specific doar acestui echipament: `int putereMagie` (inițializează-l în constructor sau cu un setter).
* Suprascrie metoda `ataca()`:
    * Cheamă metoda de bază.
    * Afișează la consolă: `" + Lovitură tăioasă cu sabia! (Daune magice extra: " + putereMagie + ")"`.
* *(Acest decorator combină modificarea metodei cu adăugarea de stare, similar cu `CarWithSportSeats`).*

### 4. Clasa Main (Testarea)
* Creează un `Razboinic` de bază.
* "Împachetează-l" cu un `Scut`.
* "Împachetează-l" apoi și cu o `SabieMagica` (dă-i o valoare puterii magice, ex: 50).
* Apelează metodele `ataca()` și `apara()` pe personajul final super-dotat pentru a vedea cum se apelează în lanț comportamentele!