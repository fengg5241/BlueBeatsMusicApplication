package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import polytechnic.temasek.bluebeatsmusicapplication.Util.ConstantUtil;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.Util.AppUtil;
import polytechnic.temasek.bluebeatsmusicapplication.subpages.ArtistInfoActivity;
import polytechnic.temasek.bluebeatsmusicapplication.subpages.DisplayAlbumSongs;

public class DiscoverActivity extends AppBaseActivity {

    private TheSongCollection songCollection1;
    private String langTitle;
    private String artistName;
    private String artistBiography;


    @Override
    protected int getCurrentViewIndex() {
        return ConstantUtil.BOTTOM_NAV_DISCOVER_SEQ;
    }

    @Override
    protected int getCheckedBottomMenuIndex() {
        return ConstantUtil.BOTTOM_NAV_DISCOVER_SEQ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        loadBottomMenu();
//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//        Menu menu = bottomNavigationView.getMenu();
//        MenuItem theMenuItem = menu.getItem(1);
//        theMenuItem.setChecked(true);
//
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//
//                    case R.id.ic_home:
//                        Intent intent1 = new Intent(DiscoverActivity.this, SecondHomePage.class);
//                        startActivity(intent1);
//                        break;
//
//                    case R.id.ic_discover:
//                        break;
//
//                    case R.id.ic_search:
//                        Intent intent2 = new Intent(DiscoverActivity.this, SearchActivity.class);
//                        startActivity(intent2);
//                        break;
//
//                    case R.id.ic_library:
//                        Intent intent3 = new Intent(DiscoverActivity.this, LibraryActivity.class);
//                        startActivity(intent3);
//                        break;
//
//                    case R.id.ic_profile:
//                        Intent intent4 = new Intent(DiscoverActivity.this, ProfileActivity.class);
//                        startActivity(intent4);
//                        break;
//
//                }
//                return false;
//            }
//    });
        songCollection1 = new TheSongCollection("RandomiseLanguage");
        langTitle = "RandomiseLanguage";
}

    public void playARandomSong(View objClickedOn) {
        String resourceID = songCollection1.findTheRandomSongID();
        Song selectedSong = songCollection1.searchById(resourceID);
        AppUtil.popMessage(this, "Streaming song: " + selectedSong.getSong_Title());
        sendDataToActivity(selectedSong);
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
        intent.putExtra("languageTitle", langTitle);
        intent.putExtra("Random", true);

        //3. Launch the destination screen/activity
        startActivity(intent);
    }

    public void goBackToHomepage(View view){
        Intent intent = new Intent(DiscoverActivity.this, SecondHomePage.class);
        startActivity(intent);
    }

    public void handlePercival(View view){
        Intent intent = new Intent(DiscoverActivity.this, ArtistInfoActivity.class);
        artistName = "Percival Schuttenbach";
        artistBiography = "Percival is a Polish folk music band from Lubin, formed by musicians of folk-metal band Percival Schuttenbach, due to their fascination with history and historical reenactment.";
        intent.putExtra("artistName", artistName);
        intent.putExtra("artistBiography", artistBiography);
        startActivity(intent);
    }

    public void handleWitcher(View view){
        Intent intent = new Intent(DiscoverActivity.this, DisplayAlbumSongs.class);
        String albumName = "Witcher 3: Wild Hunt (Original Game Soundtrack)";
        String albumType = "Witcher";
        intent.putExtra("albumName", albumName);
        intent.putExtra("albumType", albumType);
        startActivity(intent);
    }


}
