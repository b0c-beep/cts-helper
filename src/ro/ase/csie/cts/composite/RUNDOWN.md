# Design Pattern: Composite

## 1. Prezentare Teoretică

**Tip:** Șablon Structural  
**Definiție:** Permite compunerea obiectelor în structuri arborescente pentru a reprezenta ierarhii de tip "parte-întreg". Permite clienților să trateze în mod uniform obiectele individuale (frunzele) și compozițiile de obiecte (ramurile).

**La ce folosește (Scenarii de utilizare):**
* Când vrei să reprezinți ierarhii (ex: sistemul de fișiere - Foldere și Fișiere, meniuri complexe, structura organizațională a unei companii).
* Când vrei ca bucata ta de cod (clientul) să ignore diferențele dintre compoziții de obiecte și obiecte individuale (să apeleze aceeași metodă pe ambele fără să scrie `if (esteGrup) { ... } else { ... }`).

**Avantaje / Dezavantaje:**
* **+** Poți lucra extrem de ușor cu structuri complexe prin recursivitate (polimorfism).
* **+** Respectă OCP: Poți adăuga noi tipuri de elemente în structură fără a strica codul existent.
* **-** Poate face designul "prea general". Este greu să restricționezi ce tipuri de componente pot fi adăugate într-un anumit container (ex: să te asiguri că un folder "Imagini" conține doar fișiere `.jpg`, nu și alte foldere).

**Structura clasică (Foarte important la CTS):**
1. **Component (Interfața de bază):** Definește operațiile comune (ex: `afiseaza()`, `adauga()`, `sterge()`).
2. **Leaf (Frunza):** Obiectul individual care NU are copii (ex: un Fișier).
3. **Composite (Ramura/Containerul):** Obiectul care conține copii (alte frunze sau alte ramuri) și implementează operațiile delegându-le copiilor săi (ex: un Folder).

---

## 2. Exemplu de Implementare (Sistem de Fișiere)

```java
// 1. Component (Interfața / Clasa abstractă comună)
public interface ElementSistem {
    void printeazaNume();
    // Metodele specifice ierarhiei (de obicei, frunzele aruncă excepții aici)
    void adauga(ElementSistem element);
    void sterge(ElementSistem element);
    ElementSistem getElement(int index);
}

// 2. Leaf (Frunza - nu poate conține alte elemente)
public class FisierTxt implements ElementSistem {
    private String nume;

    public FisierTxt(String nume) { this.nume = nume; }

    @Override
    public void printeazaNume() {
        System.out.println("   [Fișier] " + nume + ".txt");
    }

    @Override
    public void adauga(ElementSistem element) {
        throw new UnsupportedOperationException("Un fișier nu poate conține alte elemente!");
    }

    @Override
    public void sterge(ElementSistem element) {
        throw new UnsupportedOperationException("Operațiune invalidă.");
    }

    @Override
    public ElementSistem getElement(int index) {
        throw new UnsupportedOperationException("Operațiune invalidă.");
    }
}

// 3. Composite (Containerul - poate conține alte fișiere sau directoare)
import java.util.ArrayList;
import java.util.List;

public class Director implements ElementSistem {
    private String nume;
    private List<ElementSistem> elemente = new ArrayList<>();

    public Director(String nume) { this.nume = nume; }

    @Override
    public void adauga(ElementSistem element) { elemente.add(element); }

    @Override
    public void sterge(ElementSistem element) { elemente.remove(element); }

    @Override
    public ElementSistem getElement(int index) { return elemente.get(index); }

    @Override
    public void printeazaNume() {
        System.out.println("📂 [Director] " + nume);
        // Delegăm operația către toți copiii
        for (ElementSistem element : elemente) {
            element.printeazaNume(); 
        }
    }
}

// 4. Clientul (Main)
public class Main {
    public static void main(String[] args) {
        Director root = new Director("C:");
        Director docs = new Director("Documente");
        FisierTxt f1 = new FisierTxt("ProiectCTS");
        FisierTxt f2 = new FisierTxt("Parole");

        docs.adauga(f1);
        root.adauga(docs);
        root.adauga(f2);

        // Apelul pe rădăcină va parcurge tot arborele automat!
        root.printeazaNume(); 
    }
}
```

