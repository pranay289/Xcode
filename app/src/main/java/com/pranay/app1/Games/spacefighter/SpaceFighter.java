package com.pranay.app1.Games.spacefighter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.pranay.app1.MainActivity;
import com.pranay.app1.R;


public class SpaceFighter extends Activity implements View.OnClickListener {


    //image button
    private ImageButton buttonPlay;
    // the high score button
    private ImageButton buttonScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spacefighter);







        //setting the orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);



        //getting the button
        buttonPlay = (ImageButton) findViewById(R.id.buttonPlay);

        //initializing the highscore button
        buttonScore = (ImageButton) findViewById(R.id.buttonScore);

        //setting the on click listener to high score button
        buttonScore.setOnClickListener(this);
        //setting the on click listener to play now button
        buttonPlay.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(v==buttonPlay){

            //the transition from MainActivity to GameActivity
            startActivity(new Intent(SpaceFighter.this, GameActivity.class));
        }
        if(v==buttonScore){
            //the transition from MainActivity to HighScore activity
            startActivity(new Intent(SpaceFighter.this,HighScore.class));
        }


    }
    @Override
    public void onBackPressed() {
        GameView.stopMusic();

        startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }



}