# Design Pattern: Facade

## 1. Prezentare Teoretică

**Tip:** Șablon Structural  
**Definiție:** Oferă o interfață unificată, de nivel înalt, care simplifică interacțiunea cu un subsistem complex format din mai multe clase sau interfețe.

**La ce folosește (Scenarii de utilizare):**
* Când vrei să ascunzi complexitatea unui sistem ("spaghetti code" sau zeci de clase cu setări complicate) în spatele unei singure metode simple apelabile de client.
* Când vrei să decuplezi codul clientului de o librărie externă complexă, astfel încât, dacă librăria se schimbă, să modifici doar Facade-ul, nu toată aplicația.

**Avantaje / Dezavantaje:**
* **+** Simplifică enorm viața dezvoltatorilor care folosesc codul (principiul *KISS - Keep It Simple, Stupid*).
* **+** Reduce cuplarea strânsă între client și componentele subsistemului.
* **-** *Riscul principal:* Facade-ul poate deveni un "God Object" (un obiect omnipotent care știe și face prea multe) dacă agregă absolut toate funcționalitățile aplicației.

---

## 2. Exemplu de Implementare (Sistemul Home Theater)

**Scenariu:** Pentru a te uita la un film acasă, trebuie să reduci luminile, să pornești TV-ul, să setezi sursa pe Netflix, să pornești sistemul audio și să setezi volumul. În loc să chemi toate aceste metode individual de fiecare dată, construim o "Fațadă".

```java
// --- 1. SUBSISTEMUL COMPLEX (Clase pe care vrem să le ascundem) ---

class Televizor {
    public void porneste() { System.out.println("TV: A fost pornit."); }
    public void seteazaSursa(String sursa) { System.out.println("TV: Sursa setată pe " + sursa); }
}

class SistemAudio {
    public void porneste() { System.out.println("Audio: Sistemul a fost pornit."); }
    public void seteazaVolum(int nivel) { System.out.println("Audio: Volumul setat la " + nivel); }
}

class Iluminat {
    public void scadeIntensitatea() { System.out.println("Lumini: Intensitate redusă la 10% (Mod Cinema)."); }
}


// --- 2. FACADE (Interfața simplificată pentru client) ---

class HomeTheaterFacade {
    private Televizor tv;
    private SistemAudio audio;
    private Iluminat lumini;

    public HomeTheaterFacade(Televizor tv, SistemAudio audio, Iluminat lumini) {
        this.tv = tv;
        this.audio = audio;
        this.lumini = lumini;
    }

    // Metoda "magică" ce rutează complexitatea
    public void pregatesteSearaDeFilm() {
        System.out.println("\n--- Se pregătește seara de film... ---");
        lumini.scadeIntensitatea();
        tv.porneste();
        tv.seteazaSursa("Netflix");
        audio.porneste();
        audio.seteazaVolum(25);
        System.out.println("--- Totul este gata. Vizionare plăcută! ---");
    }
}


// --- 3. CLIENTUL (Main) ---

public class Main {
    public static void main(String[] args) {
        // Inițializăm subsistemul (de obicei, Facade-ul ar putea face și asta intern)
        Televizor tv = new Televizor();
        SistemAudio audio = new SistemAudio();
        Iluminat lumini = new Iluminat();

        // Clientul discută DOAR cu Fațada
        HomeTheaterFacade facade = new HomeTheaterFacade(tv, audio, lumini);
        
        // Un singur apel de metodă ascunde 5 apeluri complexe în spate
        facade.pregatesteSearaDeFilm();
    }
}
```

Ca diferență mentală clară față de restul:
* **Adapter:** Face un obiect să arate ca *altul*.
* **Proxy:** Funcționează ca un *paznic* pentru un obiect.
* **Facade:** Acționează ca o *recepție* pentru un întreg hotel de obiecte.


