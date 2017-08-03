package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import polytechnic.temasek.bluebeatsmusicapplication.Util.ConstantUtil;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.SectionsPageAdapter;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.Tab1Fragment;
import polytechnic.temasek.bluebeatsmusicapplication.subpages.AlbumPage;
import polytechnic.temasek.bluebeatsmusicapplication.subpages.ArtistPage;
import polytechnic.temasek.bluebeatsmusicapplication.subpages.ListeningHistory;
import polytechnic.temasek.bluebeatsmusicapplication.subpages.PlaylistPage;
import polytechnic.temasek.bluebeatsmusicapplication.subpages.SongPage;

public class LibraryActivity extends AppBaseActivity {

    private Toolbar toolbar;

    private static final String TAG = "LibraryActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected int getCheckedBottomMenuIndex() {
        return ConstantUtil.BOTTOM_NAV_LIBRARY_SEQ;
    }

    @Override
    protected int getCurrentViewIndex() {
        return ConstantUtil.BOTTOM_NAV_LIBRARY_SEQ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setUpViewPager(mViewPager);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_profile);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LibraryActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        loadBottomMenu();
//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//        Menu menu = bottomNavigationView.getMenu();
//        MenuItem theMenuItem = menu.getItem(3);
//        theMenuItem.setChecked(true);
//
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//
//                    case R.id.ic_home:
//                        Intent intent1 = new Intent(LibraryActivity.this, SecondHomePage.class);
//                        startActivity(intent1);
//                        break;
//
//                    case R.id.ic_discover:
//                        Intent intent2 = new Intent(LibraryActivity.this, DiscoverActivity.class);
//                        startActivity(intent2);
//                        break;
//
//                    case R.id.ic_search:
//                        Intent intent3 = new Intent(LibraryActivity.this, SearchActivity.class);
//                        startActivity(intent3);
//                        break;
//
//                    case R.id.ic_library:
//                        break;
//
//                    case R.id.ic_profile:
//                        Intent intent4 = new Intent(LibraryActivity.this, ProfileActivity.class);
//                        startActivity(intent4);
//                        break;
//
//                }
//                return false;
//            }
//        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "TAB1");
        viewPager.setAdapter(adapter);
    }

    public void jumpToPage(View view) {
        Intent intent = new Intent(LibraryActivity.this, PlaylistPage.class);
        startActivity(intent);
    }

    public void handleSongs(View view) {
        Intent intent = new Intent(LibraryActivity.this, SongPage.class);
        startActivity(intent);
    }

    public void handleAlbums(View view) {
        Intent intent = new Intent(LibraryActivity.this, AlbumPage.class);
        startActivity(intent);
    }

    public void handleArtists(View view){
        Intent intent = new Intent(LibraryActivity.this, ArtistPage.class);
        startActivity(intent);
    }

    public void handleListeningHistory(View view) {
        Intent intent = new Intent(LibraryActivity.this, ListeningHistory.class);
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
                Intent intent = new Intent(LibraryActivity.this, Settings.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
