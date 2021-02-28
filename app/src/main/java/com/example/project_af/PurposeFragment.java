package com.example.project_af;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
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
import androidx.fragment.app.FragmentTransaction;

public class PurposeFragment extends Fragment {


    private RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_purpose,container,false);
        getActivity().setTitle("Purpose of Learning");



        radioGroup = view.findViewById(R.id.group1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


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

                LevelsFragment fragment = new LevelsFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,new LevelsFragment()).commit();

            }
        });

        return view;
    }
}
