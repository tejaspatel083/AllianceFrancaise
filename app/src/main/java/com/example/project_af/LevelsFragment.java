package com.example.project_af;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class LevelsFragment extends Fragment {

    private CardView c1,c2,c3;
    private NavController navController;


    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_levels,container,false);
        getActivity().setTitle("Levels");

        c1 = view.findViewById(R.id.easyCard);
        c2 = view.findViewById(R.id.moderateCard);
        c3 = view.findViewById(R.id.difficultCard);


        Fragment fragment = null;

        navController = Navigation.findNavController(getActivity(),R.id.Host_Fragment2);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.beginnerFragment);

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.moderateFragment);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.difficultFragment);
            }
        });



        return view;
    }


}
