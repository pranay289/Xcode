package com.pranay.app1.Games.spacefighter;

import android.content.Context;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pranay.app1.R;

import org.w3c.dom.Text;

public class HighScore extends AppCompatActivity {

    TextView textView, textView2, textView3, textView4;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_game2);
        setContentView(R.layout.activity_high_score);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);

        sharedPreferences = getSharedPreferences("SHAR_PREF_NAME", Context.MODE_PRIVATE);

        textView.setText("1." + sharedPreferences.getInt("score1", 0));
        textView2.setText("2." + sharedPreferences.getInt("score2", 0));
        textView3.setText("3." + sharedPreferences.getInt("score3", 0));
        textView4.setText("4." + sharedPreferences.getInt("score4", 0));






    }
}
