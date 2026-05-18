### Se dezvoltă o aplicație software destinată unui sistem bancar digital.

**3p.** Banca oferă acces la conturile clienților prin intermediul aplicației mobile. Accesul la un cont real este costisitor (necesită autentificare la serverul central, jurnalizare și audit), astfel că se dorește un mecanism care să controleze și să restricționeze accesul la operațiunile sensibile (retragere, transfer). Accesul se face prin intermediul aceluiași contract ca și contul real. Implementarea va folosi interfața `AbstractContBancar`.

> Interfață pusă la dispoziție:
> ```java
> public interface AbstractContBancar {
>     double getSold();
>     void depune(double suma);
>     void retrage(double suma);
>     String getIban();
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Crearea unui cont real și accesarea acestuia prin intermediul mecanismului de control.
- Demonstrarea că operațiunile sensibile (retragere) sunt restricționate/jurnalizate.
- Demonstrarea că operațiunile de citire (sold) sunt permise fără restricții suplimentare.
---

**3p.** Tranzacțiile bancare sunt supuse unui lanț de validări succesive: verificarea soldului disponibil, verificarea limitei zilnice de transfer, detectarea tranzacțiilor suspecte (sume neobișnuit de mari), verificarea contului destinatar. Dacă o tranzacție nu trece de un filtru, aceasta este respinsă și motivul este afișat. Ordinea verificărilor trebuie să poată fi reconfigurată. Implementarea folosește interfața `AbstractValidatorTranzactie`.

> Interfață pusă la dispoziție:
> ```java
> public abstract class AbstractValidatorTranzactie {
>     protected AbstractValidatorTranzactie urmator;
>
>     public void seteazaUrmator(AbstractValidatorTranzactie urmator) {
>         this.urmator = urmator;
>     }
>
>     public abstract boolean valideaza(Tranzactie tranzactie);
> }
> ```

**1.5p.** Testați implementarea în `main()` prin:
- Definirea a cel puțin 3 validatori succesivi.
- Testarea unei tranzacții valide care trece toate filtrele.
- Testarea a cel puțin 2 tranzacții invalide respinse la filtre diferite.
- Afișarea validatorului la care tranzacția este respinsă.