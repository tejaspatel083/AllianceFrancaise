package com.example.project_af;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class PurposeFragment extends Fragment {


    private RadioGroup radioGroup;
    private NavController navController;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_purpose,container,false);
        getActivity().setTitle("Purpose of Learning");

        View.OnClickListener navigate1 = Navigation.createNavigateOnClickListener(R.id.action_purposeFragment_to_levelsFragment);

        navController = Navigation.findNavController(getActivity(),R.id.Host_Fragment2);


        radioGroup = view.findViewById(R.id.group1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                /*
                if (checkedId==R.id.rb1)
                {
                    Toast.makeText(getActivity(), "Travel", Toast.LENGTH_SHORT).show();

                }
                else if (checkedId==R.id.rb2)
                {
                    Toast.makeText(getActivity(), "School", Toast.LENGTH_SHORT).show();

                }
                else if (checkedId==R.id.rb3)
                {
                    Toast.makeText(getActivity(), "Job", Toast.LENGTH_SHORT).show();

                }
                else if (checkedId==R.id.rb4)
                {
                    Toast.makeText(getActivity(), "Culture", Toast.LENGTH_SHORT).show();

                }
                else if (checkedId==R.id.rb5)
                {
                    Toast.makeText(getActivity(), "Family and Friends", Toast.LENGTH_SHORT).show();

                }
                else if (checkedId==R.id.rb6)
                {
                    Toast.makeText(getActivity(), "Brain Training", Toast.LENGTH_SHORT).show();

                }
                else if (checkedId==R.id.rb7)
                {
                    Toast.makeText(getActivity(), "Other", Toast.LENGTH_SHORT).show();

                }
                
                 */

                navController.navigate(R.id.levelsFragment);
            }
        });




        return view;
    }


}
