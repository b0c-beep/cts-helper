# Design Pattern: Chain of Responsibility

## 1. Prezentare Teoretică

**Tip:** Șablon Comportamental (Behavioral)  
**Definiție:** Permite pasarea unei cereri (request) de-a lungul unui lanț de componente (handlere). Când primește o cerere, fiecare componentă din lanț decide fie să o proceseze, fie să o dea mai departe către următoarea componentă din lanț.

**La ce folosește (Scenarii de utilizare):**
* Aprobări corporative (Manager -> Director -> CEO).
* Sisteme de logare a erorilor (INFO -> DEBUG -> ERROR). Dacă e o eroare simplă, e scrisă în consolă. Dacă e critică, lanțul o pasează până la modulul care dă un email de alertă.
* Automate bancare (ATM): Bancomatul împarte suma trecând cererea printr-un lanț de distribuitoare (bancnote de 100 -> bancnote de 50 -> bancnote de 10).

**Avantaje / Dezavantaje:**
* **+** Decuplează expeditorul cererii de cel care o procesează. (Clientul doar trimite cererea în lanț, nu îl interesează *cine* o rezolvă).
* **+** Respectă *Single Responsibility Principle* (fiecare clasă din lanț face un singur lucru) și *Open/Closed Principle* (poți adăuga noi handlere fără să strici codul existent).
* **-** *Atenție:* Dacă lanțul nu este configurat corect (sau nu există un "capăt de linie"), cererea poate să iasă din lanț **fără a fi procesată deloc**.

---

## 2. Exemplu de Implementare (Aprobări Financiare)

**Scenariu:** Un angajat cere bani pentru diverse achiziții. Managerul de echipă poate aproba sub 1.000 RON. Directorul poate aproba până în 5.000 RON. Orice depășește această sumă ajunge la CEO.

```java
// 1. Clasa care reprezintă Cererea (ceea ce călătorește pe lanț)
class Achizitie {
    public double suma;
    public String scop;

    public Achizitie(double suma, String scop) {
        this.suma = suma;
        this.scop = scop;
    }
}

// 2. Componenta de bază a lanțului (Handler Abstract)
abstract class HandlerAprobare {
    protected HandlerAprobare succesor; // Următorul șef din lanț

    // Metoda prin care legăm elementele între ele
    public void setSuccesor(HandlerAprobare succesor) {
        this.succesor = succesor;
    }

    // Metoda pe care fiecare o va implementa
    public abstract void proceseazaCerere(Achizitie cerere);
}

// 3. Handlere Concrete (Verigile lanțului)
class Manager extends HandlerAprobare {
    @Override
    public void proceseazaCerere(Achizitie cerere) {
        if (cerere.suma <= 1000) {
            System.out.println("Managerul a aprobat achiziția de " + cerere.suma + " pentru: " + cerere.scop);
        } else if (succesor != null) {
            System.out.println("Managerul nu poate aproba. Pasează la Director...");
            succesor.proceseazaCerere(cerere); // Pasăm mai departe!
        }
    }
}

class Director extends HandlerAprobare {
    @Override
    public void proceseazaCerere(Achizitie cerere) {
        if (cerere.suma <= 5000) {
            System.out.println("Directorul a aprobat achiziția de " + cerere.suma + " pentru: " + cerere.scop);
        } else if (succesor != null) {
            System.out.println("Directorul nu poate aproba. Pasează la CEO...");
            succesor.proceseazaCerere(cerere);
        }
    }
}

class CEO extends HandlerAprobare {
    @Override
    public void proceseazaCerere(Achizitie cerere) {
        // CEO-ul este capătul lanțului, el aprobă orice sumă a rămas
        System.out.println("CEO-ul a aprobat achiziția MAJORĂ de " + cerere.suma + " pentru: " + cerere.scop);
    }
}

// 4. Clientul (Main)
public class Main {
    public static void main(String[] args) {
        // 1. Creăm "verigile"
        HandlerAprobare manager = new Manager();
        HandlerAprobare director = new Director();
        HandlerAprobare ceo = new CEO();

        // 2. Construim lanțul: Manager -> Director -> CEO
        manager.setSuccesor(director);
        director.setSuccesor(ceo);

        // 3. Trimitem cereri către PRIMA verigă din lanț (Manager)
        System.out.println("--- Cererea 1 ---");
        manager.proceseazaCerere(new Achizitie(500, "Scaun birou"));

        System.out.println("\n--- Cererea 2 ---");
        manager.proceseazaCerere(new Achizitie(3500, "Laptop nou"));

        System.out.println("\n--- Cererea 3 ---");
        manager.proceseazaCerere(new Achizitie(15000, "Server Baza de Date"));
    }
}
```