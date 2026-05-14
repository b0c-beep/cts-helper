# 🧠 Testul Suprem: Recunoașterea Șabloanelor de Proiectare

**Instrucțiuni:** Citește cu atenție fiecare scenariu de mai jos. Pentru fiecare situație descrisă, identifică șablonul de proiectare (din cele 6 studiate: Flyweight, Decorator, Chain of Responsibility, Command, Strategy, Observer) care se potrivește cel mai bine pentru a rezolva problema arhitecturală.

---

### 💻 Scenariile de Arhitectură Software

**Scenariul 1**
O aplicație de smart home gestionează o rețea de senzori și dispozitive. Sistemul central nu trebuie să interogheze constant termostatul pentru a vedea dacă s-a schimbat temperatura. În schimb, dispozitivele precum caloriferele inteligente sau aparatul de aer condiționat se "înscriu" la termostat. Când termostatul detectează o schimbare de temperatură, el trimite automat un semnal către toate dispozitivele înscrise, determinându-le să pornească sau să se oprească în mod sincronizat.

**Scenariul 2**
O platformă complexă de e-commerce trebuie să calculeze costul de livrare pentru clienți. La checkout, clientul poate alege între "Livrare Standard", "Livrare Express" sau "Ridicare din Easybox". În loc ca sistemul să folosească un bloc uriaș de `if-else` pentru a calcula prețul final, fiecare metodă de livrare este încapsulată într-o clasă separată cu un algoritm propriu. Sistemul comută dinamic între acești algoritmi pe baza selecției făcute de client în interfață.

**Scenariul 3**
Dezvolți un editor de text avansat, similar cu Microsoft Word. Într-un document masiv, de mii de pagini, aplicația trebuie să afișeze milioane de caractere pe ecran. Instanțierea unui obiect complet pentru fiecare literă (conținând simbolul, fontul, culoarea, mărimea și coordonatele) ar consuma toată memoria RAM. Sistemul este optimizat astfel încât formaturile grele (ex: litera 'A' în Arial, Bold, 12) sunt salvate o singură dată în memorie, iar obiectele de pe pagină doar fac referire la acest format partajat, stocând local doar poziția X și Y.

**Scenariul 4**
O aplicație pentru o cafenea modernă le permite clienților să își creeze băutura perfectă. Clientul pornește de la o "Cafea de Bază" și poate adăuga, în orice ordine, extra-opțiuni precum Lapte de soia, Sirop de vanilie, Frișcă sau Scorțișoară. În loc ca programatorii să creeze sute de clase de tipul `CafeaCuLapteSiVanilie` sau `CafeaCuFriscaSiScortisoara`, ei "împachetează" obiectul de bază în straturi succesive de funcționalitate. Fiecare strat adaugă propriul cost și propria descriere la rezultatul final.

**Scenariul 5**
Sistemul de "Undo/Redo" dintr-un program de editare grafică (gen Adobe Photoshop). Când utilizatorul desenează o linie, aplică un filtru sau șterge o zonă, aplicația nu execută acțiunea direct pe imagine, ci creează un obiect care conține detaliile acelei acțiuni. Aceste obiecte sunt adăugate într-o stivă (stack). Când utilizatorul apasă `Ctrl+Z`, aplicația scoate ultimul obiect din stivă și îi apelează o metodă care inversează efectul acțiunii.

**Scenariul 6**
Un sistem automatizat de aprobare a creditelor într-o bancă. Când un client solicită un credit, cererea este evaluată mai întâi de un Ofițer de Credit, care poate aproba sume mici. Dacă suma depășește limita ofițerului, cererea este pasată automat către un Manager de Sucursală. Dacă și acesta este depășit de sumă, cererea merge mai departe către un Comitet Director. Cererea călătorește din nivel în nivel până când găsește o entitate cu autoritatea necesară pentru a o aproba sau respinge.

**Scenariul 7**
Aplicația de bursă de pe telefonul tău mobil afișează în timp real evoluția prețului pentru anumite acțiuni (ex: Apple, Tesla, Google). Modificările de preț se întâmplă pe un server central de pe Wall Street. Telefonul tău nu întreabă serverul în fiecare secundă "S-a modificat prețul?". În schimb, telefonul tău este trecut pe o listă de așteptare a serverului pentru acțiunile respective. Când prețul se modifică la sursă, serverul parcurge lista și trimite noul preț către toate telefoanele aflate pe ea.

**Scenariul 8**
O aplicație de procesare a imaginilor oferă utilizatorului posibilitatea de a aplica filtre pe o fotografie (ex: Alb-Negru, Sepia, Blur). Pentru a menține codul curat și extensibil, echipa de dezvoltare a scos logica fiecărui filtru din clasa principală a imaginii. Acum, când utilizatorul face click pe un filtru, aplicația doar schimbă instanța algoritmului de procesare activ în acel moment și îi pasează imaginea pentru a fi transformată, permițând adăugarea de noi filtre în viitor fără a rescrie nucleul aplicației.

**Scenariul 9**
Într-un joc video de strategie în timp real (RTS), jucătorul controlează o armată formată din 10.000 de soldați. Fiecare soldat folosește același model 3D complex, aceleași texturi pentru armură și aceleași fișiere audio pentru pași. Sistemul evită colapsul memoriei video încărcând aceste fișiere media o singură dată într-un obiect central. Soldații individuali de pe hartă mențin doar datele lor unice: câtă viață mai au, direcția în care se deplasează și poziția curentă.

**Scenariul 10**
Dezvolți mecanica de echipamente dintr-un joc RPG. Un personaj de bază are anumite statistici de atac și apărare. Jucătorul îi poate echipa un Scut de Fier, o Sabie de Foc sau o Pelerină Magică. În loc să modifici clasa personajului, creezi obiecte de tip echipament care se mulează în jurul personajului la rulare. Când monstrul atacă personajul, daunele trec mai întâi prin scut, apoi prin pelerină, fiecare modificând rezultatul înainte de a ajunge la personajul de bază.

**Scenariul 11**
O platformă de tranzacționare cripto nu procesează comenzile de cumpărare instantaneu dacă serverul este foarte aglomerat. Când apeși "Cumpără Bitcoin", aplicația ta împachetează intenția ta (tipul monedei, cantitatea, prețul licitat) într-un pachet izolat pe care îl trimite serverului. Serverul pune acest pachet într-o coadă de așteptare. Când îi vine rândul, un modul de execuție desface pachetul și realizează tranzacția efectivă.

**Scenariul 12**
Filtrarea traficului web printr-un sistem de securitate de tip Firewall corporativ. Când un pachet de date încearcă să intre în rețea, trece mai întâi printr-un filtru de adrese IP blocate. Dacă trece, e analizat de un filtru de porturi. Dacă e în regulă, ajunge la un modul de detecție a virușilor. Fiecare punct de control analizează pachetul; dacă găsește o problemă, îl blochează și îl distruge, altfel îl dă mai departe următorului modul de securitate.

**Scenariul 13**
Un sistem de gestionare a newsletter-elor pentru un blog de tehnologie. Cititorii introduc adresa de email într-un formular pentru a fi ținuți la curent. Când autorul publică un articol nou, dă click pe un buton de publicare. Sistemul preia automat titlul și link-ul articolului, parcurge baza de date cu emailuri și declanșează o trimitere în masă. Cititorii pot da "Dezabonare" în orice moment, fiind astfel eliminați din lista care primește alertele.

**Scenariul 14**
Aplicațiile de ridesharing (gen Uber sau Bolt) folosesc mecanisme complexe pentru a calcula prețul unei curse. La ore normale, se folosește un algoritm standard bazat pe kilometri și timp. Dacă afară plouă torențial sau este oră de vârf, sistemul comută automat pe un algoritm de "Tarif Dinamic" (Surge Pricing) care multiplică costul. Schimbarea modului în care se face calculul se face din mers, pe baza contextului curent, folosind familii de algoritmi interschimbabili.

**Scenariul 15**
Aplicația Google Maps randează un oraș întreg pe ecran. Pe hartă există mii de indicatoare rutiere de tip "Cedează trecerea". În loc să încarce imaginea indicatorului și metadatele lui pentru fiecare intersecție în parte, aplicația încarcă modelul vizual al indicatorului într-o zonă comună de memorie. Fiecare intersecție afișează indicatorul folosind o referință către memoria partajată, trimițându-i la momentul desenării doar unghiul de rotație și coordonatele geografice.

**Scenariul 16**
Construiești o bibliotecă de componente de interfață grafică (UI). Ai un obiect de tip `FereastraText` simplu. Uneori vrei ca această fereastră să aibă un scrollbar (bară de derulare), alteori vrei să aibă un chenar gros (border), iar alteori vrei ambele opțiuni. Pentru a adăuga aceste comportamente vizuale, treci fereastra de bază prin alte clase care "desenează" în jurul ei chenarul sau bara de scroll, extinzându-i astfel aspectul fără a modifica codul ferestrei inițiale.

**Scenariul 17**
Un sistem de automatizare a proceselor pe un server (CRON jobs). Un utilizator configurează un backup al bazei de date care să ruleze în fiecare vineri noaptea. Cererea de backup (care include conexiunea la baza de date și tabelele vizate) este salvată ca un obiect de tip sarcină. Vineri noaptea, sistemul ia acest obiect din baza de programări și îi declanșează metoda de execuție, izolând perfect momentul în care s-a cerut acțiunea de momentul în care este realizată.

**Scenariul 18**
Un automat de băuturi și snacks-uri (Vending Machine) trebuie să proceseze bancnotele și monedele introduse. Când introduci o monedă, sistemul încearcă să o valideze. Modulul pentru monede de 50 de bani o verifică; dacă nu o recunoaște, o pasează modulului pentru monede de 10 bani, apoi celui de 5 bani. Dacă niciun modul nu recunoaște obiectul introdus, moneda este respinsă și returnată clientului prin fanta de jos.

**Scenariul 19**
O aplicație de scoruri live pentru fotbal (LiveScore). Utilizatorul bifează "steaua" (Favorite) în dreptul unui meci de Champions League. Începând din acel moment, aplicația este legată la evenimentele acelui meci. Ori de câte ori se marchează un gol, se dă un cartonaș roșu sau se termină repriza, serverul emite un pachet de date, iar aplicația utilizatorului preia instantaneu acele informații și afișează o alertă pop-up pe ecranul telefonului.

**Scenariul 20**
Un program de compresie și arhivare a fișierelor (precum WinRAR sau 7-Zip). Când utilizatorul vrea să arhiveze un folder cu poze, poate selecta nivelul de compresie: "Rapid" (fișier mare, dar termină repede), "Standard" sau "Maxim" (durează mult, dar fișierul e foarte mic). Interfața programului doar preia comanda și înlocuiește dinamic algoritmul de compresie folosit de nucleul aplicației înainte de a începe procesarea propriu-zisă a fișierelor.

**Scenariul 21**
Jocul Minecraft trebuie să afișeze miliarde de blocuri (cuburi) de pământ, piatră și iarbă într-o lume deschisă. În loc să stocheze culoarea, textura și duritatea pentru fiecare dintre cele 2 milioane de cuburi de pământ dintr-un munte, jocul are un singur obiect "Tip_Pământ" în memorie. Jocul stochează pentru hartă doar o matrice tridimensională uriașă în care se specifică ce tip de bloc se află la coordonata (X,Y,Z), reducând dramatic presiunea pe memoria RAM.

**Scenariul 22**
Modulul de export dintr-o aplicație de generare de rapoarte. Raportul de bază este generat în format text simplu. În funcție de nevoile clientului, peste acest text se poate aplica un modul care îl formatează ca tabel HTML, iar peste acesta se poate aplica un alt modul care adaugă un antet și un subsol PDF. Raportul final este rezultatul asamblării dinamice a acestor "învelișuri" la momentul cererii de export.

**Scenariul 23**
O aplicație de tip Telecomandă Universală pe un Smart TV. Pe telecomandă ai butoane colorate (Roșu, Verde, Albastru) care pot face lucruri diferite în funcție de aplicația deschisă (ex: în Netflix butonul Roșu pune pauză, în TV normal butonul Roșu schimbă sursa). Aplicația asociază fiecărui buton un obiect-acțiune. Când apeși butonul, el pur și simplu execută acel obiect, fără să știe ce logică de business ascunde acesta.

**Scenariul 24**
Un sistem de suport tehnic IT cu mai multe niveluri (Tier 1, Tier 2, Tier 3). Când deschizi un ticket de asistență pentru o problemă de parolă, acesta este preluat și rezolvat de robotul de chat. Dacă raportezi că ți s-a stricat laptopul, robotul nu știe să rezolve și trimite ticketul la un tehnician Tier 1. Dacă problema necesită acces la servere, tehnicianul Tier 1 pasează ticketul mai departe la un SysAdmin Tier 3 pentru rezolvare definitivă.

**Scenariul 25**
Rețeaua de socializare X (fostă Twitter). Contul tău urmărește (follow) 50 de creatori de conținut diferiți. De fiecare dată când unul dintre acești creatori postează un mesaj nou, infrastructura rețelei identifică automat toți urmăritorii acelui cont și le inserează mesajul în feed-ul personal. Creatorul nu trebuie să trimită manual mesajul fiecărui urmăritor în parte; el doar anunță sistemul central că are un conținut nou.

**Scenariul 26**
Dezvoltarea unui inamic (AI Boss) într-un joc video. Când inamicul are viața peste 50%, folosește o tactică agresivă, alergând spre jucător. Când viața scade sub 50%, își schimbă complet comportamentul: fuge, se ascunde după obstacole și trage de la distanță. Logica inamicului este decuplată; el deține un loc de memorie pentru "comportamentul curent", iar programul îi înlocuiește pur și simplu algoritmul de luptă pe măsură ce contextul bătăliei se schimbă.

**Scenariul 27**
O aplicație de modelare moleculară pentru cercetare chimică trebuie să afișeze o simulare cu milioane de atomi de Hidrogen și Oxigen. Pentru a funcționa fluid pe calculatoare normale, caracteristicile atomului de Hidrogen (masa atomică, raza, valența) sunt stocate într-o singură instanță izolată. Simularea menține o listă imensă doar cu vectorii de viteză și coordonatele (X,Y,Z) pentru atomii din spațiu, apelând instanța izolată atunci când trebuie să îi deseneze.

**Scenariul 28**
Un sistem bancar de notificare a tranzacțiilor. Când un client face o plată cu cardul, sistemul generează mesajul de bază "Ai plătit 50 RON". Dacă utilizatorul are activat serviciul SMS, un modul înfășoară mesajul și declanșează trimiterea pe telefon. Dacă are și aplicația instalată, un alt modul înfășoară rezultatul precedent și declanșează o notificare de tip Push. Logica de bază a plății nu știe nimic despre cum sunt livrate aceste avertismente suplimentare.

**Scenariul 29**
Sistemul prin care Google Home sau Amazon Alexa procesează o "Rutină". Când spui "Bună dimineața", asistentul vocal nu procesează o singură instrucțiune. El are o listă de acțiuni pre-înregistrate (1. Aprinde lumina, 2. Citește știrile, 3. Pornește filtrul de cafea). Asistentul parcurge această listă stocată anterior și declanșează secvențial executarea fiecărei acțiuni pre-configurate în acel pachet.

**Scenariul 30**
Un middleware pentru gestionarea erorilor (Exception Handling) într-un server web. Când o aplicație crapă, generează o eroare. Eroarea intră pe o țeavă de procesare: primul filtru verifică dacă e o eroare de autorizare (dacă da, trimite utilizatorul la login). Dacă nu, o pasează mai departe. Al doilea filtru verifică dacă e o eroare de resursă lipsă (404) și afișează pagina de "Not Found". Dacă e o eroare critică necunoscută, ajunge la ultimul filtru care scrie în log-uri și dă mesaj de "Server Error".