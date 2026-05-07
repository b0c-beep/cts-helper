package ro.ase.csie.cts.adapter.abstracts;

public interface IEmailSender {
    void sendEmailNotification(String emailAddress, String emailSubject, String emailBody);
}
