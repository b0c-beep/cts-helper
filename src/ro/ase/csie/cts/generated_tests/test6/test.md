### Se dezvoltă o aplicație software destinată unei platforme de livrare a comenzilor la domiciliu.

**3p.** Platforma integrează mai mulți furnizori externi de servicii de curierat (fiecare cu propriul API și model de date). Aplicația internă lucrează cu un format standard de livrare, cu metode pentru obținerea adresei de destinație, greutății coletului și timpului estimat de livrare. Se cere integrarea unui serviciu extern de curierat fără modificarea clasei externe și fără alterarea codului intern de procesare a livrărilor. Implementarea pornește de la interfața `AbstractLivrare`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractLivrare {
>     String getAdresaDestinatie();
>     double getGreutateKg();
>     int getTimpEstimatMinute();
>     void confirmaLivrare();
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Procesarea unei livrări interne în format standard.
- Procesarea unei livrări provenite de la un serviciu extern de curierat.
- Utilizarea aceluiași modul de gestionare pentru ambele tipuri de livrări.
---

**3p.** Platforma trebuie să notifice în timp real mai mulți actori atunci când statusul unei comenzi se schimbă (de exemplu: comandă plasată → în curs de preparare → ridicată de curier → livrată). Actorii interesați sunt: clientul (primește SMS/notificare push), restaurantul (actualizează starea comenzii), curierul (primește instrucțiuni), serviciul de facturare (emite bon fiscal). Fiecare actor reacționează diferit la schimbarea de status. Implementarea va folosi interfața `AbstractObservatorComanda`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractObservatorComanda {
>     void onStatusSchimbat(String idComanda, String statusNou);
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Crearea unei comenzi cu minim 3 observatori înregistrați.
- Simularea a cel puțin 3 tranziții de status și demonstrarea că toți observatorii sunt notificați.
- Dezabonarea unui observator și demonstrarea că acesta nu mai primește notificări ulterioare.