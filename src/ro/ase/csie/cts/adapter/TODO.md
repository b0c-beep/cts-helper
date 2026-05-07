# Subiect de Lucru: Șablonul Adapter

## 🏢 Scenariul: Sistemul de Notificări

Lucrezi la o aplicație bancară care a fost concepută inițial să trimită alerte clienților doar prin SMS. Tot sistemul tău este cuplat la o interfață simplă de trimitere a SMS-urilor.

Recent, managementul a decis să folosească și un serviciu extern modern pentru trimiterea de E-mail-uri (o clasă `EmailService` pe care ai primit-o gata scrisă și nu ai voie să o modifici).

Problema este că sistemul tău știe să apeleze doar metoda pentru SMS, iar serviciul nou folosește parametri și metode complet diferite pentru E-mail.

---

## 💻 Codul de pornire (Situația curentă)

```java
// 1. Target (Interfața pe care se bazează aplicația ta bancară)
public interface ISmsSender {
    void sendSms(String phoneNumber, String message);
}

// 2. Adaptee (Librăria externă, pe care NU ai voie să o modifici)
public class EmailService {
    public void dispatchEmail(String emailAddress, String emailSubject, String emailBody) {
        System.out.println("Se trimite email către: " + emailAddress);
        System.out.println("Subiect: " + emailSubject);
        System.out.println("Mesaj: " + emailBody);
    }
}
```

---

## 📝 Cerințe de rezolvare

Trebuie să faci sistemul de SMS să folosească sistemul de E-mail, implementând ambele variante:

### 1. Adaptorul de Obiect (`SmsToEmailObjectAdapter`)
* Implementează `ISmsSender` și folosește **compoziția** pentru a integra `EmailService`.
* **Regulă de conversie pentru delegare:**
    * Adresa email = `phoneNumber` + `"@banca.ro"`
    * Subiectul = `"Alertă Bancară SMS"`
    * Body-ul = `message`

### 2. Adaptorul de Clase (`SmsToEmailClassAdapter`)
* Folosește **moștenirea** pentru a adapta `EmailService` la `ISmsSender`.
* Aplică exact aceeași regulă de conversie pentru parametri ca mai sus.

### 3. Clasa Main (Clientul)
* Instanțiază și testează ambele adaptoare apelând exclusiv metoda `sendSms(...)` pe ele.