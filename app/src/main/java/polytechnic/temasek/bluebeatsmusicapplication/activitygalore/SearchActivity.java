package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import java.util.ArrayList;

import polytechnic.temasek.bluebeatsmusicapplication.Util.AppUtil;
import polytechnic.temasek.bluebeatsmusicapplication.Util.ConstantUtil;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.AnimalNames;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.ListViewAdapter;
import polytechnic.temasek.bluebeatsmusicapplication.R;

public class SearchActivity extends AppBaseActivity implements SearchView.OnQueryTextListener {

    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String text;
    String langTitle;
    String[] animalNameList;
    TheSongCollection songCollection;
    ArrayList<AnimalNames> arraylist = new ArrayList<AnimalNames>();

    @Override
    protected int getCheckedBottomMenuIndex() {
        return ConstantUtil.BOTTOM_NAV_SEARCH_SEQ;
    }

    @Override
    protected int getCurrentViewIndex() {
        return ConstantUtil.BOTTOM_NAV_SEARCH_SEQ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        songCollection = new TheSongCollection("All Songs");

//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//        Menu menu = bottomNavigationView.getMenu();
        setupUI(findViewById(R.id.search));
//        MenuItem theMenuItem = menu.getItem(2);
//        theMenuItem.setChecked(true);

        langTitle = "All Songs";

        animalNameList = new String[]{"The Way You Look Tonight","Billie Jean" ,"I'm Blue",
                "Shape of You", "Petit Papa Noel", "Rain", "No Way Back", "Ao Vivo",
                "Undecided","Lambada", "Strange Fruit", "Mack The Knife", "At Last", "Master of Puppets", "Hallowed Be Thy Name"
        ,"Metallica", "Something Just Like This", "It Ain't Me", "2U", "Virus", "Dancing On My Own", "天地一鬥 Tian Di Yi Dou"};

        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < animalNameList.length; i++) {
            AnimalNames animalNames = new AnimalNames(animalNameList[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }



        adapter = new ListViewAdapter(this, arraylist);

        list.setAdapter(adapter);

        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                AnimalNames tempAnimal = (AnimalNames) list.getItemAtPosition(0);
                text = tempAnimal.getAnimalName();
                Toast.makeText(SearchActivity.this, "" + text, Toast.LENGTH_LONG).show();
                Song selectedSong = songCollection.searchByTitle(text);
                sendDataToActivity(selectedSong);
            }
        });

        loadBottomMenu();

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//
//                    case R.id.ic_home:
//                        Intent intent1 = new Intent(SearchActivity.this, SecondHomePage.class);
//                        startActivity(intent1);
//                        break;
//
//                    case R.id.ic_discover:
//                        Intent intent2 = new Intent(SearchActivity.this, DiscoverActivity.class);
//                        startActivity(intent2);
//                        break;
//
//                    case R.id.ic_search:
//                        break;
//
//                    case R.id.ic_library:
//                        Intent intent3 = new Intent(SearchActivity.this, LibraryActivity.class);
//                        startActivity(intent3);
//                        break;
//
//                    case R.id.ic_profile:
//                        Intent intent4 = new Intent(SearchActivity.this, ProfileActivity.class);
//                        startActivity(intent4);
//                        break;
//
//                }
//                return false;
//            }
//        });


    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }


    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof SearchView)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(SearchActivity.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
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
        intent.putExtra("languageTitle", langTitle);

        //3. Launch the destination screen/activity
        startActivity(intent);
    }
}
