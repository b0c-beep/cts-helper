### Se dezvoltă o aplicație software destinată unui lanț hotelier internațional.

**3p.** Hotelul oferă camere de bază, dar clienții pot solicita servicii suplimentare opționale: mic dejun inclus, acces la spa, parcare privată. Fiecare serviciu adaugă un cost suplimentar la prețul camerei de bază. Se dorește un mecanism flexibil prin care serviciile să poată fi adăugate dinamic, fără a modifica clasa camerei de bază, și prin care combinațiile de servicii să poată fi extinse ușor în viitor. Implementarea trebuie să pornească de la interfața `AbstractCameraHotel`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractCameraHotel {
>     String getDescriere();
>     double getPretPerNoapte();
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Crearea a cel puțin 2 tipuri de camere de bază.
- Aplicarea a minim 2 servicii suplimentare pe aceeași cameră.
- Afișarea descrierii complete și a prețului total.
---

**3p.** Recepția hotelului gestionează operațiuni complexe: check-in, check-out, atribuire cameră, comandă room-service, solicitare taxi. Fiecare operațiune implică interacțiunea dintre mai multe subsisteme independente (sistem rezervări, sistem facturare, sistem menaj, serviciu transport). Se dorește simplificarea interacțiunii recepționerului cu toate aceste subsisteme printr-un singur punct de acces unificat. Implementarea va folosi interfața `AbstractReceptie`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractReceptie {
>     void proceseazaCheckIn(String numeClient, int nrCamera);
>     void proceseazaCheckOut(String numeClient);
>     void solicitaServiciuSuplimentar(String numeClient, String serviciu);
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Simularea unui flux complet: check-in, comandă serviciu suplimentar, check-out pentru minim 2 clienți.
- Demonstrarea că recepționerul interacționează doar cu punctul de acces unificat.