package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

/**
 * Created by User on 17/7/2017.
 */

public class Song {
    private String song_ID;
    private String song_Title;
    private String song_Artist;
    private String fileLink;
    private double song_Length;
    private String coverArt;

    public Song(String song_ID, String song_Title, String song_Artist, String fileLink,
                double song_Length, String coverArt) {
        this.song_ID = song_ID;
        this.song_Title = song_Title;
        this.song_Artist = song_Artist;
        this.fileLink = fileLink;
        this.song_Length = song_Length;
        this.coverArt = coverArt;

    }

    //What is happening here? Wasn't the song_ID already set? Why do we need to get and set again?
    //With song.SongTitle, if you changed the value this way, would it affect all other objects
    // in the same class, and that's why we have to set it to private?  If not, why do we need these
    //methods?
    public String getSong_ID() { return song_ID; }
    public void setSong_ID(String song_id) { this.song_ID = song_id; }

    public String getSong_Title() { return song_Title; }
    public void setSong_Title(String song_title) { this.song_Title = song_title; }

    public String getSong_Artist() { return song_Artist; }
    public void setSong_Artist(String song_artist) { this.song_Artist = song_artist; }

    public String getFileLink() { return fileLink; }
    public void setFileLink(String fileLink1) { this.fileLink = fileLink1; }

    public double getSong_Length() { return song_Length; }
    public void setSong_Length(double song_length) { this.song_Length = song_length; }

    public String getCoverArt() { return coverArt; }
    public void setCoverArt(String coverArt1) { this.coverArt = coverArt1; }
}
