package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applySettings();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent  = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, 1);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        applySettings();
    }

    void applySettings() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean background = preferences.getBoolean("background", true);

        View view = findViewById(android.R.id.content);
        view.setBackgroundResource(background? android.R.color.darker_gray : android.R.color.transparent);
    }
}
