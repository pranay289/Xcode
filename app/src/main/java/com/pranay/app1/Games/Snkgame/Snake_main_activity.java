package com.pranay.app1.Games.Snkgame;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pranay.app1.Games.spacefighter.GameActivity;
import com.pranay.app1.R;

public class Snake_main_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        TextView title = (TextView) findViewById(R.id.title);
        TextView startBtn = (TextView) findViewById(R.id.startBtn);
        TextView settingsBtn = (TextView) findViewById(R.id.settingsBtn);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Fipps-Regular.otf");
        title.setTypeface(font);
        startBtn.setTypeface(font);
        settingsBtn.setTypeface(font);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, SnakeGame.class);
        startActivity(intent);
    }
    public void goToSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
