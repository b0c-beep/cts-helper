package ro.ase.csie.cts.adapter.models;

import ro.ase.csie.cts.adapter.abstracts.IEmailSender;
import ro.ase.csie.cts.adapter.abstracts.IMessageSender;

public class EmailToMessageClassAdapter extends EmailService implements IMessageSender {

    @Override
    public void sendMessageNotification(String phoneNumber, String message) {
        super.sendEmailNotification(phoneNumber + "@dummy.com", "Email to SMS Notification", message);
    }
}
