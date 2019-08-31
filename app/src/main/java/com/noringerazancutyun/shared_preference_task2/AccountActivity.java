package com.noringerazancutyun.shared_preference_task2;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.noringerazancutyun.shared_preference_task2.FinalValues.SHARED_PREF;

public class AccountActivity extends AppCompatActivity {

    private Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        logOut = findViewById(R.id.logout);
        logOut();
    }

    private void logOut(){
        logOut.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                preferences.edit().clear();
            }
        });
    }


}
