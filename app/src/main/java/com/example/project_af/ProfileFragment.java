package com.example.project_af;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileFragment extends Fragment {

    private TextView name,email;
    private Button button;
    private EditText edit_name;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;
    private FirebaseUser currentUser;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_profile,container,false);
        getActivity().setTitle("Profile");

        button = view.findViewById(R.id.ProfileUpdateButton);
        name = view.findViewById(R.id.ProfileName);
        email = view.findViewById(R.id.ProfileEmail);
        db = FirebaseFirestore.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();


        getData();

        return view;
    }

    private void getData() {


        currentUser = firebaseAuth.getCurrentUser();

        DocumentReference docRef = db.collection("User Profile Information").document(currentUser.getUid());

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if (documentSnapshot.exists())
                {
                    String resultEmail = documentSnapshot.getString("email");
                    String resultName = documentSnapshot.getString("name");

                    email.setText(resultEmail);
                    name.setText(resultName);
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(getActivity(), "Something Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
