package com.example.project_af;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment {

    private TextView name,email;
    private Button button;
    private EditText edit_name;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;
    private ImageView dp;
    private FirebaseUser currentUser;
    private FirebaseStorage firebaseStorage;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_profile,container,false);
        getActivity().setTitle("Profile");

        dp = view.findViewById(R.id.ProfileImage);
        button = view.findViewById(R.id.ProfileUpdateButton);
        name = view.findViewById(R.id.ProfileName);
        email = view.findViewById(R.id.ProfileEmail);
        db = FirebaseFirestore.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseStorage = FirebaseStorage.getInstance();


        StorageReference storageReference = firebaseStorage.getReference();
        storageReference.child("User Profile Images")
                .child(firebaseAuth.getUid())
                .getDownloadUrl()
                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {

                        Picasso.get().load(uri).into(dp);

                    }
                });

        getData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateData();
            }
        });

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

    private void updateData() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_dialog,null);

        edit_name = view.findViewById(R.id.updateName);

        builder.setView(view).setTitle("Update Profile");

        builder.setView(view).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });



        builder.setView(view).setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String name = edit_name.getText().toString().trim();

                UserInfo userInfo = new UserInfo(name);


                db.collection("User Profile Information")
                        .document(firebaseAuth.getUid())
                        .update("name",name)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {


                                getActivity().recreate();

                                Toast toast = Toast.makeText(getActivity(),"Profile Updated",Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                                toast.show();


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast toast = Toast.makeText(getActivity(),"Error : "+e.getMessage(),Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                                toast.show();
                            }
                        });





            }
        });

        builder.show();


    }

}
