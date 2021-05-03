package com.example.project_af;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import static androidx.constraintlayout.motion.widget.MotionScene.TAG;


public class Sentences extends Fragment {

    ArrayList<DaysDataModel> dataModels;
    ListView listView;
    private static SentencesCustomAdapter adapter;
    FirebaseFirestore fireStore;
    private ProgressDialog progressDialog;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_sentences,container,false);
        getActivity().setTitle("Sentences");


        progressDialog = new ProgressDialog(getContext());

        listView=view.findViewById(R.id.sentencesList);

        fireStore = FirebaseFirestore.getInstance();

        dataModels= new ArrayList<>();

        readData();

        return view;

    }



    private void readData() {

        progressDialog.setMessage("Loading...");
        progressDialog.show();

        fireStore.collection("Learning").document("Difficult")
                .collection("Sentences").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {



                if (task.isSuccessful()) {

                    for (QueryDocumentSnapshot document : task.getResult()) {
                        //listView.add(document.getId());
                        DaysDataModel daysDataModel= document.toObject(DaysDataModel.class);
                        dataModels.add(daysDataModel);
                        adapter= new SentencesCustomAdapter(dataModels,getContext());

                        listView.setAdapter(adapter);


                    }

                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }

                progressDialog.dismiss();
            }
        });
    }


}
