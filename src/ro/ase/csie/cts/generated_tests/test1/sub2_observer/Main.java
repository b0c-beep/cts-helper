package ro.ase.csie.cts.generated_tests.test1.sub2_observer;

import ro.ase.csie.cts.generated_tests.test1.sub2_observer.abstracts.APlaylist;
import ro.ase.csie.cts.generated_tests.test1.sub2_observer.abstracts.IListener;
import ro.ase.csie.cts.generated_tests.test1.sub2_observer.models.NormalListener;
import ro.ase.csie.cts.generated_tests.test1.sub2_observer.models.RockListener;
import ro.ase.csie.cts.generated_tests.test1.sub2_observer.models.RockPlaylist;

public class Main {
    public static void main(String[] args) {
        APlaylist p1 = new RockPlaylist("rock_playlist1", "metal");
        p1.addSong("song1", "artist1");

        IListener l1 = new NormalListener();
        IListener l2 = new RockListener();

        p1.subscribe(l1);
        p1.subscribe(l2);

        p1.addSong("song2", "artist2");

        p1.unsubscribe(l1);

        System.out.println();
        p1.addSong("song3", "artist3");
    }
}
