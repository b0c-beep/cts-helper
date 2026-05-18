package ro.ase.csie.cts.generated_tests.test1.sub2_observer.models;

import ro.ase.csie.cts.generated_tests.test1.sub2_observer.abstracts.IListener;

public class NormalListener implements IListener {
    @Override
    public void onSongAdded(String title, String artist) {
        System.out.println("Hello, the song: " + title + " by " + artist + " has been added to a rock playlist, check it out maybe!");
    }
}
