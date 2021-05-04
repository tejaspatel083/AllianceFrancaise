package com.example.project_af;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class QuizBeginnerFragment extends Fragment {

    Button b1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_quiz_beginner,container,false);
        getActivity().setTitle("Beginner Quiz");


        b1 = view.findViewById(R.id.btn11);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                QuizScoreFragment fragment = new QuizScoreFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,new QuizScoreFragment()).commit();
            }
        });



        return view;
    }
}
