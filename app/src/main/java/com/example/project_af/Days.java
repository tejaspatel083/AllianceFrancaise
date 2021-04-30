package com.example.project_af;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.motion.widget.MotionScene.TAG;


public class Days extends Fragment {

    ArrayList<DaysDataModel> dataModels;
    ListView listView;
    private static DaysCustomAdapter adapter;
    FirebaseFirestore fireStore;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_days,container,false);
        getActivity().setTitle("Days");


        listView=view.findViewById(R.id.daysList);

        fireStore = FirebaseFirestore.getInstance();

        dataModels= new ArrayList<>();

        readData();

        return view;
    }

    private void readData() {

        fireStore.collection("Learning").document("Beginner")
                .collection("Days").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {


                if (task.isSuccessful()) {

                    for (QueryDocumentSnapshot document : task.getResult()) {
                        //listView.add(document.getId());
                        DaysDataModel daysDataModel= document.toObject(DaysDataModel.class);
                        dataModels.add(daysDataModel);
                        adapter= new DaysCustomAdapter(dataModels,getContext());

                        listView.setAdapter(adapter);

                    }
                    //Log.d(TAG, list.toString());
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }

            }
        });
    }


}
