# Design Pattern: Observer

## 1. Prezentare Teoretică

**Tip:** Șablon Comportamental (Behavioral)  
**Definiție:** Definește o dependență de tip "unu-la-mulți" (one-to-many) între obiecte, astfel încât, atunci când un obiect își schimbă starea, toate obiectele dependente de el sunt notificate și actualizate automat.

**La ce folosește (Scenarii de utilizare):**
* **Sisteme de Abonamente / Newslettere:** Un canal de YouTube postează un clip, iar toți cei 1.000.000 de abonați primesc notificare pe telefon.
* **Interfețe Grafice (UI):** Dai click pe un buton (Subiectul), iar mai multe ferestre sau texte (Observatorii) se actualizează pe ecran.
* **Bursa de Valori:** O acțiune (ex: Apple) își schimbă prețul, iar toate ecranele brokerilor se actualizează automat.

**Structura Clasică (Cei 2 Actori Principali):**
1. **Subject / Publisher (Canalul / Emițătorul):** Cel care deține informația de interes. Are metode pentru a adăuga (subscribe), șterge (unsubscribe) și notifica observatorii.
2. **Observer / Subscriber (Abonatul):** Interfața pe care o implementează toți cei care vor să fie la curent cu noutățile (conține metoda de `update()`).

**Avantaje / Dezavantaje:**
* **+** Respectă **Open/Closed Principle**: Poți adăuga noi tipuri de observatori fără să modifici deloc clasa Subiectului.
* **+** Creează relații la runtime (dinamic). Te poți abona și dezabona oricând.
* **-** Dacă nu ai grijă să "dezabonezi" (unsubscribe) obiectele atunci când nu mai ai nevoie de ele, poți crea **Memory Leaks** (problema "Lapsed Listener").

---

## 2. Exemplu de Implementare (Sistemul YouTube)

**Scenariu:** Un canal de YouTube postează videoclipuri noi. Diferiți utilizatori (abonați) trebuie să primească notificări, dar numai atâta timp cât sunt abonați.

```java
import java.util.ArrayList;
import java.util.List;

// 1. OBSERVER (Contractul pentru toți abonații)
interface UtilizatorYouTube {
    void primesteNotificare(String numeCanal, String titluVideo);
}

// 2. SUBJECT (Contractul pentru emițător)
interface CanalYouTube {
    void aboneaza(UtilizatorYouTube utilizator);
    void dezaboneaza(UtilizatorYouTube utilizator);
    void notificaAbonatii(String titluVideo);
}

// 3. CONCRETE SUBJECT (Canalul efectiv)
class CanalDeGaming implements CanalYouTube {
    private String nume;
    private List<UtilizatorYouTube> abonati = new ArrayList<>();

    public CanalDeGaming(String nume) { this.nume = nume; }

    @Override
    public void aboneaza(UtilizatorYouTube utilizator) {
        abonati.add(utilizator);
    }

    @Override
    public void dezaboneaza(UtilizatorYouTube utilizator) {
        abonati.remove(utilizator);
    }

    @Override
    public void notificaAbonatii(String titluVideo) {
        System.out.println("\n[" + nume + "] Notificăm toți cei " + abonati.size() + " abonați...");
        for (UtilizatorYouTube abonat : abonati) {
            abonat.primesteNotificare(nume, titluVideo);
        }
    }

    // Metoda de business care declanșează notificarea
    public void posteazaVideoclipNou(String titlu) {
        System.out.println("\n--- " + nume + " a încărcat un clip nou: " + titlu + " ---");
        notificaAbonatii(titlu);
    }
}

// 4. CONCRETE OBSERVERS (Abonații)
class AbonatFidel implements UtilizatorYouTube {
    private String numeAbonat;

    public AbonatFidel(String numeAbonat) { this.numeAbonat = numeAbonat; }

    @Override
    public void primesteNotificare(String numeCanal, String titluVideo) {
        System.out.println(" 🔔 [" + numeAbonat + "] AI O NOTIFICARE NOUĂ: " + numeCanal + " a postat '" + titluVideo + "'");
    }
}

// 5. CLIENT (Main)
public class Main {
    public static void main(String[] args) {
        CanalDeGaming canal = new CanalDeGaming("SuperGamer99");

        UtilizatorYouTube user1 = new AbonatFidel("Ion");
        UtilizatorYouTube user2 = new AbonatFidel("Maria");
        UtilizatorYouTube user3 = new AbonatFidel("Andrei");

        // Utilizatorii se abonează
        canal.aboneaza(user1);
        canal.aboneaza(user2);
        canal.aboneaza(user3);

        // Canalul postează un clip -> Toți 3 primesc notificare
        canal.posteazaVideoclipNou("Top 10 Jocuri din 2024");

        // Andrei se plictisește și dă Unsubscribe
        System.out.println("\n* Andrei a dat unsubscribe *");
        canal.dezaboneaza(user3);

        // Canalul postează iar -> Doar Ion și Maria primesc
        canal.posteazaVideoclipNou("Cum să bați boss-ul final");
    }
}
```