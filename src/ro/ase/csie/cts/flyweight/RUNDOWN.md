# Design Pattern: Flyweight

## 1. Prezentare Teoretică

**Tip:** Șablon Structural  
**Definiție:** Optimizează utilizarea memoriei RAM prin partajarea (sharing) cât mai multor date posibile cu obiecte similare, în loc să păstrezi aceleași date duplicate în fiecare obiect.

**Conceptele Cheie (FOARTE IMPORTANT LA EXAMEN):**
Pentru a aplica Flyweight, trebuie să spargi starea unui obiect în două:
1. **Stare Intrinsecă (Comună / Shared):** Datele care sunt aceleași pentru mai multe obiecte. Acestea sunt stocate *în interiorul* Flyweight-ului și sunt **imutabile** (nu se pot schimba după creare).
2. **Stare Extrinsecă (Unică / Context):** Datele care diferă de la un obiect la altul (ex: coordonatele). Acestea NU sunt stocate în Flyweight, ci sunt *trimise ca parametri* metodelor atunci când e nevoie.

**La ce folosește (Scenarii de utilizare):**
* Când aplicația ta trebuie să creeze un număr masiv de obiecte (zeci de mii, milioane) și memoria RAM devine o problemă.
* Randarea grafică în jocuri (milioane de copaci, particule, gloanțe).
* Editoare de text (milioane de caractere care împart același font și aceeași culoare).

**Avantaje / Dezavantaje:**
* **+** Salvează cantități masive de memorie RAM.
* **-** Crește complexitatea codului (separarea stării în două clase, adăugarea unei fabrici).
* **-** Consumă puțin mai mult timp de procesare (procesorul calculează contextul extrinsec în loc să-l citească direct din memorie).

---

## 2. Exemplu de Implementare (Joc Video - Pădure de Copaci)

**Scenariu:** Vrem să randăm 1.000.000 de copaci. Dacă fiecare copac ar avea intern `Mesh3D (10MB)` și `Textura (5MB)`, am avea nevoie de 15 Terabytes de RAM! Folosind Flyweight, salvăm Mesh-ul și Textura o singură dată pentru fiecare *tip* de copac, iar copacii individuali rețin doar coordonatele X și Y.

```java
import java.util.HashMap;
import java.util.Map;

// 1. Flyweight (Starea Intrinsecă - Comună și Imutabilă)
class TipCopac {
    private String nume;
    private String culoare;
    private String textura3D; // Date grele!

    public TipCopac(String nume, String culoare, String textura3D) {
        this.nume = nume;
        this.culoare = culoare;
        this.textura3D = textura3D;
    }

    // Primește starea extrinsecă prin parametri
    public void afiseaza(int x, int y) {
        System.out.println("S-a randat un " + nume + " (" + culoare + ") la coordonatele: [" + x + ", " + y + "]");
    }
}

// 2. Flyweight Factory (Fabrica ce reciclează obiectele)
class FabricaDeCopaci {
    private static Map<String, TipCopac> tipuri = new HashMap<>();

    public static TipCopac getTipCopac(String nume, String culoare, String textura3D) {
        // Dacă tipul există deja, îl returnăm pe cel salvat în memorie
        TipCopac tip = tipuri.get(nume);
        if (tip == null) {
            tip = new TipCopac(nume, culoare, textura3D);
            tipuri.put(nume, tip);
            System.out.println("-> [Fabrica] A creat un TIP NOU de copac: " + nume);
        }
        return tip;
    }
}

// 3. Clientul / Contextul (Starea Extrinsecă - Unică)
class Copac {
    private int x, y; // Stare unică
    private TipCopac tip; // Referință către starea comună

    public Copac(int x, int y, TipCopac tip) {
        this.x = x;
        this.y = y;
        this.tip = tip;
    }

    public void deseneaza() {
        tip.afiseaza(x, y);
    }
}

// 4. Main
public class Main {
    public static void main(String[] args) {
        // În loc să instanțiem "Mesh-ul" de 3 ori, îl creăm o singură dată!
        TipCopac stejar = FabricaDeCopaci.getTipCopac("Stejar", "Verde", "mesh_stejar.obj");
        
        Copac c1 = new Copac(10, 20, stejar);
        Copac c2 = new Copac(50, 80, stejar);
        
        TipCopac brad = FabricaDeCopaci.getTipCopac("Brad", "Verde Închis", "mesh_brad.obj");
        Copac c3 = new Copac(100, 150, brad);

        c1.deseneaza();
        c2.deseneaza();
        c3.deseneaza();
    }
}
```