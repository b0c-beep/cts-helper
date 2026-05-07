package ro.ase.csie.cts.adapter;

import ro.ase.csie.cts.adapter.abstracts.IEmailSender;
import ro.ase.csie.cts.adapter.abstracts.IMessageSender;
import ro.ase.csie.cts.adapter.models.EmailService;
import ro.ase.csie.cts.adapter.models.EmailToMessageClassAdapter;
import ro.ase.csie.cts.adapter.models.EmailToMessageObjectAdapter;
import ro.ase.csie.cts.adapter.models.MessageService;

public class Main {
    public static void main(String[] args) {
        IMessageSender msg = new MessageService();
        IEmailSender email = new EmailService();

        System.out.println();
        email.sendEmailNotification("sdads@dsadsa.com", "title", "daknsdkds test");
        System.out.println();

        System.out.println();
        msg = new EmailToMessageClassAdapter();
        msg.sendMessageNotification("sadasda", "Sdadsa");

        System.out.println();
        msg = new EmailToMessageObjectAdapter(email);
        msg.sendMessageNotification("84329423", "test test");
    }
}
