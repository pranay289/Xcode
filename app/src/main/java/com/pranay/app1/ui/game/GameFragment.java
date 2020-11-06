package com.pranay.app1.ui.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pranay.app1.Allgames;
import com.pranay.app1.Games.Snkgame.Snake_main_activity;
import com.pranay.app1.Games.Wordmatter;
import com.pranay.app1.Games.spacefighter.SpaceFighter;
import com.pranay.app1.R;


public class GameFragment extends Fragment {
    Button button,phase2,phase3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_game,container,false);

        button=view.findViewById(R.id.phase1);
        phase2=view.findViewById(R.id.phase2);
        phase3=view.findViewById(R.id.phase3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Allgames.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK));
            }
        });

        phase2.setEnabled(false);
        phase3.setEnabled(false);



        return view;

    }
}
