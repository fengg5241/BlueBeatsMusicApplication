package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import polytechnic.temasek.bluebeatsmusicapplication.Util.ConstantUtil;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.subpages.AllLanguageActivity;

public class SecondHomePage extends AppBaseActivity {

    private String[] japanese = new String[2];
    private String[] french = new String[2];
    private String genreTitle;
    private String moodTitle;
    private Object[] language = {japanese, french};
    private int languageVariable;
    private int genreVariable;
    private int moodVariable;
    private Toolbar toolbar;

    @Override
    protected int getCheckedBottomMenuIndex() {
        return ConstantUtil.BOTTOM_NAV_HOME_SEQ;
    }

    @Override
    protected int getCurrentViewIndex() {
        return ConstantUtil.BOTTOM_NAV_HOME_SEQ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_home_page);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_profile);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondHomePage.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

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
//                        break;
//
//                    case R.id.ic_discover:
//                        Intent intent2 = new Intent(SecondHomePage.this, DiscoverActivity.class);
//                        startActivity(intent2);
//                        break;
//
//                    case R.id.ic_search:
//                        Intent intent3 = new Intent(SecondHomePage.this, SearchActivity.class);
//                        startActivity(intent3);
//                        break;
//
//                    case R.id.ic_library:
//                        Intent intent4 = new Intent(SecondHomePage.this, LibraryActivity.class);
//                        startActivity(intent4);
//                        break;
//
//                    case R.id.ic_profile:
//                        Intent intent5 = new Intent(SecondHomePage.this, ProfileActivity.class);
//                        startActivity(intent5);
//                        break;
//
//                }
//                return false;
//
//            }
//        });

        japanese[0] = "language_Japanese";
        japanese[1] = "Japanese";

        french[0] = "language_French";
        french[1] = "French";


    }


    public void handleJap(View object){
        languageVariable = 1;
        sendDatatoActivity(japanese[1], languageVariable);

    }

    public void handleFrench(View object){
        languageVariable = 2;
        sendDatatoActivity(french[1], languageVariable);
    }

    public void handleJazz(View object){
        genreVariable = 1;
        genreTitle = "Jazz";
        sendDatatoActivity2(genreTitle, genreVariable);
    }
    public void handleMetal(View object){
        genreVariable = 2;
        genreTitle = "Metal";
        sendDatatoActivity2(genreTitle, genreVariable);
    }
    public void handleElectronic(View object){
        genreVariable = 3;
        genreTitle = "Electronic";
        sendDatatoActivity2(genreTitle, genreVariable);
    }
    public void handleSeeAll(View object){
        Intent intent = new Intent(this, AllLanguageActivity.class);
        startActivity(intent);
    }
    public void handleGaming(View object){
        moodVariable = 1;
        moodTitle = "Gaming";
        sendDatatoActivity3(moodTitle ,moodVariable);
    }
    public void handleBlues(View object){
        moodVariable = 2;
        moodTitle = "Blues";
        sendDatatoActivity3(moodTitle, moodVariable);
    }
    public void handleExercise(View object){
        moodVariable = 3;
        moodTitle = "Exercise";
        sendDatatoActivity3(moodTitle, moodVariable);
    }


    /*public String[] checkLanguage(String languageID) {
        String[] languageTitle = null;
        for (int index = 0; index < language.length; index++) {
            languageTitle = (String[]) language[index];

            if (languageTitle[0].equals(languageID)) {
                return languageTitle;
            }
        }
        return languageTitle;
    }*/

    public void sendDatatoActivity(String lang, int languageVariable){
        Intent intent = new Intent(this, LanguageActivity.class);
        intent.putExtra("languageVariable", languageVariable);
        intent.putExtra("title", lang);
        startActivity(intent);
    }

    public void sendDatatoActivity2(String genre, int genreVariable) {
        Intent intent = new Intent(this, GenreSelectionActivity.class);
        intent.putExtra("title", genre);
        intent.putExtra("genreVariable", genreVariable);
        startActivity(intent);
    }

    public void sendDatatoActivity3(String mood, int moodVariable) {
        Intent intent = new Intent(this, MoodSelection.class);
        intent.putExtra("title", mood);
        intent.putExtra("moodVariable", moodVariable);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.setting:
                Intent intent = new Intent(SecondHomePage.this, Settings.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}

