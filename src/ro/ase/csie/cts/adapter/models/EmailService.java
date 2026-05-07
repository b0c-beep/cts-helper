package ro.ase.csie.cts.adapter.models;

import ro.ase.csie.cts.adapter.abstracts.IEmailSender;

public class EmailService implements IEmailSender {
    @Override
    public void sendEmailNotification(String emailAddress, String emailSubject, String emailBody) {
        System.out.println("SENDING EMAIL TO: " + emailAddress);
        System.out.println("SUBJECT: " + emailSubject);
        System.out.println("BODY: " + emailBody);
    }
}
