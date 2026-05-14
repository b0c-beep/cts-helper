# Subiect de Lucru: Șablonul Command

## 🏢 Scenariul: Rutina de dimineață (Asistent Vocal)

Ți-ai cumpărat un asistent vocal inteligent (tip Alexa sau Google Home). Vrei să configurezi o **"Rutină de Dimineață"**.
Când configurezi rutina din aplicație, asistentul vocal nu execută acțiunile pe loc. El doar primește comenzile (ex: "Aprinde lumina", "Fă cafeaua") și le stochează într-o listă.
Abia dimineața, când te trezești și spui *"Bună dimineața"*, asistentul ia lista și execută toate comenzile la rând.

---

## 📝 Cerințe de rezolvare

Implementează acest sistem respectând fix arhitectura de la Restaurant:

### 1. Receiver-ul / Executantul (`SistemSmart`)
* Creează clasa `SistemSmart` (Acesta este echivalentul clasei `Chef`).
* Adaugă două metode simple care doar afișează mesaje la consolă:
    * `aprindeLumini()` -> afișează: *"Luminile din casă au fost aprinse."*
    * `pornesteCafetiera()` -> afișează: *"Cafetiera a început să pregătească cafeaua."*

### 2. Interfața Command (`ComandaSmart`)
* Creează interfața `ComandaSmart` (Echivalentul interfeței `FoodOrder`).
* Definește o singură metodă: `void executa();`.

### 3. Comenzile Concrete (`ComandaLumini` și `ComandaCafea`)
* Creează clasa `ComandaLumini` care implementează `ComandaSmart`.
    * Trebuie să rețină o referință către `SistemSmart` (primită prin constructor).
    * În metoda `executa()`, apelează `aprindeLumini()` de pe sistem.
* Creează clasa `ComandaCafea` care implementează `ComandaSmart`.
    * La fel, reține referința către `SistemSmart`.
    * În metoda `executa()`, apelează `pornesteCafetiera()`.

### 4. Invoker-ul / Asistentul (`AsistentVocal`)
* Creează clasa `AsistentVocal` (Acesta este echivalentul clasei `Waiter`).
* Conține o listă internă de comenzi: `List<ComandaSmart> rutina = new ArrayList<>();`.
* Adaugă metoda `adaugaInRutina(ComandaSmart comanda)` care pune comanda în listă.
* Adaugă metoda `spuneBunaDimineata()`. Această metodă trebuie să:
    * Parcurgă lista cu un `for`.
    * Să apeleze `executa()` pe fiecare comandă.
    * Să golească lista la final (`rutina.clear()`).

### 5. Clasa Main (Testarea)
* Instanțiază "creierul" casei (`SistemSmart`).
* Instanțiază asistentul vocal (`AsistentVocal`).
* Seara, configurează rutina (creează o comandă pentru lumini, una pentru cafea și adaugă-le în asistent).
* Simulează venirea dimineții apelând `spuneBunaDimineata()` pe asistent și verifică dacă se execută ambele acțiuni!