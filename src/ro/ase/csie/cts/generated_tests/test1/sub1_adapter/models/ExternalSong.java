package ro.ase.csie.cts.generated_tests.test1.sub1_adapter.models;

import ro.ase.csie.cts.generated_tests.test1.sub1_adapter.abstracts.IExternalSong;

import java.util.ArrayList;
import java.util.List;

public class ExternalSong implements IExternalSong {
    private String songName;
    private List<String> artists = new ArrayList<>();
    private int runtimeMinutes;

    public ExternalSong(String songName, List<String> artists, int runtimeMinutes) {
        this.songName = songName;
        this.artists = artists;
        this.runtimeMinutes = runtimeMinutes;
    }

    @Override
    public String getSongName() {
        return songName;
    }

    @Override
    public List<String> getArtistList() {
        return artists;
    }

    @Override
    public int getSongDurationMinutes() {
        return runtimeMinutes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExternalSong{");
        sb.append("songName='").append(songName).append('\'');
        sb.append(", artists=").append(artists);
        sb.append(", runtimeMinutes=").append(runtimeMinutes);
        sb.append('}');
        return sb.toString();
    }
}
