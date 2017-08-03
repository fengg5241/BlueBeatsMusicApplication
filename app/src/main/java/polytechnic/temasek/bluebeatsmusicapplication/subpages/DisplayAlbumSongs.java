package polytechnic.temasek.bluebeatsmusicapplication.subpages;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.Util.AppUtil;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.DiscoverActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.PlaySongActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.ProfileActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.SearchActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.SecondHomePage;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.Song;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.TheSongCollection;

public class DisplayAlbumSongs extends AppCompatActivity {

    String albumName;
    String albumType;
    TextView pageTitle;
    TheSongCollection songCollection;
    TextView songName1;
    TextView songArtist1;
    ImageButton songCoverArt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_album_songs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);

        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem theMenuItem = menu.getItem(1);
        theMenuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        Intent intent1 = new Intent(DisplayAlbumSongs.this, SecondHomePage.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_discover:
                        Intent intent2 = new Intent(DisplayAlbumSongs.this, DiscoverActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_search:
                        Intent intent3 = new Intent(DisplayAlbumSongs.this, SearchActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_library:
                        break;

                    case R.id.ic_profile:
                        Intent intent4 = new Intent(DisplayAlbumSongs.this, ProfileActivity.class);
                        startActivity(intent4);
                        break;

                }
                return false;
            }
        });

        pageTitle = (TextView) findViewById(R.id.toolbartitle);
        songArtist1 = (TextView) findViewById(R.id.txt_ArtistName1);
        songName1 = (TextView) findViewById(R.id.txt_SongName1);
        songCoverArt1 = (ImageButton) findViewById(R.id.S1001);
        retrieveInfo();
        songCollection = new TheSongCollection(albumType);
        setSongs();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        finish();
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.mipmap.ic_back) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void retrieveInfo(){
        Bundle pageInfo = this.getIntent().getExtras();
        albumName = pageInfo.getString("albumName");
        albumType = pageInfo.getString("albumType");
        pageTitle.setText(albumName);
    }

    public void setSongs(){
        songName1.setText("Steel For Humans");
        songArtist1.setText("Percival Schuttenbach");
        songCoverArt1.setImageResource(R.drawable.witcher3soundtrack);
    }

    public void handleSelection(View objClickedOn) {
        String resourceID = AppUtil.getResourceId(this, objClickedOn);
        Song selectedSong = songCollection.searchById(resourceID);
        AppUtil.popMessage(this, "Streaming song: " + selectedSong.getSong_Title());
        sendDataToActivity(selectedSong);
    }

    public void sendDataToActivity(Song chosenSong){
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
        intent.putExtra("languageTitle", albumType);

        //3. Launch the destination screen/activity
        startActivity(intent);
    }
}

