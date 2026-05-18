package ro.ase.csie.cts.generated_tests.test1.sub1_adapter;

import ro.ase.csie.cts.generated_tests.test1.sub1_adapter.abstracts.IExternalSong;
import ro.ase.csie.cts.generated_tests.test1.sub1_adapter.abstracts.IStandardSong;
import ro.ase.csie.cts.generated_tests.test1.sub1_adapter.models.ExternalSong;
import ro.ase.csie.cts.generated_tests.test1.sub1_adapter.models.ExternalToInternalSongObjectAdapter;
import ro.ase.csie.cts.generated_tests.test1.sub1_adapter.models.StandardSong;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IStandardSong s1 = new StandardSong("song1", "artist1", 200);
        IExternalSong s2 = new ExternalSong("song2", List.of("artist2"), 2);

        System.out.println(s1);
        System.out.println(s2);

        IStandardSong s2_internal = new ExternalToInternalSongObjectAdapter(s2);
        System.out.println(s2_internal.getArtist());
        System.out.println(s2_internal.getTitle());
        System.out.println(s2_internal.getPlayLengthSeconds());

    }
}
