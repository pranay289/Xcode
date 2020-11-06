package com.pranay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.model;
import com.pranay.app1.Games.BossAct;
import com.pranay.app1.Games.Snkgame.Snake_main_activity;
import com.pranay.app1.Games.flappybird.FlappyGameactivity;
import com.pranay.app1.Games.flappybird.StartingActivity;
import com.pranay.app1.Games.spacefighter.SpaceFighter;
import com.pranay.app1.R;

import java.util.ArrayList;

public class Adpater extends RecyclerView.Adapter<Adpater.Myholder> {

    ArrayList<model> arrayList;
    Context context;

    public Adpater(ArrayList<model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myholder holder, final int position) {
        model model=arrayList.get(position);

        holder.textView.setText(model.getTitle());
        holder.imageView.setImageResource(model.getImage());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position){

                    case 0:context.startActivity(new Intent(context, Snake_main_activity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                           break;
                    case 1:context.startActivity(new Intent(context, SpaceFighter.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                            break;
                    case 2:context.startActivity(new Intent(context, BossAct.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    break;
                    case 3:context.startActivity(new Intent(context, StartingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class Myholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.card_image);
            textView=itemView.findViewById(R.id.card_title);
        }
    }
}
