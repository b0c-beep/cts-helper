package ro.ase.csie.cts.generated_tests.test1.sub2_observer.abstracts;

import java.util.ArrayList;
import java.util.List;

public abstract class APlaylist {
    private String playlistTitle;
    private List<String> songs = new ArrayList<>();
    protected List<IListener> listeners = new ArrayList<>();

    public APlaylist(String playlistTitle) {
        this.playlistTitle = playlistTitle;
    }

    public void subscribe(IListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(IListener listener) {
        listeners.remove(listener);
    }

    public void addSong(String title, String duration) {
        songs.add(title);
    }

    public void removeSong(String title, String duration) {
        songs.remove(title);
    }
}
