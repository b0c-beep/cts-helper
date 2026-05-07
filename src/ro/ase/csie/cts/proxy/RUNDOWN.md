# Design Pattern: Proxy

## 1. Prezentare Teoretică

**Tip:** Șablon Structural  
**Definiție:** Oferă un surogat (un înlocuitor sau un intermediar) pentru un alt obiect pentru a controla accesul la acesta. Proxy-ul implementează exact aceeași interfață ca și obiectul real.

**La ce folosește (Scenarii de utilizare):**
* Când obiectul real consumă multe resurse (memorie, rețea) și vrei să-l instanțiezi doar când este absolut necesar (*Lazy Loading*).
* Când vrei să adaugi un strat de securitate (verificarea permisiunilor) înainte de a permite accesul la obiectul real.
* Când vrei să ții un jurnal (log) cu cine și când a accesat obiectul real.

**Avantaje / Dezavantaje:**
* **+** Decuplează clientul de logica de securitate, caching sau inițializare.
* **+** Respectă Open/Closed Principle (OCP): poți adăuga un proxy nou fără să modifici obiectul real sau clientul.
* **-** Poate încetini execuția, introducând un pas suplimentar.
* **-** Crește numărul de clase din arhitectură.

**Tipuri principale de Proxy (foarte important la CTS):**
1. **Virtual Proxy:** Controlează accesul la un obiect "greu". Îl creează doar atunci când i se cere explicit o acțiune (ex: încarcă o imagine de 50MB doar când utilizatorul dă scroll până la ea).
2. **Protection Proxy:** Verifică drepturile de acces. Blochează apelul dacă clientul nu are permisiuni (ex: permite apelul metodei `stergeUtilizator()` doar dacă rolul este 'Admin').
3. **Cache Proxy:** Returnează date salvate anterior pentru a evita operațiuni costisitoare sau interogări repetitive la o bază de date.
4. **Remote Proxy:** Acționează ca un reprezentant local pentru un obiect aflat pe un alt server (comunicare prin rețea).

---

## 2. Exemplu de Implementare (Protection & Virtual Proxy)

**Scenariu:** Avem un document confidențial. Vrem ca el să fie încărcat în memorie și citit **doar** dacă utilizatorul care cere asta are rolul de "Manager".

```java
// 1. Interfața comună (Target)
public interface IDocument {
    void citesteDocument();
}

// 2. Obiectul Real (Real Subject)
// Să presupunem că instanțierea acestei clase consumă multă memorie
public class DocumentSecret implements IDocument {
    
    public DocumentSecret() {
        System.out.println("-> [Sistem] Se încarcă un document masiv în memorie...");
    }
    
    @Override
    public void citesteDocument() {
        System.out.println("Datele financiare confidențiale: Profit +25%.");
    }
}

// 3. Proxy-ul (Intermediarul)
public class DocumentProxy implements IDocument {
    private DocumentSecret documentReal; // Referința ascunsă către obiectul real
    private String rolUtilizator;

    public DocumentProxy(String rolUtilizator) {
        this.rolUtilizator = rolUtilizator;
        // Observație: NU instanțiem DocumentSecret aici! (Lazy Loading)
    }

    @Override
    public void citesteDocument() {
        // Logica adăugată de proxy (Protection: Securitate)
        if ("Manager".equalsIgnoreCase(rolUtilizator)) {
            
            // Instanțiere întârziată (Virtual: Lazy Initialization)
            if (documentReal == null) {
                documentReal = new DocumentSecret();
            }
            
            // Delegare către obiectul real
            documentReal.citesteDocument(); 
        } else {
            System.out.println("ACCES RESPINS: Nu ai permisiunea să citești acest document!");
        }
    }
}

// 4. Clientul (Aplicația / Main)
public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Testare Angajat Simplu ---");
        IDocument proxyAngajat = new DocumentProxy("Angajat");
        // Obiectul real nu se încarcă în memorie, accesul este blocat instant
        proxyAngajat.citesteDocument(); 

        System.out.println("\n--- Testare Manager ---");
        IDocument proxyManager = new DocumentProxy("Manager");
        // Obiectul real se încarcă ACUM și datele sunt afișate
        proxyManager.citesteDocument(); 
    }
}