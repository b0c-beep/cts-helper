# Subiect de Lucru: Șablonul Strategy

## 🏢 Scenariul: Sistemul de Analiză a Datelor Financiare

Dezvolți un sistem care analizează încasările zilnice ale unei companii. Sistemul primește un șir de valori (încasările pe mai multe zile) și trebuie să extragă diferite statistici din ele.

Conducerea vrea să poată schimba din interfață algoritmul de analiză: uneori vor să afle **Media Încasărilor**, alteori vor să afle **Încasarea Maximă**. Vei folosi șablonul Strategy pentru a lăsa sistemul să schimbe acești algoritmi la *runtime*.

---

## 📝 Cerințe de rezolvare

### 1. Excepția Custom (`StrategieNesetataException`)
* Creează clasa `StrategieNesetataException` care să extindă `RuntimeException`. Nu e nevoie să adaugi cod suplimentar în ea, doar definește-o (la fel cum ai făcut la `OperationNotSetException`).

### 2. Interfața Strategy (`StrategieAnaliza`)
* Creează interfața `StrategieAnaliza`.
* Definește o singură metodă: `double executaAnaliza(List<Double> valori);`.

### 3. Strategiile Concrete (`Media` și `Maximul`)
* Creează clasa `Media` care implementează `StrategieAnaliza`.
    * În metoda `executaAnaliza`, parcurge lista, adună toate valorile și împarte la dimensiunea listei pentru a returna media aritmetică. (Atenție la împărțirea la zero dacă lista e goală!).
* Creează clasa `Maximul` care implementează `StrategieAnaliza`.
    * În metoda `executaAnaliza`, găsește și returnează cea mai mare valoare din listă.

### 4. Contextul (`AnalizatorDate`)
* Creează clasa `AnalizatorDate` (Echivalentul `Calculatorului`).
* Adaugă un atribut privat: `private StrategieAnaliza strategie;`.
* Creează metoda `setStrategie(StrategieAnaliza strategie)` pentru a schimba algoritmul.
* Creează metoda `public double analizeaza(Double... valori)` (folosește **varargs** pentru a prelua ușor numerele!).
    * În interior, verifică dacă `strategie` este diferită de null.
    * Dacă **ESTE null**, aruncă `StrategieNesetataException`.
    * Dacă **NU este null**, deleagă acțiunea către strategie (transformând varargs în listă cu `List.of(valori)` sau `Arrays.asList(valori)`) și returnează rezultatul.

### 5. Clasa Main (Testarea)
* Creează o instanță de `AnalizatorDate`.
* Încearcă să apelezi `analizeaza(100.5, 200.0, 50.0)` fără a seta strategia. (Ar trebui să primim eroarea custom!). Poți comenta linia după ce vezi că merge.
* Setează strategia `Media`. Apelează `analizeaza(100.0, 200.0, 300.0)` și printează rezultatul (trebuie să dea 200.0).
* Setează strategia `Maximul`. Apelează `analizeaza(150.0, 800.0, 450.0, 10.0)` și printează rezultatul (trebuie să dea 800.0).