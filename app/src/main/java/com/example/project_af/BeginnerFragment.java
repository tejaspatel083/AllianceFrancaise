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

public class BeginnerFragment extends Fragment {


    private TextView t1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_beginner,container,false);
        getActivity().setTitle("Beginner");


        t1 = view.findViewById(R.id.quizClick);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                QuizBeginnerFragment fragment = new QuizBeginnerFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,new QuizBeginnerFragment()).commit();
            }
        });


        return view;
    }
}
