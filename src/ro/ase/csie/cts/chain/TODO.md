# Subiect de Lucru: Șablonul Chain of Responsibility

## 🏢 Scenariul: Sistemul de Livrare Colete

Ai o firmă de curierat și vrei să eficientizezi modul în care sunt livrate pachetele, alocând vehiculul potrivit în funcție de **greutatea** coletului.

Regulile companiei sunt următoarele:
1. Coletele foarte ușoare (sub 3 kg) sunt livrate de **Bicicliști** (pentru a evita traficul).
2. Coletele medii (sub 20 kg) sunt livrate cu **Mașina** companiei.
3. Coletele grele sau agabaritice (orice depășește 20 kg) sunt preluate de o **Dubă de marfă**.

Toate coletele care intră în sistem trebuie trimise mai întâi către Bicicliști. Dacă pachetul e prea greu pentru ei, îl dau mai departe la Mașină, și tot așa, până se găsește vehiculul capabil să îl ducă.

---

## 📝 Cerințe de rezolvare

Trebuie să implementezi acest lanț de decizie respectând structura din exemplul cu Call Center-ul:

### 1. Handler-ul Abstract (`HandlerLivrare`)
* Creează clasa abstractă `HandlerLivrare`.
* Adaugă un atribut protejat pentru următoarea verigă din lanț: `protected HandlerLivrare nextHandler;`.
* Creează metoda `public void setNextHandler(HandlerLivrare nextHandler)` pentru a lega obiectele.
* Declară metoda abstractă `public abstract void preiaColet(double greutate);`.

### 2. Veriga 1: `CurierBicicleta`
* Extinde `HandlerLivrare`.
* Definește o constantă pentru limita de greutate (ex: `public static final int LIMITA_BICICLETA = 3;`).
* Implementează `preiaColet(double greutate)`:
    * Dacă greutatea este sub limită, afișează: *"Coletul de " + greutate + " kg a fost preluat de curierul pe bicicletă."*
    * Altfel, dacă `nextHandler` nu este null, dă cererea mai departe.

### 3. Veriga 2: `CurierMasina`
* Extinde `HandlerLivrare`.
* Definește o constantă pentru limită (ex: `public static final int LIMITA_MASINA = 20;`).
* Implementează `preiaColet(double greutate)` exact ca la bicicletă, dar verificând limita mașinii și afișând mesajul corespunzător.

### 4. Veriga 3 (Capătul lanțului): `CurierDuba`
* Extinde `HandlerLivrare`.
* Acesta este capătul de linie! Orice pachet ajunge aici este automat preluat, deci **nu mai are nevoie de nicio verificare (if)** pentru greutate maximă.
* Implementează `preiaColet(double greutate)` și afișează direct: *"Coletul GREU de " + greutate + " kg a fost preluat de duba de marfă."*

### 5. Clasa Main (Testarea)
* Instanțiază cei trei curieri (`Bicicleta`, `Masina`, `Duba`).
* Leagă-i între ei pentru a forma lanțul: `Bicicleta -> Masina -> Duba`.
* Trimite următoarele colete **doar** către prima verigă (Bicicleta) și observă consola:
    1. Un colet de `1.5` kg.
    2. Un colet de `12.0` kg.
    3. Un colet de `45.0` kg.