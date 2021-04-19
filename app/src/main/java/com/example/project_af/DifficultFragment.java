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

public class DifficultFragment extends Fragment {

    private NavController navController;
    private TextView t1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_difficult,container,false);
        getActivity().setTitle("Difficult");

        navController = Navigation.findNavController(getActivity(),R.id.Host_Fragment2);

        t1 = view.findViewById(R.id.quizClick3);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.quizDifficultFragment);
            }
        });

        return view;
    }
}
