package com.example.project_af;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizScoreFragment extends Fragment {


    private TextView scoreText;
    private String s;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_quiz_score,container,false);
        getActivity().setTitle("Quiz Score");

        scoreText = view.findViewById(R.id.score_text);


        Bundle bundle = this.getArguments();

        if(bundle != null){

            s = bundle.getString("key");
            scoreText.setText(s+"/5");
        }
        else
        {
            scoreText.setText("Error");
        }



        return view;
    }
}
