### Se dezvoltă o aplicație software destinată unei platforme de streaming muzical.

**3p.** Platforma integrează surse externe de muzică (de exemplu, un serviciu third-party cu propriul model de pistă audio). Aplicația internă procesează doar piese în format standard, cu metode pentru obținerea titlului, artistului și duratei. Se cere integrarea unei piese externe în fluxul existent de redare, fără modificarea clasei externe și fără schimbarea codului intern de procesare.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractPiesa {
>     String obtineTitlu();
>     String obtineArtist();
>     int obtineDurataSecunde();
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Redarea unei piese interne în format standard.
- Redarea unei piese provenite dintr-un sistem extern.
- Utilizarea aceluiași player pentru ambele cazuri.
- Evidențierea clasei externe integrate.
---

**3p.** Platforma trebuie să notifice în timp real mai mulți ascultători (utilizatori abonați la un playlist colaborativ) atunci când o piesă nouă este adăugată la playlist. Fiecare ascultător reacționează diferit la notificare (de exemplu: actualizează coada de redare, trimite o notificare push, loghează evenimentul). Mecanismul de notificare trebuie implementat prin derivarea interfeței `AbstractAscultatorPlaylist`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractAscultatorPlaylist {
>     void onPiesaAdaugata(String titluPiesa, String artist);
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Crearea unui playlist colaborativ cu minim 3 ascultători înregistrați.
- Adăugarea a cel puțin 2 piese și demonstrarea că toți ascultătorii sunt notificați.
- Dezabonarea unui ascultător și demonstrarea că acesta nu mai primește notificări.