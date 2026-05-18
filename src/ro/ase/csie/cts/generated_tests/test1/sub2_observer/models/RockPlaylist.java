package ro.ase.csie.cts.generated_tests.test1.sub2_observer.models;

import ro.ase.csie.cts.generated_tests.test1.sub2_observer.abstracts.APlaylist;
import ro.ase.csie.cts.generated_tests.test1.sub2_observer.abstracts.IListener;

public class RockPlaylist extends APlaylist {
    private String rockGenre;

    public RockPlaylist(String playlistTitle, String genre) {
        super(playlistTitle);
        this.rockGenre = genre;
    }

    public String getRockGenre() {
        return rockGenre;
    }

    @Override
    public void addSong(String title, String duration) {
        super.addSong(title, duration);
        notifyListenersSongAdded(title, duration);
    }

    public void notifyListenersSongAdded(String title, String duration) {
        super.listeners.stream().forEach(l -> l.onSongAdded(title, duration));
    }
}
