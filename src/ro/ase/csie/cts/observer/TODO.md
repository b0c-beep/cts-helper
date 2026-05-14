# Subiect de Lucru: Șablonul Observer

## 🏢 Scenariul: Alerte de preț pentru un Magazin Online

Ești programator la un magazin online. Clienții sunt foarte interesați de noul model de telefon (ex: "iPhone 15 Pro"), dar li se pare prea scump.
Aplicația le permite să apese pe un buton de **"Adaugă la Favorite / Anunță-mă când scade prețul"**.

De fiecare dată când managerul magazinului modifică prețul telefonului cu o valoare mai mică, sistemul trebuie să trimită automat un mesaj tuturor clienților care s-au abonat la acel produs.

---

## 📝 Cerințe de rezolvare

Vei respecta exact arhitectura pe care ai folosit-o la canalul de YouTube!

### 1. Interfața Abonatului (`Observer`)
* Creează interfața `Observer` (sau folosește-o dacă o ai deja de la exercițiul trecut).
* Definește metoda: `void primesteNotificare(String mesaj);`.

### 2. Clasa Abstractă (`Observable`)
* Creează clasa abstractă `Observable` (Managerul de abonamente).
* Adaugă o listă protejată: `protected List<Observer> abonati = new ArrayList<>();`.
* Creează metodele `subscribe(Observer o)` și `unsubscribe(Observer o)`.
* Creează metoda `notifyObservers(String mesaj)` care parcurge lista și apelează `primesteNotificare` pentru fiecare.

### 3. Subiectul Concret (`ProdusMagazin`)
* Creează clasa `ProdusMagazin` care moștenește `Observable`.
* **Atribute private:** `numeProdus` (String) și `pretCurent` (double).
* Fă un constructor pentru a le inițializa.
* Creează metoda `setPret(double pretNou)`.
    * În interiorul ei, verifică: **Dacă** noul preț este mai mic decât prețul curent, apelează `notifyObservers` cu mesajul: *"Vești bune! Prețul pentru " + numeProdus + " a scăzut la " + pretNou + " RON!"*.
    * După verificare, actualizează `pretCurent = pretNou;`.

### 4. Observatorii Concreți (`ClientFidel`)
* Creează clasa `ClientFidel` care implementează `Observer`.
* **Atribut:** `numeClient` (String) - setat prin constructor.
* Suprascrie metoda `primesteNotificare(String mesaj)` pentru a afișa la consolă: *"Către [" + numeClient + "]: " + mesaj*.

### 5. Clasa Main (Testarea)
* Creează un produs (`ProdusMagazin`) numit "Laptop de Gaming" cu prețul de `5000.0` RON.
* Creează 3 clienți (`ClientFidel`): "Andrei", "Maria", "Ion".
* Andrei și Maria dau `subscribe` la acest produs. Ion nu.
* Simulează trecerea timpului modificând prețul produsului:
    1. `setPret(5500.0)` -> Prețul crește, deci **NU** ar trebui să se trimită notificări.
    2. `setPret(4800.0)` -> Prețul a scăzut! Andrei și Maria ar trebui să primească alerta.
* Maria se răzgândește și dă `unsubscribe`.
* `setPret(4500.0)` -> Prețul scade iar. Acum DOAR Andrei trebuie să primească alerta!