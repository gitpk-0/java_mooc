
public class Song {

    private String artist;
    private String name;
    private int durationInSeconds;

    public Song(String artist, String name, int durationInSeconds) {
        this.artist = artist;
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }

    public boolean equals(Object compared) {
        // same memory address?
        if (this == compared) {
            return true;
        }

        // is compared of type Song? (if not return false)
        if (!(compared instanceof Song)) {
            return false;
        }

        // cast compared to new Song object
        Song comparedSong = (Song) compared;

        // if all variables are equal return true
        if (this.artist.equals(comparedSong.artist) &&
            this.name.equals(comparedSong.name) &&
            this.durationInSeconds == comparedSong.durationInSeconds) {
            return true;
        }

        // otherwise the objects are not equal
        return false;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.durationInSeconds + " s)";
    }


}
