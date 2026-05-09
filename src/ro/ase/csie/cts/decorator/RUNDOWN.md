# Design Pattern: Decorator

## 1. Prezentare Teoretică

**Tip:** Șablon Structural  
**Definiție:** Permite adăugarea de noi funcționalități sau comportamente unui obiect existent în mod dinamic, fără a modifica structura claselor și fără a afecta alte obiecte din aceeași clasă.

**La ce folosește (Scenarii de utilizare):**
* Pentru a evita **"Explozia de clase"**. Dacă ai o clasă `Cafea` și vrei variante cu Lapte, cu Zahăr și cu Caramel, prin moștenire ar trebui să faci `CafeaCuLapte`, `CafeaCuZahar`, `CafeaCuLapteSiZahar`, `CafeaCuCaramel` etc. (Zeci de clase!). Cu Decorator, faci doar 3 clase mici și le combini cum vrei.
* Când vrei să adaugi o responsabilitate extra unui obiect temporar (ex: adăugarea unui efect de "Foc" sabiei unui erou din joc doar pentru 10 secunde).

**Conceptele Cheie:**
Bazează-se masiv pe principiul **Compoziție în loc de Moștenire**. Un Decorator *este* de același tip cu obiectul pe care îl decorează (implementează aceeași interfață), dar și *conține* o instanță a acelui obiect.

**Avantaje / Dezavantaje:**
* **+** Flexibilitate maximă: poți combina zeci de decoratoare în orice ordine.
* **+** Respectă Open/Closed Principle și Single Responsibility Principle.
* **-** Poate genera o mulțime de obiecte foarte mici.
* **-** Codul de instanțiere poate arăta cam urât dacă adaugi 5-6 straturi (ex: `new Lapte(new Zahar(new Caramel(new Cafea())))`).

---

## 2. Exemplu de Implementare (Sistemul de Comenzi la Cafenea)

**Scenariu:** Un sistem de calculat prețul pentru o cafenea. Avem o cafea de bază, peste care clienții pot adăuga (decora) diverse topping-uri.

```java
// 1. Componenta de Bază (Interfața)
public interface Bautura {
    String getDescriere();
    double getCost();
}

// 2. Componenta Concretă (Obiectul care va fi decorat)
public class CafeaSimpla implements Bautura {
    @Override
    public String getDescriere() { return "Cafea simplă"; }

    @Override
    public double getCost() { return 10.0; } // Prețul de bază
}

// 3. DECORATORUL DE BAZĂ (Clasa abstractă esențială pentru acest pattern)
// Implementează interfața, dar are și o referință către ea!
public abstract class DecoratorBautura implements Bautura {
    protected Bautura bauturaDecorata; // Referința (Matrioșka din interior)

    public DecoratorBautura(Bautura bautura) {
        this.bauturaDecorata = bautura;
    }

    @Override
    public String getDescriere() {
        return bauturaDecorata.getDescriere(); // Deleagă apelul către interior
    }

    @Override
    public double getCost() {
        return bauturaDecorata.getCost(); // Deleagă apelul către interior
    }
}

// 4. Decoratoare Concrete (Straturile extra)
public class Lapte extends DecoratorBautura {
    public Lapte(Bautura bautura) { super(bautura); }

    @Override
    public String getDescriere() {
        return super.getDescriere() + ", cu Lapte";
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.0; // Adaugă 3 RON la preț
    }
}

public class Caramel extends DecoratorBautura {
    public Caramel(Bautura bautura) { super(bautura); }

    @Override
    public String getDescriere() {
        return super.getDescriere() + ", cu Caramel";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.0; // Adaugă 5 RON la preț
    }
}

// 5. Clientul (Main)
public class Main {
    public static void main(String[] args) {
        // Vrem o cafea cu lapte și caramel
        Bautura comandaMea = new CafeaSimpla(); // Stratul de bază
        comandaMea = new Lapte(comandaMea);     // O împachetăm în Lapte
        comandaMea = new Caramel(comandaMea);   // O împachetăm în Caramel

        // Apelează metodele din exterior spre interior!
        System.out.println("Comandă: " + comandaMea.getDescriere());
        System.out.println("Total de plată: " + comandaMea.getCost() + " RON");
    }
}
```