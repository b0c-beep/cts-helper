# 🗝️ Răspunsuri și Argumentări: Recunoașterea Șabloanelor

Aici găsești rezolvările explicate pentru cele 30 de scenarii. Verifică nu doar dacă ai ghicit șablonul, ci și dacă raționamentul tău s-a aliniat cu explicația arhitecturală!

---

**Scenariul 1: OBSERVER**
* **Argument:** Există un singur emițător (Termostatul) și mai mulți ascultători (caloriferele). Când starea emițătorului se schimbă, acesta își notifică automat toți "abonații".

**Scenariul 2: STRATEGY**
* **Argument:** Diferitele metode de livrare sunt, de fapt, "algoritmi" diverși de calcul. Ei sunt interschimbabili la rulare pe baza alegerii utilizatorului din interfață.

**Scenariul 3: FLYWEIGHT**
* **Argument:** Optimizare masivă a memoriei. Formatul greu (font, culoare) este separat (*starea intrinsecă* salvată o singură dată) de poziția unică de pe ecran (*starea extrinsecă* pasată ca parametru).

**Scenariul 4: DECORATOR**
* **Argument:** Evită explozia de clase (moștenirea) prin "împachetarea" dinamică a cafelei de bază cu diverse extra-opțiuni, fiecare strat adăugându-și propriul cost.

**Scenariul 5: COMMAND**
* **Argument:** Fiecare acțiune de editare a fost "încapsulată ca un obiect" și pusă într-o listă/stivă. Asta permite invocarea ulterioară a unei metode unice precum `undo()`.

**Scenariul 6: CHAIN OF RESPONSIBILITY**
* **Argument:** Cererea este pasată de-a lungul unui lanț de niveluri ierarhice (Ofițer -> Manager -> Comitet) până când o verigă are competența să o proceseze.

**Scenariul 7: OBSERVER**
* **Argument:** Aplicația ta (Abonatul) s-a înregistrat la un eveniment pe server (Emițătorul) și primește automat notificări "push" (update-uri de preț), eliminând nevoia interogării manuale constante.

**Scenariul 8: STRATEGY**
* **Argument:** Aplicația schimbă din mers funcția (algoritmul) aplicată pe imagine (Alb-Negru vs Sepia), nucleul rămânând neschimbat.

**Scenariul 9: FLYWEIGHT**
* **Argument:** Separarea datelor 3D și a texturilor (*intrinseci*, partajate) de coordonatele și viața fiecărui soldat (*extrinsece*, unice) pentru a economisi RAM la crearea a zeci de mii de obiecte.

**Scenariul 10: DECORATOR**
* **Argument:** Scutul și pelerina "învelesc" personajul și îi extind/modifică comportamentul metodei de a lua damage (un sandviș arhitectural format la runtime).

**Scenariul 11: COMMAND**
* **Argument:** Transformarea unei dorințe de tranzacție într-un "pachet/obiect", care poate fi pus într-o coadă (queue) și executat asincron atunci când serverul e liber.

**Scenariul 12: CHAIN OF RESPONSIBILITY**
* **Argument:** O cerere (pachetul de date) trece printr-un lanț de filtre. Orice filtru are puterea să blocheze pachetul sau să îl treacă mai departe la următoarea verigă din firewall.

**Scenariul 13: OBSERVER**
* **Argument:** Mecanismul clasic Publisher-Subscriber. Autorul blogului (Subiectul) apasă un buton și notifică lista de cititori (Observatorii).

**Scenariul 14: STRATEGY**
* **Argument:** Sistemul schimbă algoritmul de taxare (din Standard în Dinamic/Surge) pe baza contextului meteorologic sau al cererii.

**Scenariul 15: FLYWEIGHT**
* **Argument:** Același model vizual de "Cedează Trecerea" este reutilizat în mii de locuri de pe hartă, pasându-i-se ca stare extrinsecă doar coordonatele X, Y și rotirea.

**Scenariul 16: DECORATOR**
* **Argument:** Adăugarea de noi elemente vizuale (stare/comportament) unui obiect simplu prin compoziție. Chenarul și scroll-ul îmbracă (decorează) fereastra originală.

**Scenariul 17: COMMAND**
* **Argument:** Acțiunea (jobul CRON) este reținută sub forma unui obiect pentru a putea fi amânată și executată fix vineri noaptea (decuplând momentul cererii de cel al execuției).

**Scenariul 18: CHAIN OF RESPONSIBILITY**
* **Argument:** Moneda circulă prin tubul aparatului (lanțul) oprindu-se doar la senzorul care a fost programat să recunoască acea dimensiune/greutate specifică.

**Scenariul 19: OBSERVER**
* **Argument:** Relația 1-la-mulți. Meciul de fotbal este sursa de informație, iar aplicația primește notificări doar pentru că utilizatorul i-a dat "Subscribe" marcându-l cu steluță.

**Scenariul 20: STRATEGY**
* **Argument:** Clientul decide "cum" vrea să facă arhivarea. Modulul de arhivare aplică un algoritm diferit (Lempel-Ziv vs Deflate) în funcție de nivelul ales.

**Scenariul 21: FLYWEIGHT**
* **Argument:** Optimizare vitală în randarea grafică masivă. Reținerea unei singure referințe grele ("Tip_Pământ") și aplicarea ei pe o matrice 3D de stări extrinseci.

**Scenariul 22: DECORATOR**
* **Argument:** Fiecărui nivel adăugat i se "agață" capabilități noi. Peste text pui tabel, peste tabel pui PDF. Este o alterare structurală "pe straturi".

**Scenariul 23: COMMAND**
* **Argument:** Butonul (Invoker) nu deține logica televizorului (Receiver). El pur și simplu apelează `executa()` pe comanda care i-a fost atribuită curent (macro).

**Scenariul 24: CHAIN OF RESPONSIBILITY**
* **Argument:** Sistem de escaladare ierarhică clară. Dacă veriga curentă (Chatbot, Tier 1) este depășită, pasează sarcina către veriga superioară din lanț (Tier 3).

**Scenariul 25: OBSERVER**
* **Argument:** Implementarea feed-ului din rețelele sociale. Tu te abonezi (Follow) la un cont, iar când acel cont are conținut nou, îți transmite o notificare/update.

**Scenariul 26: STRATEGY**
* **Argument:** Înlocuirea completă a modului în care reacționează personajul AI. Se "scoate" algoritmul agresiv și i se "inserează" algoritmul defensiv la un anumit prag de HP.

**Scenariul 27: FLYWEIGHT**
* **Argument:** Reutilizarea la scară microscopică a proprietăților imutabile (greutatea, valența atomului) pentru a permite randarea fluida a unui număr masiv de obiecte similare.

**Scenariul 28: DECORATOR**
* **Argument:** Tranzacția bancară funcționează normal, dar este extinsă cu notificări (straturi adăugate dinamic) fără să fie nevoită să-și schimbe nucleul intern de procesare a banilor.

**Scenariul 29: COMMAND**
* **Argument:** Acesta este un scenariu clasic de "Macro". O succesiune de acțiuni mici împachetate ca obiecte, grupate într-o listă și executate simultan la un stimul vocal.

**Scenariul 30: CHAIN OF RESPONSIBILITY**
* **Argument:** Cursa unei erori printr-o țeavă (pipeline) de procesare. Primul filtru care știe să repare problema preia controlul, altfel o dă mai departe (catch & throw secvențial).