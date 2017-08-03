package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.Util.ConstantUtil;
import polytechnic.temasek.bluebeatsmusicapplication.UtilityClasses.BottomNavigationViewHelper;

/**
 * Created by feng on 30/07/17.
 */

public class AppBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void loadBottomMenu(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.the_bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem theMenuItem = menu.getItem(getCheckedBottomMenuIndex());
        theMenuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        if(getCurrentViewIndex() != ConstantUtil.BOTTOM_NAV_HOME_SEQ){
                            Intent intent1 = new Intent(AppBaseActivity.this, SecondHomePage.class);
                            startActivity(intent1);
                        }

                        break;

                    case R.id.ic_discover:
                        if(getCurrentViewIndex() != ConstantUtil.BOTTOM_NAV_DISCOVER_SEQ){
                            Intent intent1 = new Intent(AppBaseActivity.this, DiscoverActivity.class);
                            startActivity(intent1);
                        }

                        break;

                    case R.id.ic_search:
                        if(getCurrentViewIndex() != ConstantUtil.BOTTOM_NAV_SEARCH_SEQ){
                            Intent intent2 = new Intent(AppBaseActivity.this, SearchActivity.class);
                            startActivity(intent2);
                        }

                        break;

                    case R.id.ic_library:
                        if(getCurrentViewIndex() != ConstantUtil.BOTTOM_NAV_LIBRARY_SEQ){
                            Intent intent2 = new Intent(AppBaseActivity.this, LibraryActivity.class);
                            startActivity(intent2);
                        }

                        break;

                    case R.id.ic_profile:
                        if(getCurrentViewIndex() != ConstantUtil.BOTTOM_NAV_PROFILE_SEQ){
                            Intent intent2 = new Intent(AppBaseActivity.this, ProfileActivity.class);
                            startActivity(intent2);
                        }

                        break;

                }
                return false;
            }
        });
    }

    protected int getCheckedBottomMenuIndex() {
        return ConstantUtil.BOTTOM_NAV_HOME_SEQ;
    }

    protected int getCurrentViewIndex() {
        return ConstantUtil.BOTTOM_NAV_HOME_SEQ;
    }
}
