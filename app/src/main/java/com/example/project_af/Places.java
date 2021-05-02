package com.example.project_af;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Places extends Fragment {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    private ProgressDialog progressDialog;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_places,container,false);
        getActivity().setTitle("Places");


        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Moderate").child("Places");

        recyclerView = view.findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<ImageTextDataModel,ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ImageTextDataModel, ViewHolder>(ImageTextDataModel.class,R.layout.template_image,ViewHolder.class,reference) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, ImageTextDataModel imageTextDataModel, int i) {

                        viewHolder.setDetails(getContext(),imageTextDataModel.getEnglish(),imageTextDataModel.getFrench(),imageTextDataModel.getImage());

                        progressDialog.dismiss();

                    }
                };

        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
}
