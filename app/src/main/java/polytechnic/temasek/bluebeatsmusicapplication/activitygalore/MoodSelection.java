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

import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.Util.AppUtil;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;

public class MoodSelection extends AppCompatActivity {

    ImageButton song1CoverArt;
    TextView song1Title;
    TextView song1Artist;
    private TheSongCollection songCollection1;
    String moodTitle;
    TextView toolbarTitle;
    int moodVariable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_selection);

        song1CoverArt = (ImageButton) findViewById(R.id.S1001);
        song1Title = (TextView) findViewById(R.id.txt_SongName1);
        song1Artist = (TextView) findViewById(R.id.txt_ArtistName1);
        toolbarTitle = (TextView) findViewById(R.id.toolbartitle);

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
                        Intent intent = new Intent(MoodSelection.this, SecondHomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.ic_discover:
                        Intent intent2 = new Intent(MoodSelection.this, DiscoverActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_search:
                        Intent intent3 = new Intent(MoodSelection.this, SearchActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_library:
                        Intent intent4 = new Intent(MoodSelection.this, LibraryActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.ic_profile:
                        Intent intent5 = new Intent(MoodSelection.this, ProfileActivity.class);
                        startActivity(intent5);
                        break;

                }
                return false;

            }
        });

        retrieveInfo();
        setSongs();
        songCollection1 = new TheSongCollection(moodTitle);

    }


    public void retrieveInfo(){
        Bundle pageInfo = this.getIntent().getExtras();
        moodTitle  = pageInfo.getString("title");
        moodVariable = pageInfo.getInt("moodVariable");
        toolbarTitle.setText(moodTitle);
    }

    public void setSongs() {
        if (moodVariable == 1) {
            song1Title.setText("Virus (How About Now)");
            song1Artist.setText("Martin Garrix");
            song1CoverArt.setImageResource(R.drawable.virus);


        } else if (moodVariable == 2) {
            song1Title.setText("Dancing On My Own");
            song1Artist.setText("Robyn");
            song1CoverArt.setImageResource(R.drawable.domo);


        } else if (moodVariable == 3) {
            song1Title.setText("Tian Di Yi Dou 天地一鬥");
            song1Artist.setText("Jay Chou");
            song1CoverArt.setImageResource(R.drawable.tdyd);

        } else {
            //do nothing
        }
    }

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
        intent.putExtra("languageTitle", moodTitle);

        //3. Launch the destination screen/activity
        startActivity(intent);
    }

    public void handleSelection(View objClickedOn){
        String resourceID = AppUtil.getResourceId(this, objClickedOn);
        Song selectedSong = songCollection1.searchById(resourceID);
        AppUtil.popMessage(this, "Streaming song: " + selectedSong.getSong_Title());
        sendDataToActivity(selectedSong);


    }
}
