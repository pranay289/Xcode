package com.pranay.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Settings extends AppCompatActivity {

    TextView textView;
    Button button;
    SharedPreferences sharedPreferences;
    SharedPreferences getSharedPreferences;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);

        textView=findViewById(R.id.show_email);
        button=findViewById(R.id.logout);
        firebaseAuth=FirebaseAuth.getInstance();
        textView.setText(firebaseAuth.getCurrentUser().getEmail());


        getSharedPreferences=getSharedPreferences("my_pref",MODE_PRIVATE);

        final boolean val=getSharedPreferences.getBoolean("val",false);


        sharedPreferences=getSharedPreferences("my_pref",MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (val){
                    editor.putBoolean("val",false).apply();
                }
                startActivity(new Intent(Settings.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        });

    }
}
