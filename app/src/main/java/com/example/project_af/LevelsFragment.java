package com.example.project_af;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LevelsFragment extends Fragment {

    private CardView c1,c2,c3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_levels,container,false);
        getActivity().setTitle("Levels");

        c1 = view.findViewById(R.id.easyCard);
        c2 = view.findViewById(R.id.moderateCard);
        c3 = view.findViewById(R.id.difficultCard);



        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BeginnerFragment fragment = new BeginnerFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,new BeginnerFragment()).commit();


            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModerateFragment fragment = new ModerateFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,new ModerateFragment()).commit();

            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DifficultFragment fragment = new DifficultFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,new DifficultFragment()).commit();

            }
        });



        return view;
    }
}
