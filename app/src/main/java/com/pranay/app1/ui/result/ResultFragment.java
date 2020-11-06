package com.pranay.app1.ui.result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pranay.app1.R;

public class ResultFragment extends Fragment {
    TextView snake,space,word,flappy;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_result, container, false);

       snake=view.findViewById(R.id.snake_score);
       space=view.findViewById(R.id.space_score);
       word=view.findViewById(R.id.word_score);
        flappy=view.findViewById(R.id.flappy_score);
       firebaseAuth=FirebaseAuth.getInstance();
       database=FirebaseDatabase.getInstance();

       databaseReference=FirebaseDatabase.getInstance().getReference("Users");
       databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {

               String snake_game=snapshot.child("snake_score").getValue().toString();
               String space_game=snapshot.child("space_fighter_score").getValue().toString();
               String word_game=snapshot.child("word_game").getValue().toString();
               String flappy_score=snapshot.child("flappy_score").getValue().toString();


               snake.setText("Best Score : "+snake_game);
               space.setText("Best Score : "+space_game);
               word.setText("Best Score : "+word_game);
               flappy.setText("Best Score : "+flappy_score);
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });


        return view;
    }
}
