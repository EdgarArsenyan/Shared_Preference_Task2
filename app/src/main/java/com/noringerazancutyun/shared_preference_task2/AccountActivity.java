package com.noringerazancutyun.shared_preference_task2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.noringerazancutyun.shared_preference_task2.FinalValues.PREFERENCE;

public class AccountActivity extends AppCompatActivity {

    private Button logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        logOutButton = findViewById(R.id.logout);
        logOut();
    }

    private void logOut(){
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.clear();
                editor.apply();
                Intent intent =new Intent(AccountActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
