package ro.ase.csie.cts.adapter.models;

import ro.ase.csie.cts.adapter.abstracts.IEmailSender;
import ro.ase.csie.cts.adapter.abstracts.IMessageSender;

public class EmailToMessageObjectAdapter implements IMessageSender {
    private final IEmailSender emailer;

    public EmailToMessageObjectAdapter(IEmailSender emailer) {
        this.emailer = emailer;
    }

    @Override
    public void sendMessageNotification(String phoneNumber, String message) {
        emailer.sendEmailNotification(phoneNumber + "@dummy.com", "SMS to Email Notification", message);
    }
}
