# Adapter Pattern

**Tip:** Șablon Structural

**Definiție:** O punte care permite colaborarea între obiecte cu interfețe incompatibile (funcționează ca un adaptor de priză).

**La ce folosește:**
* Integrarea codului vechi (legacy) sau extern (third-party) cu o arhitectură nouă, fără a modifica codul sursă existent.

**Exemple discutate:** 
* Folosirea unui `BusTicketingSystem` printr-o interfață de `TrainTicketingSystem`.
* Apelarea `SignupModule` (`signUp`) printr-o interfață `ILoginable` (`login`).

**Avantaje / Dezavantaje:**
* **+** Respectă OCP și SRP; reutilizează cod valoros.
* **-** Crește complexitatea generală a aplicației (adaugă interfețe/clase noi).

**Tipuri de adaptoare:**
* **Adaptor de Obiect (Recomandat în Java):** * *Cum:* Folosește **compoziția** (deține o instanță a obiectului incompatibil).
    * *Diferența:* Flexibil, compatibil cu subclasele, decuplează codul.
* **Adaptor de Clase:** * *Cum:* Folosește **moștenirea** (extinde clasa incompatibilă).
    * *Diferența:* Permite suprascrierea metodelor clasei vechi, dar este limitat și cuplat strâns (Java permite o singură moștenire).