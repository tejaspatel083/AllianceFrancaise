package com.example.project_af;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;

public class NumbersFragment extends Fragment {


    private ImageButton b0,b1M,b1F,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    MediaPlayer mp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_numbers,container,false);
        getActivity().setTitle("Numbers");


        b0 = view.findViewById(R.id.action00);
        b1M = view.findViewById(R.id.action1M);
        b1F = view.findViewById(R.id.action1F);
        b2 = view.findViewById(R.id.action2);
        b3 = view.findViewById(R.id.action3);
        b4 = view.findViewById(R.id.action4);
        b5 = view.findViewById(R.id.action5);
        b6 = view.findViewById(R.id.action6);
        b7 = view.findViewById(R.id.action7);
        b8 = view.findViewById(R.id.action8);
        b9 = view.findViewById(R.id.action9);
        b10 = view.findViewById(R.id.action10);



        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.zero);
                mp.start();

            }
        });

        b1M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.onem);
                mp.start();

            }
        });

        b1F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.onef);
                mp.start();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.two);
                mp.start();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.three);
                mp.start();

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.four);
                mp.start();

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.five);
                mp.start();

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.six);
                mp.start();

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.seven);
                mp.start();

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.eight);
                mp.start();

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.nine);
                mp.start();

            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.ten);
                mp.start();

            }
        });



        return view;
    }
}
