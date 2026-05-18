package ro.ase.csie.cts.generated_tests.test1.sub1_adapter.models;

import ro.ase.csie.cts.generated_tests.test1.sub1_adapter.abstracts.IExternalSong;
import ro.ase.csie.cts.generated_tests.test1.sub1_adapter.abstracts.IStandardSong;

import java.util.List;

public class ExternalToInternalSongObjectAdapter implements IStandardSong {
    private IExternalSong song;

    public ExternalToInternalSongObjectAdapter(IExternalSong song) {
        this.song = song;
    }

    @Override
    public String getTitle() {
        return song.getSongName();
    }

    @Override
    public String getArtist() {
        List<String> list = song.getArtistList();
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append(", ");
        }
        return sb.toString();
    }

    @Override
    public int getPlayLengthSeconds() {
        return song.getSongDurationMinutes() * 60;
    }
}
