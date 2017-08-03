package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import polytechnic.temasek.bluebeatsmusicapplication.Util.ConstantUtil;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;
import polytechnic.temasek.bluebeatsmusicapplication.R;

public class ProfileActivity extends AppBaseActivity {
    @Override
    protected int getCheckedBottomMenuIndex() {
        return ConstantUtil.BOTTOM_NAV_PROFILE_SEQ;
    }

    @Override
    protected int getCurrentViewIndex() {
        return ConstantUtil.BOTTOM_NAV_PROFILE_SEQ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadBottomMenu();
//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//        Menu menu = bottomNavigationView.getMenu();
//        MenuItem theMenuItem = menu.getItem(4);
//        theMenuItem.setChecked(true);
//
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//
//                    case R.id.ic_home:
//                        Intent intent1 = new Intent(ProfileActivity.this, SecondHomePage.class);
//                        startActivity(intent1);
//                        break;
//
//                    case R.id.ic_discover:
//                        Intent intent2 = new Intent(ProfileActivity.this, DiscoverActivity.class);
//                        startActivity(intent2);
//                        break;
//
//                    case R.id.ic_search:
//                        Intent intent3 = new Intent(ProfileActivity.this, SearchActivity.class);
//                        startActivity(intent3);
//                        break;
//
//                    case R.id.ic_library:
//                        Intent intent4 = new Intent(ProfileActivity.this, LibraryActivity.class);
//                        startActivity(intent4);
//                        break;
//
//                    case R.id.ic_profile:
//                        break;
//
//                }
//                return false;
//            }
//        });
    }
}
