package polytechnic.temasek.bluebeatsmusicapplication.subpages;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.DiscoverActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.LibraryActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.ProfileActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.SearchActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.SecondHomePage;

public class PlaylistPage extends AppCompatActivity {

    //private ActionMenuView amvMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Playlists");
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        /*amvMenu = (ActionMenuView) toolbar.findViewById(R.id.amvMenu);
        amvMenu.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return onOptionsItemSelected(menuItem);
            }
        });*/

        setSupportActionBar(toolbar);
        /*getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem theMenuItem = menu.getItem(3);
        theMenuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        Intent intent1 = new Intent(PlaylistPage.this, SecondHomePage.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_discover:
                        Intent intent2 = new Intent(PlaylistPage.this, DiscoverActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_search:
                        Intent intent3 = new Intent(PlaylistPage.this, SearchActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_library:
                        break;

                    case R.id.ic_profile:
                        Intent intent4 = new Intent(PlaylistPage.this, ProfileActivity.class);
                        startActivity(intent4);
                        break;

                }
                return false;
            }
        });
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

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
}

