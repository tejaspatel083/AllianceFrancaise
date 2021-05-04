package com.example.project_af;

import android.app.ProgressDialog;
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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

public class QuizModerateFragment extends Fragment {

    private ImageView queImg;
    private TextView mScoreView;
    private Button btnChoice1,btnChoice2,btnChoice3,btnChoice4;

    private int mScore = 0;
    private int mQuestionNumber = 1;
    private String mAnswer;

    private Firebase mQuestionRef,mAnswerRef,mChoice1Ref,mChoice2Ref,mChoice3Ref,mChoice4Ref;

    private ProgressDialog progressDialog;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_quiz_moderate,container,false);
        getActivity().setTitle("Moderate Quiz");
        queImg = view.findViewById(R.id.moderateQuizImage);
        mScoreView = view.findViewById(R.id.scoreModerate);

        btnChoice1 = view.findViewById(R.id.btnM1);
        btnChoice2 = view.findViewById(R.id.btnM2);
        btnChoice3 = view.findViewById(R.id.btnM3);
        btnChoice4 = view.findViewById(R.id.btnM4);

        progressDialog = new ProgressDialog(getContext());

        progressDialog.setMessage("Loading...");
        progressDialog.show();

        updateQuestion(mScore);




        btnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnChoice1.getText().equals(mAnswer))
                {
                    mScore = mScore + 1;
                    //updateScore(mScore);
                    updateQuestion(mScore);
                }
                else
                {
                    updateQuestion(mScore);
                }
            }
        });

        btnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnChoice2.getText().equals(mAnswer))
                {
                    mScore = mScore + 1;
                    //updateScore(mScore);
                    updateQuestion(mScore);
                }
                else
                {
                    updateQuestion(mScore);
                }
            }
        });

        btnChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnChoice3.getText().equals(mAnswer))
                {
                    mScore = mScore + 1;
                    //updateScore(mScore);
                    updateQuestion(mScore);
                }
                else
                {
                    updateQuestion(mScore);
                }
            }
        });

        btnChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnChoice4.getText().equals(mAnswer))
                {
                    mScore = mScore + 1;
                    //updateScore(mScore);
                    updateQuestion(mScore);
                }
                else
                {
                    updateQuestion(mScore);
                }
            }
        });




        return view;
    }


/*

    private void updateScore(int score)
    {
        mScoreView.setText(""+score);
    }
*/

    private void updateQuestion(int result) {


        mQuestionRef = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Moderate/Quiz/"+mQuestionNumber+"/Question");

        mQuestionRef.addValueEventListener(new ValueEventListener() {
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

        mChoice1Ref = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Moderate/Quiz/"+mQuestionNumber+"/Choice1");


        mChoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String choice = dataSnapshot.getValue(String.class);
                btnChoice1.setText(choice);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice2Ref = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Moderate/Quiz/"+mQuestionNumber+"/Choice2");

        mChoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String choice = dataSnapshot.getValue(String.class);
                btnChoice2.setText(choice);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mChoice3Ref = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Moderate/Quiz/"+mQuestionNumber+"/Choice3");

        mChoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String choice = dataSnapshot.getValue(String.class);
                btnChoice3.setText(choice);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mChoice4Ref = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Moderate/Quiz/"+mQuestionNumber+"/Choice4");

        mChoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String choice = dataSnapshot.getValue(String.class);
                btnChoice4.setText(choice);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        mAnswerRef = new Firebase("https://alliancefrancaise-68d75-default-rtdb.firebaseio.com/Moderate/Quiz/"+mQuestionNumber+"/Answer");

        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                mAnswer = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mQuestionNumber++;

        if (mQuestionNumber > 6)
        {
            Toast.makeText(getActivity(), "Quiz Ended", Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("key",String.valueOf(result));

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
