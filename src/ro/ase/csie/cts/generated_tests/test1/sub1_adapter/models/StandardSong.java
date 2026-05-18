package ro.ase.csie.cts.generated_tests.test1.sub1_adapter.models;

import ro.ase.csie.cts.generated_tests.test1.sub1_adapter.abstracts.IStandardSong;

public class StandardSong implements IStandardSong {
    private String title;
    private String artist;
    private int seconds;

    public StandardSong(String title, String artist, int seconds) {
        this.title = title;
        this.artist = artist;
        this.seconds = seconds;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public int getPlayLengthSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StandardSong{");
        sb.append("title='").append(title).append('\'');
        sb.append(", artist='").append(artist).append('\'');
        sb.append(", seconds=").append(seconds);
        sb.append('}');
        return sb.toString();
    }
}
