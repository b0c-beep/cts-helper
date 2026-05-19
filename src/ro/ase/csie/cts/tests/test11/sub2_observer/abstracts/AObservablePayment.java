package ro.ase.csie.cts.tests.test11.sub2_observer.abstracts;

import java.util.ArrayList;
import java.util.List;

public abstract class AObservablePayment implements IPayment {
    protected List<INotification> subscribers = new ArrayList<>();
    private boolean getNotifications;

    public AObservablePayment() {

    }

    public void turnOnNotifications() {
        getNotifications = true;
    }

    public void turnOffNotifications() {
        getNotifications = false;
    }

    public void subscribe(INotification notification) {
        subscribers.add(notification);
    }

    public void unsubscribe(INotification notification) {
        subscribers.remove(notification);
    }

    protected void notifyAllSubscribers(String domain, double amount, boolean status) {
        if (getNotifications) {
            subscribers.forEach(n -> n.paymentOutcome("PAYMENT OF " + amount + " TO " + domain + " WAS A " + (status ? "SUCCESS" : "FAILURE")));
        } else {
            System.out.println("NOTIFICATIONS TURNED OFF");
        }
    }
}
