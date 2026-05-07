package ro.ase.csie.cts.adapter.models;

import ro.ase.csie.cts.adapter.abstracts.IMessageSender;

public class MessageService implements IMessageSender {
    @Override
    public void sendMessageNotification(String phoneNumber, String message) {
        System.out.println("SENDING SMS TO " + phoneNumber);
        System.out.println(message);
    }
}
