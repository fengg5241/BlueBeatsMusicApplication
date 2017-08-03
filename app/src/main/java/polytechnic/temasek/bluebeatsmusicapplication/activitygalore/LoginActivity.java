package polytechnic.temasek.bluebeatsmusicapplication.activitygalore;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import polytechnic.temasek.bluebeatsmusicapplication.R;
import polytechnic.temasek.bluebeatsmusicapplication.dbHelper.UserDbHelper;

public class LoginActivity extends AppCompatActivity {

    private String username;
    private String password;

    EditText etUsername;
    EditText etPassword;

    private UserDbHelper userDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        final Button btnLogin = (Button) findViewById(R.id.Login);

        final TextView linkRegister = (TextView) findViewById(R.id.txtViewRegister);

        linkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);


            }
        });

        setupUI(findViewById(R.id.loginPage));

        createDefaultUser();

    }

    private void createDefaultUser() {
        userDbHelper = new UserDbHelper(this);
        if(!userDbHelper.isExistUser("admin")){
            userDbHelper.createUser("admin","admin");
        }
    }

    public void retrieveInfo(){
        Bundle pageInfo = this.getIntent().getExtras();
        username = pageInfo.getString("username");
        password = pageInfo.getString("password");
    }

    public void loginToHomepage(View view){

        if (TextUtils.isEmpty(etUsername.getText()) || TextUtils.isEmpty(etPassword.getText())) {
            Toast.makeText(LoginActivity.this, "UserName or Password can not be empty",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if (userDbHelper.validateUser(etUsername.getText().toString(),
                etPassword.getText().toString())) {
            Intent intent = new Intent(LoginActivity.this, SecondHomePage.class);
            startActivity(intent);
        }else {
            Toast.makeText(LoginActivity.this, "Wrong Username or Password, please try again!",
                        Toast.LENGTH_LONG).show();
        }

        return;

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
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(LoginActivity.this);
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
}
