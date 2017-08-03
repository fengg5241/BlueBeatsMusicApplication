package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.Util.AppUtil;

public class GenreSelectionActivity extends AppCompatActivity {


    private String genre;
    private int genreVariable;

    ImageButton song1CoverArt;
    ImageButton song2CoverArt;
    ImageButton song3CoverArt;

    TextView song1Title;
    TextView song2Title;
    TextView song3Title;

    TextView song1Artist;
    TextView song2Artist;
    TextView song3Artist;

    TextView toolbartitle;

    private TheSongCollection theSongCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_selection);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem theMenuItem = menu.getItem(0);
        theMenuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        Intent intent = new Intent(GenreSelectionActivity.this, SecondHomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.ic_discover:
                        Intent intent2 = new Intent(GenreSelectionActivity.this, DiscoverActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_search:
                        Intent intent3 = new Intent(GenreSelectionActivity.this, SearchActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_library:
                        Intent intent4 = new Intent(GenreSelectionActivity.this, LibraryActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.ic_profile:
                        Intent intent5 = new Intent(GenreSelectionActivity.this, ProfileActivity.class);
                        startActivity(intent5);
                        break;

                }
                return false;

            }
        });

        song1CoverArt = (ImageButton) findViewById(R.id.S1001);
        song2CoverArt = (ImageButton) findViewById(R.id.S1002);
        song3CoverArt = (ImageButton) findViewById(R.id.S1003);

        song1Title = (TextView) findViewById(R.id.txt_SongName1);
        song2Title = (TextView) findViewById(R.id.txt_SongName2);
        song3Title = (TextView) findViewById(R.id.txt_SongName3);

        song1Artist = (TextView) findViewById(R.id.txt_ArtistName1);
        song2Artist = (TextView) findViewById(R.id.txt_ArtistName2);
        song3Artist = (TextView) findViewById(R.id.txt_ArtistName3);

        toolbartitle = (TextView) findViewById(R.id.toolbartitle);

        retrieveInfo();
        setSongs();
        theSongCollection = new TheSongCollection(genre);
    }

    public void retrieveInfo(){
        Bundle pageInfo = this.getIntent().getExtras();
        genre = pageInfo.getString("title");
        genreVariable = pageInfo.getInt("genreVariable");
        toolbartitle.setText(genre);
    }

    public void setSongs() {
        if (genreVariable == 1) {
            song1Title.setText("Strange Fruit - Remastered");
            song1Artist.setText("Billie Holiday");
            song1CoverArt.setImageResource(R.drawable.strangefruit);

            song2Title.setText("Mack the Knife - Live");
            song2Artist.setText("Ella Fitzgerald");
            song2CoverArt.setImageResource(R.drawable.macktheknife);

            song3Title.setText("At Last");
            song3Artist.setText("Etta James");
            song3CoverArt.setImageResource(R.drawable.atlast);

        } else if (genreVariable == 2) {
            song1Title.setText("Master of Puppets");
            song1Artist.setText("Metallica");
            song1CoverArt.setImageResource(R.drawable.masterofpuppets);

            song2Title.setText("Hallowed be Thy Name");
            song2Artist.setText("Iron Maiden");
            song2CoverArt.setImageResource(R.drawable.hallowedbtn);

            song3Title.setText("One");
            song3Artist.setText("Metallica");
            song3CoverArt.setImageResource(R.drawable.one);
        } else if (genreVariable == 3) {
            song1Title.setText("Something Just Like This");
            song1Artist.setText("The ChainSmokers");
            song1CoverArt.setImageResource(R.drawable.somethingjlt);

            song2Title.setText("It Ain't Me");
            song2Artist.setText("Kygo ft. Selena Gomez");
            song2CoverArt.setImageResource(R.drawable.itaintme);

            song3Title.setText("2U");
            song3Artist.setText("David Guetta ft. Justin Bieber");
            song3CoverArt.setImageResource(R.drawable.toyou);

        }
        else {
            //do nothing
        }
    }


    public void handleSelection(View objClickedOn){
        String resourceID = AppUtil.getResourceId(this, objClickedOn);
        Song selectedSong = theSongCollection.searchById(resourceID);
        AppUtil.popMessage(this, "Streaming song: " + selectedSong.getSong_Title());
        sendDataToActivity(selectedSong);
    }

    //1. Create a new Intent and specify the source and destination screen/activity
    public void sendDataToActivity(Song chosenSong) {
        Intent intent   = new Intent(this, PlaySongActivity.class);
        //.class is the machine-readable form of a java class.

        //2. Store the song information into the Intent object to be sent over to the
        //destination screen
        intent.putExtra("id", chosenSong.getSong_ID());
        intent.putExtra("title", chosenSong.getSong_Title());
        intent.putExtra("artist", chosenSong.getSong_Artist());
        intent.putExtra("fileLink", chosenSong.getFileLink());
        intent.putExtra("length", chosenSong.getSong_Length());
        intent.putExtra("coverArt", chosenSong.getCoverArt());
        intent.putExtra("languageTitle", genre);

        //3. Launch the destination screen/activity
        startActivity(intent);
    }
}

