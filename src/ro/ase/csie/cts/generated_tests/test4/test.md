### Se dezvoltă o aplicație software destinată unei platforme de e-learning.

**3p.** Platforma organizează conținutul educațional în module, lecții și cursuri complete. Un curs conține module, un modul conține lecții, iar o lecție este elementul de bază. Se dorește calcularea recursivă a duratei totale a unui curs sau modul, precum și verificarea faptului că un curs nu depășește durata maximă admisă pentru un certificat. Toate elementele de conținut trebuie tratate uniform. Implementarea pornește de la interfața `AbstractElementCurs`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractElementCurs {
>     int calculeazaDurataMinute();
>     boolean verificaDurata(int durataMaximaMinute);
>     String getTitlu();
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Crearea a cel puțin 3 lecții simple cu durate diferite.
- Agregarea lor în module și a modulelor într-un curs.
- Calcularea duratei totale a cursului.
- Verificarea că durata nu depășește o limită impusă.
---

**3p.** Platforma permite instructorilor să aplice diverse strategii de notare a temelor: notare bazată pe punctaj absolut, notare relativă față de media grupei sau notare prin rubrică cu ponderi pe criterii. Fiecare strategie calculează nota finală diferit pe baza acelorași date de intrare. Algoritmul de notare trebuie să poată fi schimbat dinamic, fără a modifica clasa `Tema`. Implementarea va folosi interfața `AbstractStrategieNotare`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractStrategieNotare {
>     double calculeazaNota(double[] puncteObtinute, double punctajMaxim);
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Definirea a cel puțin 3 strategii de notare diferite.
- Aplicarea fiecărei strategii asupra aceleiași teme și compararea rezultatelor.
- Schimbarea dinamică a strategiei de notare la rulare.