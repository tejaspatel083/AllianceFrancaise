package com.example.project_af;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

public class QuizDifficultFragment extends Fragment {

    private ImageView queImg;
    private TextView dScoreView;
    private Button btnChoice1,btnChoice2,btnChoice3,btnChoice4;

    private int dScore = 0;
    private int dQuestionNumber = 1;
    private String dAnswer;

    private Firebase dQuestionRef,dAnswerRef,dChoice1Ref,dChoice2Ref,dChoice3Ref,dChoice4Ref;

    private ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_quiz_difficult,container,false);
        getActivity().setTitle("Difficult Quiz");

        queImg = view.findViewById(R.id.difficultQuizImage);
        dScoreView = view.findViewById(R.id.score);

        btnChoice1 = view.findViewById(R.id.btnD1);
        btnChoice2 = view.findViewById(R.id.btnD2);
        btnChoice3 = view.findViewById(R.id.btnD3);
        btnChoice4 = view.findViewById(R.id.btnD4);

        progressDialog = new ProgressDialog(getContext());

        progressDialog.setMessage("Loading...");
        progressDialog.show();

        updateQuestion(dScore);






        btnChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (btnChoice1.getText().equals(dAnswer))
                    {
                        dScore = dScore + 1;
                        //updateScore(dScore);
                        updateQuestion(dScore);
                    }
                    else
                    {
                        updateQuestion(dScore);
                    }
                }
            });

        btnChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (btnChoice2.getText().equals(dAnswer))
                    {
                        dScore = dScore + 1;
                        //updateScore(dScore);
                        updateQuestion(dScore);
                    }
                    else
                    {
                        updateQuestion(dScore);
                    }
                }
            });

        btnChoice3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (btnChoice3.getText().equals(dAnswer))
                    {
                        dScore = dScore + 1;
                        //updateScore(dScore);
                        updateQuestion(dScore);
                    }
                    else
                    {
                        updateQuestion(dScore);
                    }
                }
            });

        btnChoice4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (btnChoice4.getText().equals(dAnswer))
                    {
                        dScore = dScore + 1;
                        //updateScore(dScore);
                        updateQuestion(dScore);
                    }
                    else
                    {
                        updateQuestion(dScore);
                    }
                }
            });



        
        return view;
    }

   /* private void updateScore(int score)
    {
        dScoreView.setText(""+score);
    }*/




    private void updateQuestion(int result) {


        dQuestionRef = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Difficult/Quiz/"+dQuestionNumber+"/Question");

        dQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String question = dataSnapshot.getValue(String.class);

                Picasso.get().load(question).into(queImg);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        dChoice1Ref = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Difficult/Quiz/"+dQuestionNumber+"/Choice1");


        dChoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String choice = dataSnapshot.getValue(String.class);
                btnChoice1.setText(choice);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        dChoice2Ref = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Difficult/Quiz/"+dQuestionNumber+"/Choice2");

        dChoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String choice = dataSnapshot.getValue(String.class);
                btnChoice2.setText(choice);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        dChoice3Ref = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Difficult/Quiz/"+dQuestionNumber+"/Choice3");

        dChoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String choice = dataSnapshot.getValue(String.class);
                btnChoice3.setText(choice);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        dChoice4Ref = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Difficult/Quiz/"+dQuestionNumber+"/Choice4");

        dChoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String choice = dataSnapshot.getValue(String.class);
                btnChoice4.setText(choice);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        dAnswerRef = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Difficult/Quiz/"+dQuestionNumber+"/Answer");

        dAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                dAnswer = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        dQuestionNumber++;

        if (dQuestionNumber > 6)
        {
            Toast.makeText(getActivity(), "Quiz Ended", Toast.LENGTH_SHORT).show();
            //navController.navigate(R.id.quizScoreFragment);


            Bundle bundle = new Bundle();
            bundle.putString("key",String.valueOf(result)); // Put anything what you want

            Fragment fragment = null;
            fragment = new QuizScoreFragment();
            fragment.setArguments(bundle);

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Host_Fragment2,fragment)
                    .commit();
        }

    }
}
