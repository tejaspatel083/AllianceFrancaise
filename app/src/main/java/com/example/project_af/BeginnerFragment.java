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

public class BeginnerFragment extends Fragment {


    private TextView t1,t2,t3,t4;
    private NavController navController;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_beginner,container,false);
        getActivity().setTitle("Beginner");

        navController = Navigation.findNavController(getActivity(),R.id.Host_Fragment2);



        t1 = view.findViewById(R.id.beginnerNumbers);
        t2 = view.findViewById(R.id.beginnerDays);
        t3 = view.findViewById(R.id.beginnerMonths);
        t4 = view.findViewById(R.id.beginnerQuiz);



        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.numbersFragment);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.days);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.months);
            }
        });


        return view;
    }
}
