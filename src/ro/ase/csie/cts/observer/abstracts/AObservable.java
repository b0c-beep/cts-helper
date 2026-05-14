package ro.ase.csie.cts.observer.abstracts;

import java.util.ArrayList;
import java.util.List;

public abstract class AObservable {
    protected List<IObserver> subscribers = new ArrayList<>();

    public void subscribe(IObserver sub) {
        subscribers.add(sub);
    }

    public void unsubscribe(IObserver sub) {
        subscribers.remove(sub);
    }

    public void notifySubscribers(String message) {
        subscribers.forEach(o -> o.getNotification(message));
    }
}
