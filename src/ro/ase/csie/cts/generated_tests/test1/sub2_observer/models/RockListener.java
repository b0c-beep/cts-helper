package ro.ase.csie.cts.generated_tests.test1.sub2_observer.models;

import ro.ase.csie.cts.generated_tests.test1.sub2_observer.abstracts.IListener;

public class RockListener implements IListener {
    @Override
    public void onSongAdded(String title, String artist) {
        System.out.println("ATTENTION! NEW TRACK ADDED TO THE PLAYLIST: " + title + " BY " + artist + "! ROCK N ROLL!!!!");
    }
}
