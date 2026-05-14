# Design Pattern: Strategy

## 1. Prezentare Teoretică

**Tip:** Șablon Comportamental (Behavioral)  
**Definiție:** Definește o familie de algoritmi, îi încapsulează pe fiecare în clase separate și îi face interschimbabili. Permite schimbarea algoritmului (strategiei) la runtime (în timpul rulării programului), independent de clientul care îl folosește.

**La ce folosește (Scenarii de utilizare):**
* **Sisteme de Plată:** Utilizatorul la checkout alege cum vrea să plătească (Card, PayPal, Revolut, Crypto).
* **Aplicații GPS (Google Maps):** Calcularea rutei în funcție de modul de transport (Mașină, Pieton, Bicicletă).
* **Filtre / Sortări:** Sortarea unei liste de produse (Preț Crescător, Preț Descrescător, Alfabetic).

**Structura Clasică:**
1. **Strategy (Interfața):** Contractul comun pentru toți algoritmii (ex: `calculeaza()`, `plateste()`).
2. **Concrete Strategies:** Clasele care implementează diferit interfața (ex: `PlataCard`, `PlataPayPal`).
3. **Contextul (Clientul):** Clasa care folosește strategia. Păstrează o referință către interfața Strategy și oferă o metodă pentru a schimba strategia din mers (`setStrategy()`).

**Avantaje / Dezavantaje:**
* **+** Elimină complet structurile lungi și urâte de tip `if-else` sau `switch`.
* **+** Respectă la perfecție **Open/Closed Principle**: dacă vrei să adaugi o metodă nouă de plată, creezi o clasă nouă fără să te atingi de codul existent.
* **+** Respectă **Single Responsibility Principle**: fiecare algoritm stă în clasa lui.
* **-** Clientul (codul din Main) trebuie să cunoască diferențele dintre strategii pentru a ști pe care să o seteze.

---

## 2. Exemplu de Implementare (Sistemul de Plăți E-commerce)

**Scenariu:** Avem un magazin online. La finalizarea comenzii, clientul poate alege dinamic cum dorește să achite suma.

```java
// 1. STRATEGY (Contractul comun pentru toate metodele de plată)
interface ModPlata {
    void efectueazaPlata(double suma);
}

// 2. CONCRETE STRATEGIES (Algoritmii / Metodele efective)
class PlataCard implements ModPlata {
    private String numarCard;

    public PlataCard(String numarCard) { this.numarCard = numarCard; }

    @Override
    public void efectueazaPlata(double suma) {
        System.out.println("S-au plătit " + suma + " RON folosind Cardul: " + numarCard);
        System.out.println(" -> Se contactează procesatorul bancar...");
    }
}

class PlataPayPal implements ModPlata {
    private String email;

    public PlataPayPal(String email) { this.email = email; }

    @Override
    public void efectueazaPlata(double suma) {
        System.out.println("S-au plătit " + suma + " RON folosind contul PayPal: " + email);
        System.out.println(" -> Se face redirect către serverele PayPal...");
    }
}

// 3. CONTEXTUL (Clasa care folosește strategia - Cosul de cumparaturi)
class CosCumparaturi {
    private double totalDePlata;
    private ModPlata strategiePlata; // Referința către interfață!

    public CosCumparaturi(double totalDePlata) {
        this.totalDePlata = totalDePlata;
    }

    // Aici e magia: schimbăm algoritmul din mers
    public void setStrategiePlata(ModPlata strategie) {
        this.strategiePlata = strategie;
    }

    public void platesteComanda() {
        if (strategiePlata == null) {
            System.out.println("Te rog să alegi o metodă de plată mai întâi!");
            return;
        }
        // Contextul nu știe CUM se face plata, doar îi spune strategiei să o facă
        strategiePlata.efectueazaPlata(totalDePlata);
    }
}

// 4. CLIENT (Main)
public class Main {
    public static void main(String[] args) {
        CosCumparaturi cos = new CosCumparaturi(150.50);

        System.out.println("--- Clientul alege plata cu Cardul ---");
        cos.setStrategiePlata(new PlataCard("1234-5678-9012-3456"));
        cos.platesteComanda();

        System.out.println("\n--- Dă eroare cardul. Clientul schimbă pe PayPal ---");
        // Schimbăm strategia la runtime, fără să recreăm coșul de cumpărături!
        cos.setStrategiePlata(new PlataPayPal("ion@email.com"));
        cos.platesteComanda();
    }
}
```