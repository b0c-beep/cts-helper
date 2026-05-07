# Subiect de Lucru: Șablonul Composite

## 🏢 Scenariul: Sistemul de Gestiune E-commerce (Colete)

Lucrezi la o platformă e-commerce. Clienții pot comanda **produse individuale** (ex: un telefon, un cablu) sau **pachete** (cutii). O cutie poate conține produse individuale, dar și alte cutii mai mici (ex: o cutie cu un laptop de gaming poate conține la rândul ei o cutiuță separată pentru mouse și căști).

Trebuie să calculezi **prețul total** și să afișezi conținutul pentru orice fel de comandă, indiferent dacă utilizatorul a cumpărat un singur cablu sau o cutie imensă cu zeci de componente în ea.

---

## 💻 Codul de pornire (Interfața)

Acesta este contractul de bază pe care trebuie să îl respecte toate elementele din magazinul tău:

```java
public interface ElementMagazin {
    // Operații de business
    void afiseazaDetalii();
    double getPret();

    // Operații de structură (Composite)
    void adaugaElement(ElementMagazin element);
    void stergeElement(ElementMagazin element);
}
```

## 📝 Cerințe de rezolvare

Implementează structura Composite folosind abordarea *transparentă* (cum a fost la exercițiul cu Email):

### 1. Frunza (`ProdusIndividual`)
* Creează clasa `ProdusIndividual` care implementează `ElementMagazin`.
* **Atribute:** `nume` (String) și `pret` (double) - inițializate prin constructor.
* **Metode de business:**
    * `afiseazaDetalii()`: Afișează la consolă numele și prețul (ex: "- Telefon: 3500 RON").
    * `getPret()`: Returnează prețul produsului.
* **Metode de structură:**
    * La apelul `adaugaElement` și `stergeElement`, clasa trebuie să arunce o excepție (ex: `UnsupportedOperationException("Un produs individual nu poate conține alte produse!")`), deoarece este o frunză.

### 2. Ramura / Composite (`Cutie`)
* Creează clasa `Cutie` care implementează `ElementMagazin`.
* **Atribute:** `numeCutie` (String) și o listă `elemente` (de tip `ElementMagazin`).
* **Metode de structură:**
    * Implementează logica standard de adăugare și ștergere din lista internă.
* **Metode de business:**
    * `getPret()`: Va parcurge lista internă și va returna **suma** prețurilor tuturor elementelor din cutie.
    * `afiseazaDetalii()`: Va afișa numele cutiei și apoi va apela metoda `afiseazaDetalii()` pentru fiecare element din ea (va parcurge lista).

### 3. Clasa Main (Clientul)
* Creează câteva `ProdusIndividual` (ex: "Telefon" - 3500, "Incarcator" - 150, "Casti" - 300, "Cablu" - 50).
* Creează o `Cutie` mică numită "Cutie Accesorii" și adaugă în ea "Casti" și "Cablu".
* Creează o `Cutie` mare numită "Comanda Totala" și adaugă în ea "Telefon", "Incarcator" și "Cutie Accesorii" (observi cum adaugi o cutie în altă cutie).
* Apelează metoda `afiseazaDetalii()` și apoi printează la consolă rezultatul metodei `getPret()` **doar pe cutia mare** ("Comanda Totala"). Sistemul ar trebui să calculeze totul automat!