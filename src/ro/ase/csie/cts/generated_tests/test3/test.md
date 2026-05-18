### Se dezvoltă o aplicație software pentru gestionarea unui parc de vehicule electrice partajate.

**3p.** Parcul de vehicule conține mii de trotinete și biciclete electrice distribuite în oraș. Fiecare vehicul are un model, producător și culoare, dar starea sa internă (nivelul bateriei, poziția GPS curentă) variază per instanță. Deoarece există foarte multe vehicule de același tip, se dorește eficientizarea consumului de memorie prin partajarea datelor comune între vehiculele de același model. Implementarea pornește de la interfața `AbstractVehiculElectric`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractVehiculElectric {
>     void afiseazaDetalii(int nivelBaterie, String pozitieGPS);
>     String getModel();
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Crearea a minim 5 vehicule folosind cel puțin 2 modele diferite.
- Demonstrarea că obiectele cu același model partajează datele comune (referință identică).
- Afișarea detaliilor fiecărui vehicul cu stare proprie (baterie, poziție).
---

**3p.** Platforma de închiriere permite utilizatorilor să execute operațiuni asupra vehiculelor: deblochează vehicul, blochează vehicul, pornește sesiunea de închiriere, oprește sesiunea și raportează o problemă tehnică. Se dorește un mecanism prin care fiecare operațiune să fie encapsulată ca obiect, astfel încât să poată fi pusă în coadă, anulată sau reexecutată ulterior. Implementarea pornește de la interfața `AbstractComandaVehicul`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractComandaVehicul {
>     void executa();
>     void anuleaza();
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Crearea și executarea a minim 3 comenzi diferite pe vehicule.
- Demonstrarea mecanismului de anulare (undo) pentru cel puțin 2 comenzi executate.