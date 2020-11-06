package com.pranay.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Activity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    EditText email,password;
    ProgressBar progressBar;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_);


        firebaseAuth=FirebaseAuth.getInstance();

        firebaseDatabase=FirebaseDatabase.getInstance();
        TextView textView=findViewById(R.id.signup_text);
        email=findViewById(R.id.email2);
        password=findViewById(R.id.pass2);
        final Button button=findViewById(R.id.signup);
        progressBar=findViewById(R.id.prog2);


        databaseReference=FirebaseDatabase.getInstance().getReference("Users");



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup_Activity.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=email.getText().toString();
                String pass=password.getText().toString();
                if (!mail.isEmpty() && !pass.isEmpty()) {

                    progressBar.setVisibility(View.VISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                progressBar.setVisibility(View.INVISIBLE);
                                button.setVisibility(View.VISIBLE);
                                startActivity(new Intent(Signup_Activity.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                                finish();


                                databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("email").setValue(firebaseAuth.getCurrentUser().getEmail());
                                databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("snake_score").setValue("0");
                                databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("space_fighter_score").setValue("0");
                                databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("word_game").setValue("0");
                                databaseReference.child(firebaseAuth.getCurrentUser().getUid()).child("flappy_score").setValue("0");

                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Signup_Activity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                            button.setVisibility(View.VISIBLE);
                            startActivity(new Intent(Signup_Activity.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                            finish();
                        }
                    });
                }
            }
        });



    }
}
