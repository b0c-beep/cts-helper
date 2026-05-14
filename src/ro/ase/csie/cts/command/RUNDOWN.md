# Design Pattern: Command

## 1. Prezentare Teoretică

**Tip:** Șablon Comportamental (Behavioral)  
**Definiție:** Încapsulează o cerere (o acțiune) ca pe un obiect separat. Acest lucru permite parametrizarea clienților cu diferite cereri, plasarea cererilor într-o coadă (queue), logarea lor și implementarea mecanismelor de Undo/Redo.

**La ce folosește (Scenarii de utilizare):**
* **Butoane în UI (Interfețe Grafice):** Un buton nu trebuie să știe *cum* să salveze un fișier, el doar declanșează comanda de `SaveCommand`.
* **Cozile de execuție (Job Queues):** Vrei să strângi 100 de tranzacții bancare pe parcursul zilei și să le execuți pe toate noaptea, dintr-un foc.
* **Undo / Redo:** Deoarece comanda este un obiect, îi poți adăuga metoda `undo()` și să păstrezi un istoric (stack) al comenzilor executate.

**Structura Clasică (4 Actori Principali):**
1. **Command (Interfața):** Definește metoda standard `executa()`.
2. **ConcreteCommand (Bilețelul):** Implementează `executa()` apelând metodele specifice de pe Receiver. Aici se stochează și parametrii (ex: suma de bani).
3. **Receiver (Bucătarul):** Clasa care conține logica de business (cel care face munca propriu-zisă).
4. **Invoker (Ospătarul / Butonul):** Cel care primește comanda de la client și o declanșează apelând `executa()`. El nu știe detalii tehnice.

**Avantaje / Dezavantaje:**
* **+** Decuplează complet clasa care declanșează acțiunea (Invoker) de clasa care o execută (Receiver).
* **+** Poți face sisteme de Undo/Redo și Macro-uri (executarea unui set de comenzi).
* **-** Codul devine mai stufos, adăugând multe clase mici pentru fiecare acțiune posibilă.

---

## 2. Exemplu de Implementare (Sistemul de la Restaurant)

```java
// 1. RECEIVER (Bucătarul) - Cel care știe cum se face treaba
class Bucatar {
    public void preparaPizza() { System.out.println("Bucatarul coace o Pizza Margherita."); }
    public void preparaPaste() { System.out.println("Bucatarul fierbe Paste Carbonara."); }
}

// 2. COMMAND INTERFACE (Contractul)
interface IComanda {
    void executa();
}

// 3. CONCRETE COMMANDS (Bilețelele de comandă)
class ComandaPizza implements IComanda {
    private Bucatar bucatar;

    public ComandaPizza(Bucatar bucatar) { this.bucatar = bucatar; }

    @Override
    public void executa() { bucatar.preparaPizza(); }
}

class ComandaPaste implements IComanda {
    private Bucatar bucatar;

    public ComandaPaste(Bucatar bucatar) { this.bucatar = bucatar; }

    @Override
    public void executa() { bucatar.preparaPaste(); }
}

// 4. INVOKER (Ospătarul) - El doar strânge bilețele și dă comanda
import java.util.ArrayList;
import java.util.List;

class Ospatar {
    private List<IComanda> comenziPreluare = new ArrayList<>();

    public void preiaComanda(IComanda comanda) {
        comenziPreluare.add(comanda);
        System.out.println("Ospatar: Am notat comanda!");
    }

    public void trimiteComenziLaBucatarie() {
        System.out.println("\n--- Ospatarul trimite bonurile la bucatarie ---");
        for (IComanda c : comenziPreluare) {
            c.executa(); // Ospatarul habar nu are ce e in comanda, doar striga "Fa-o!"
        }
        comenziPreluare.clear(); // Golește lista după procesare
    }
}

// 5. CLIENT (Main)
public class Main {
    public static void main(String[] args) {
        Bucatar chefSorin = new Bucatar(); // Angajăm un bucătar
        Ospatar ospatarulIon = new Ospatar(); // Angajăm un ospătar

        // Creăm comenzile (bilețelele) pe baza bucătarului
        IComanda c1 = new ComandaPizza(chefSorin);
        IComanda c2 = new ComandaPaste(chefSorin);
        IComanda c3 = new ComandaPizza(chefSorin);

        // Clientul dictează ospătarului
        ospatarulIon.preiaComanda(c1);
        ospatarulIon.preiaComanda(c2);
        ospatarulIon.preiaComanda(c3);

        // Ospătarul se duce la bucătărie
        ospatarulIon.trimiteComenziLaBucatarie();
    }
}
```