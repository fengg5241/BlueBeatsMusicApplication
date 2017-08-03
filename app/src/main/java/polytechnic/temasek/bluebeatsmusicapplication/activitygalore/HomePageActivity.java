package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import polytechnic.temasek.bluebeatsmusicapplication.R;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar actionBarToolBar = (Toolbar) findViewById(R.id.toolbar);
        actionBarToolBar.setTitle("Home");
    }
}
