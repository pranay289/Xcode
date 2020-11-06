package com.pranay.app1;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.model;
import com.pranay.Adpater;

import java.util.ArrayList;

public class Allgames extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> list;
    Adpater adpater;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgamesactivity);



        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        list=new ArrayList<>();

        list.add(new model("Snake Game",R.drawable.snakeicon));
        list.add(new model("Space Fighter",R.drawable.space_fighter_icon));
        list.add(new model("Word Game",R.drawable.scrabble));
        list.add(new model("Flappy Bird",R.drawable.bird));


        adpater=new Adpater(list,this);
        recyclerView.setAdapter(adpater);

    }
}
