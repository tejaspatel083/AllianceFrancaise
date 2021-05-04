package com.example.project_af;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ModerateFragment extends Fragment {

    private NavController navController;
    private TextView t1,t2,t3,t4;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_moderate,container,false);
        getActivity().setTitle("Moderate");


        navController = Navigation.findNavController(getActivity(),R.id.Host_Fragment2);

        t1 = view.findViewById(R.id.moderateGreetings);
        t2 = view.findViewById(R.id.moderateOccupations);
        t3 = view.findViewById(R.id.moderatePlaces);
        t4 = view.findViewById(R.id.moderateQuiz);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.greetings);
            }
        });


        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.occupations);
            }
        });


        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.places);
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.quizModerateFragment);
            }
        });


        return view;
    }
}
