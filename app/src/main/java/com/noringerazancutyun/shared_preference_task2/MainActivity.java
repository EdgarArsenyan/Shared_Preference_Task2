package com.noringerazancutyun.shared_preference_task2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.noringerazancutyun.shared_preference_task2.FinalValues.PASSWORD_KEY;
import static com.noringerazancutyun.shared_preference_task2.FinalValues.PREFERENCE;
import static com.noringerazancutyun.shared_preference_task2.FinalValues.USERNAME_KEY;

public class MainActivity extends AppCompatActivity {

    private EditText usernameText;
    private EditText passwordText;
    private Button loginButton;
    private SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        isLogIn();
        loginUser();
    }

    private void init() {
        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
        loginButton = findViewById(R.id.button);
    }

    private void loginUser() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernameText.getText()==null & passwordText.getText()== null){
                    pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString(USERNAME_KEY, usernameText.getText().toString());
                    editor.putString(PASSWORD_KEY, passwordText.getText().toString());
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this, AccountActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Username or Password Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void isLogIn() {
        SharedPreferences preferences = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        if (preferences.getString(USERNAME_KEY, null) != null) {
            Intent intent = new Intent(MainActivity.this, AccountActivity.class);
            startActivity(intent);
        }
    }
}
