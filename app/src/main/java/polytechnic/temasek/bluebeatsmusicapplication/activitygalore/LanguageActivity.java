package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import polytechnic.temasek.bluebeatsmusicapplication.Util.ConstantUtil;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.Util.AppUtil;

public class LanguageActivity extends AppBaseActivity {
    public String langTitle = "";
    public int theLanguageVariable;

    ImageView song1CoverArt;
 /*   ImageButton song2CoverArt;
    ImageButton song3CoverArt; */

    TextView song1Title;
  /*  TextView song2Title;
    TextView song3Title; */

    TextView song1Artist;
  /*  TextView song2Artist;
    TextView song3Artist; */

    private TheSongCollection songCollection1;

    private RecyclerView recyclerView;
    private SongAdapter adapter;
    private List<Song> songList;

    @Override
    protected int getCurrentViewIndex() {
        return ConstantUtil.BOTTOM_NAV_OTHER_SEQ;
    }

    @Override
    protected int getCheckedBottomMenuIndex() {
        return ConstantUtil.BOTTOM_NAV_HOME_SEQ;
    }

    /*private RecyclerView songReyclerView;
    private LinearLayoutManager songLayoutManager;
    private RecyclerView.Adapter songAdapter;*/

    private TextView langTitleTxt = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
/*
        song1CoverArt = (ImageButton) findViewById(R.id.S1001);
      //  song2CoverArt = (ImageButton) findViewById(R.id.S1002);
        //song3CoverArt = (ImageButton) findViewById(R.id.S1003);

        song1Title = (TextView) findViewById(R.id.txt_SongName1);
//        song2Title = (TextView) findViewById(R.id.txt_SongName2);
  //      song3Title = (TextView) findViewById(R.id.txt_SongName3);

        song1Artist = (TextView) findViewById(R.id.txt_ArtistName1);
    //    song2Artist = (TextView) findViewById(R.id.txt_ArtistName2);
      //  song3Artist = (TextView) findViewById(R.id.txt_ArtistName3);

        langTitleTxt = (TextView) findViewById(R.id.selected_Language);
        retrieveInfo();
        setSongs();*/

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        songList = new ArrayList<>();
        adapter = new SongAdapter(this, songList);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));

        Song rain = new Song("S1001", "Rain", "Sekai no Owari", "e1a29a7b714558e890e1531b0419f5e8c24f32dc?cid=2afe87a64b0042dabf51f37318616965",
                5.12, "rain");
        Song noWayBack = new Song("S1002", "No Way Back", "AAA", "4a5eea2a638b213c08829428cf2e0957d891122a?cid=2afe87a64b0042dabf51f37318616965"
                , 3.70, "nowayback");
        Song undecided = new Song("S1003", "Undecided", "UVERWorld", "4439b2d097c9f95fbad95a51a0d6d7c3d9798870?cid=2afe87a64b0042dabf51f37318616965"
                , 4.69, "undecided");
        songList.add(rain);
        songList.add(noWayBack);
        songList.add(undecided);
        //retrieveInfo();
        //setSongs();



        adapter.notifyDataSetChanged();

        songCollection1 = new TheSongCollection(langTitle);

        loadBottomMenu();
//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//        Menu menu = bottomNavigationView.getMenu();
//        MenuItem theMenuItem = menu.getItem(0);
//        theMenuItem.setChecked(true);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//
//                    case R.id.ic_home:
//                        Intent intent1 = new Intent(LanguageActivity.this, SecondHomePage.class);
//                        startActivity(intent1);
//                        break;
//
//                    case R.id.ic_discover:
//                        Intent intent2 = new Intent(LanguageActivity.this, DiscoverActivity.class);
//                        startActivity(intent2);
//                        break;
//
//                    case R.id.ic_search:
//                        Intent intent3 = new Intent(LanguageActivity.this, SearchActivity.class);
//                        startActivity(intent3);
//                        break;
//
//                    case R.id.ic_library:
//                        Intent intent4 = new Intent(LanguageActivity.this, LibraryActivity.class);
//                        startActivity(intent4);
//                        break;
//
//                    case R.id.ic_profile:
//                        Intent intent5 = new Intent(LanguageActivity.this, ProfileActivity.class);
//                        startActivity(intent5);
//                        break;
//                }
//                return false;
//
//            }
//        });

       /* songReyclerView = (RecyclerView) findViewById(R.id.songRecyclerView);
        songLayoutManager = new LinearLayoutManager(this);
        songReyclerView.setLayoutManager(songLayoutManager);

        songReyclerView.setAdapter(songAdapter);

        //ListView songListView = (ListView) findViewById(R.id.songListView);


        //songListView.setAdapter(adapter); */

    }



    public void retrieveInfo(){
        Bundle pageInfo = this.getIntent().getExtras();
        langTitle = pageInfo.getString("title");
        theLanguageVariable = pageInfo.getInt("languageVariable");
        langTitleTxt.setText(langTitle);

    }

    public void setSongs() {
        songList = new ArrayList<>();
        if (theLanguageVariable == 1) {
            Song rain = new Song("S1001", "Rain", "Sekai no Owari", "e1a29a7b714558e890e1531b0419f5e8c24f32dc?cid=2afe87a64b0042dabf51f37318616965",
                    5.12, "rain");
            Song noWayBack = new Song("S1002", "No Way Back", "AAA", "4a5eea2a638b213c08829428cf2e0957d891122a?cid=2afe87a64b0042dabf51f37318616965"
                    , 3.70, "nowayback");
            Song undecided = new Song("S1003", "Undecided", "UVERWorld", "4439b2d097c9f95fbad95a51a0d6d7c3d9798870?cid=2afe87a64b0042dabf51f37318616965"
                    , 4.69, "undecided");
            songList.add(rain);
            songList.add(noWayBack);
            songList.add(undecided);

        /*    song2Title.setText("No Way Back");
            song2Artist.setText("AAA");
            song2CoverArt.setImageResource(R.drawable.nowayback);

            song3Title.setText("Undecided");
            song3Artist.setText("UVERWorld");
            song3CoverArt.setImageResource(R.drawable.undecided); */

        }
        else if (theLanguageVariable == 2) {
            Song petitPapaNoel = new Song("S1001", "Petit Papa Noël", "Tino Rossi", "3b5eeea6d15ccf62ff50311814305c10231b4c28?cid=2afe87a64b0042dabf51f37318616965",
                    3.11, "petitpapanoel");
            Song lambada = new Song("S1002", "Lambada", "Kaoma Featuring Laolwa Braz", "1e45c08c9bf7021ddfb1f1912d5e3710c6c17539?cid=2afe87a64b0042dabf51f37318616965",
                    3.42, "lambada");
            Song aoVivo = new Song("S1003", "Ao Vivo", "Yannick", "d2f48d9daf5b14191526e85ccbd86fd3054df3fd?cid=2afe87a64b0042dabf51f37318616965", 3.09,
                    "aovivo");
            songList.add(petitPapaNoel);
            songList.add(lambada);
            songList.add(aoVivo);

        /*    song2Title.setText("Lambada");
            song2Artist.setText("Kaoma Featuring Laolwa Braz");
            song2CoverArt.setImageResource(R.drawable.lambada);

            song3Title.setText("Ao Vivo");
            song3Artist.setText("Yannick");
            song3CoverArt.setImageResource(R.drawable.aovivo); */
        }
        else {
        //do nothing
        }
    }

    public void handleSelection(View objClickedOn){
        String resourceID = AppUtil.getResourceId(this, objClickedOn);
        Song selectedSong = songCollection1.searchById(resourceID);
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
        intent.putExtra("languageTitle", langTitle);

        //3. Launch the destination screen/activity
        startActivity(intent);
    }
}
