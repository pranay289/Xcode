package com.pranay.app1.ui.stats;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pranay.app1.R;

import java.util.ArrayList;
import java.util.List;

public class StatsFragment extends Fragment {
    String[] chart_val = { "Memory","Flexibility","Speed","Attention"};
    List<Integer> val;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    final int constant=250;
TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        final AnyChartView anyChartView = view.findViewById(R.id.chart);

        textView=view.findViewById(R.id.textView6);
        final Pie pie = AnyChart.pie();
        val=new ArrayList<>();
        final List<DataEntry> list = new ArrayList<>();
        databaseReference.child(firebaseAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                int snake_score = Integer.parseInt(snapshot.child("snake_score").getValue().toString());
                int space = Integer.parseInt(snapshot.child("space_fighter_score").getValue().toString());
                int word = Integer.parseInt(snapshot.child("word_game").getValue().toString());
                int flappy = Integer.parseInt(snapshot.child("flappy_score").getValue().toString());
                val.add(snake_score);
                val.add(space);
                val.add(word);
                val.add(flappy);
                Log.i("size",String.valueOf(val.size()));

                int[] y = {10, 20, 30};

                for (int i = 0; i < chart_val.length; i++) {

                    list.add(new ValueDataEntry(chart_val[i], val.get(i)));
                }
                int sum=0;
                for (int j=0;j<val.size();j++)
                {
                    sum=sum+val.get(j);
                }
                Log.i("addition", String.valueOf(sum));

                if (sum<35){
                    //stage 7
                    textView.setText("Very Severe Decline");

                }else if (sum>35 && sum<70){

                    //stage 6
                    textView.setText("Severe Decline.");

                }else if (sum>70 && sum<105){
                    //stage 5
                    textView.setText("Moderately Severe Decline.");

                }
                else if (sum>105 && sum<140){
                    // stage 4
                    textView.setText("Moderate Decline.");
                }
                else if (sum>140 && sum<175){
                    //stage 3
                    textView.setText("Mild Decline.");
                }else if (sum>175 && sum<210){
                    //stage 2
                    textView.setText("Very Mild Decline.");
                }
                else if (sum>210 && sum<250){
                   //stage 1
                    textView.setText("No impairment/Normal Outward Behavior.");

                }else if (sum>250){

                        //stage 1
                        textView.setText("No impairment/Normal Outward Behavior.");


                }
                pie.data(list);
                anyChartView.setChart(pie);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        return view;
    }
}