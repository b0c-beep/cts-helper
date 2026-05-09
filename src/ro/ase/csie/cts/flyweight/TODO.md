# Subiect de Lucru: Șablonul Flyweight

## 🏢 Scenariul: Gestiunea Inamicilor într-un RPG (Video Game)

Lucrezi la un joc RPG (Role-Playing Game) în care jucătorul trebuie să supraviețuiască unor valuri masive de inamici. La nivelul 10, pe hartă trebuie să apară **10.000 de Orci** și **5.000 de Troli**.

Fiecare inamic are nevoie de un model 3D complex, texturi de înaltă rezoluție și animații grele (care ocupă aproximativ 50MB per inamic). Dacă le instanțiezi clasic, jocul va consuma 750 GB de RAM și va crăpa instantaneu.

Trebuie să optimizezi generarea inamicilor folosind **Flyweight Pattern**. Vei separa datele grele (modelul, textura) care sunt aceleași pentru toți Orcii, de datele ușoare (coordonatele X, Y pe hartă și viața curentă) care diferă de la un inamic la altul.

---

## 📝 Cerințe de rezolvare

### 1. Starea Extrinsecă (Contextul: `ContextInamic`)
* Creează clasa `ContextInamic`.
* **Atribute:** `x` (int), `y` (int), `viataCurenta` (int).
* Creează un constructor pentru inițializarea lor. Aceste date vor fi trimise la randare.

### 2. Starea Intrinsecă (Flyweight-ul: `ModelInamic3D`)
* Creează interfața `InamicFlyweight` cu metoda `deseneaza(ContextInamic context)`.
* Creează clasa `ModelInamic3D` care implementează `InamicFlyweight`.
* **Atribute grele:** `tipInamic` (String - ex: "Orc", "Trol"), `fisierModel3D` (String), `fisierTextura` (String).
* Aceste atribute trebuie setate **doar prin constructor** (sunt imutabile).
* **Implementează `deseneaza(ContextInamic context)`:** Afișează la consolă un mesaj care combină datele intrinseci cu cele extrinseci (ex: *"Se randează [Orc] cu textura [orc_base.png] la coordonatele X: 10, Y: 20 având HP: 100"*).

### 3. Fabrica de Flyweight (`FabricaInamici`)
* Creează clasa `FabricaInamici`.
* Folosește un `HashMap<String, InamicFlyweight>` pentru a memora modelele 3D deja încărcate (ex: cheia este tipul, valoarea este modelul).
* **Metoda `getModel(String tipInamic)`:** * Verifică dacă tipul cerut (ex: "Orc") există deja în dicționar.
    * Dacă DA, returnează-l pe cel existent.
    * Dacă NU, creează un nou `ModelInamic3D` cu nume de fișiere inventate (ex: `fisierModel3D` = `tipInamic + ".obj"`).
    * Afișează în consolă mesajul: *"-> S-a alocat memorie pentru un model NOU: " + tipInamic*.
    * Salvează-l în HashMap și apoi returnează-l.

### 4. Clasa Main (Clientul)
* Cere fabricii modelul pentru "Orc" de 3 ori și randează-l folosind 3 instanțe diferite de `ContextInamic` (coordonate diferite).
* Cere fabricii modelul pentru "Trol" de 2 ori și randează-l cu alte coordonate.
* *Testul suprem:* Dacă ai implementat corect, mesajul *"-> S-a alocat memorie..."* trebuie să apară **de exact 2 ori** în consolă (o dată pentru Orc, o dată pentru Trol), deși tu ai desenat 5 inamici pe ecran!