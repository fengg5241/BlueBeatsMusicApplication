package polytechnic.temasek.bluebeatsmusicapplication.subpages;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.DiscoverActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.LanguageActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.LibraryActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.ProfileActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.SearchActivity;
import polytechnic.temasek.bluebeatsmusicapplication.activitygalore.SecondHomePage;

public class ArtistInfoActivity extends AppCompatActivity {

    TextView artistTitle;
    String artist;
    String artistBiographyInformation;
    TextView artistBiography;
    TextView biographyInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_back);

        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        Intent intent1 = new Intent(ArtistInfoActivity.this, SecondHomePage.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_discover:
                        Intent intent2 = new Intent(ArtistInfoActivity.this, DiscoverActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_search:
                        Intent intent3 = new Intent(ArtistInfoActivity.this, SearchActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_library:
                        Intent intent4 = new Intent(ArtistInfoActivity.this, LibraryActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.ic_profile:
                        Intent intent5 = new Intent(ArtistInfoActivity.this, ProfileActivity.class);
                        startActivity(intent5);
                        break;
                }
                return false;

            }
        });


        artistTitle = (TextView) findViewById(R.id.toolbartitle);
        artistBiography = (TextView) findViewById(R.id.txtview_ArtistNameBio);
        biographyInformation = (TextView) findViewById(R.id.txtview_Biography);
        retrieveInfo();
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
        artist = pageInfo.getString("artistName");
        artistBiographyInformation = pageInfo.getString("artistBiography");
        artistTitle.setText(artist);
        artistBiography.setText(artist + " Biography");
        biographyInformation.setText(artistBiographyInformation);

    }


}
