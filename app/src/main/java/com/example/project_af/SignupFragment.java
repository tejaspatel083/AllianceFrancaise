package com.example.project_af;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class SignupFragment extends Fragment {

    private Button btnSignup;
    private TextView txtLogin;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private ImageView dpimage;
    private static int PICK_IMAGE = 123;
    private Uri imagePath;

    private EditText user_pwd1,user_pwd2,user_name,user_email;
    private TextView v1,v2,iv1,iv2;

    //private OnFragmentInteractionListener mListener;

    public SignupFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Signup");
        btnSignup = view.findViewById(R.id.CreateBtn);
        txtLogin = view.findViewById(R.id.LoginText);
        dpimage = view.findViewById(R.id.DpImage);

        user_email = view.findViewById(R.id.CreateEmail);
        user_name = view.findViewById(R.id.CreateName);
        user_pwd1 = view.findViewById(R.id.CreatePassword);
        user_pwd2 = view.findViewById(R.id.CreateRePassword);

        v1 = view.findViewById(R.id.visible1);
        iv1 = view.findViewById(R.id.notvisible1);
        v2 = view.findViewById(R.id.visible2);
        iv2 = view.findViewById(R.id.notvisible2);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();

        db = FirebaseFirestore.getInstance();


        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_pwd1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                v1.setVisibility(View.INVISIBLE);
                iv1.setVisibility(View.VISIBLE);
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_pwd1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                iv1.setVisibility(View.INVISIBLE);
                v1.setVisibility(View.VISIBLE);
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_pwd2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                v2.setVisibility(View.INVISIBLE);
                iv2.setVisibility(View.VISIBLE);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_pwd2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                iv2.setVisibility(View.INVISIBLE);
                v2.setVisibility(View.VISIBLE);
            }
        });

        View.OnClickListener navigate1 = Navigation.createNavigateOnClickListener(R.id.action_signupFragment_to_loginFragment2);



        dpimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Choose Image"),PICK_IMAGE);
            }
        });

        txtLogin.setOnClickListener(navigate1);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user_name.getText().toString().trim().length()==0 || user_email.getText().toString().trim().length()==0 || user_pwd1.getText().toString().trim().length()==0 || user_pwd2.getText().toString().trim().length()==0)
                {
                    Toast toast = Toast.makeText(getActivity(),"Enter All Details",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                else if (user_pwd1.getText().toString().trim().equals(user_pwd2.getText().toString().trim()))
                {
                    String name = user_name.getText().toString().trim();
                    String email=user_email.getText().toString().trim();
                    String password = user_pwd1.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                sendEmailVerification();

                            }

                            else
                            {

                                if (task.getException() instanceof FirebaseAuthUserCollisionException) {

                                    Toast toast = Toast.makeText(getActivity(),"User with this email already exist.",Toast.LENGTH_LONG);
                                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                                    toast.show();
                                }
                                else
                                {
                                    Toast toast = Toast.makeText(getActivity(),"Check Internet Connection",Toast.LENGTH_LONG);
                                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                                    toast.show();
                                }

                            }
                        }
                    });



                }
                else
                {
                    Toast toast = Toast.makeText(getActivity(),"Password not matched",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }

            }
        });
    }

    private void sendEmailVerification() {

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser != null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {

                        sendData();

                    }

                    else
                    {
                        Toast toast = Toast.makeText(getActivity(),"Verification mail has not been sent",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();
                    }
                }
            });

        }


    }

    private void sendData()
    {


        StorageReference ref = storageReference.child("User Profile Images").child(firebaseAuth.getUid());

        ref.putFile(imagePath)
                .addOnSuccessListener(
                        new OnSuccessListener<UploadTask.TaskSnapshot>() {

                            @Override
                            public void onSuccess(
                                    UploadTask.TaskSnapshot taskSnapshot)
                            {

                            }
                        })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {

                        Toast toast = Toast.makeText(getActivity(),"Upload Failed",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                    }
                });


        String name = user_name.getText().toString().trim();
        String email = user_email.getText().toString().trim();

        UserInfo obj1 = new UserInfo(name,email);

        db.collection("User Profile Information")
                .document(firebaseAuth.getUid())
                .set(obj1)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful())
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"Registration Successful!",Toast.LENGTH_LONG).show();
                            FirebaseAuth.getInstance().signOut();
                            getActivity().finish();
                            startActivity(new Intent(getActivity(),MainActivity.class));


                        }else
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"FireStore Error!",Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getActivity(), "Something Wrong", Toast.LENGTH_SHORT).show();
                    }
                });



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null)
        {

            imagePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),imagePath);
                dpimage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}
