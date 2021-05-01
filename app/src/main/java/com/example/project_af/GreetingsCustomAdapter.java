package com.example.project_af;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GreetingsCustomAdapter extends ArrayAdapter<DaysDataModel> {


    private ArrayList<DaysDataModel> dataSet;
    Context mContext;

    public GreetingsCustomAdapter(ArrayList<DaysDataModel> data, Context context) {
        super(context, R.layout.template_greetings, data);
        this.dataSet = data;
        this.mContext=context;

    }
    private static class ViewHolder {
        TextView greetingsF,greeetingsE,greetingsP;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        DaysDataModel dataModel = getItem(position);
        GreetingsCustomAdapter.ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.template_greetings, parent, false);
            viewHolder.greeetingsE = (TextView) convertView.findViewById(R.id.greetingsEnglish);
            viewHolder.greetingsF = (TextView) convertView.findViewById(R.id.greetingsFrench);
            viewHolder.greetingsP = (TextView) convertView.findViewById(R.id.greetingsPronounce);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (GreetingsCustomAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.greeetingsE.setText(dataModel.getEnglish());
        viewHolder.greetingsF.setText(dataModel.getFrench());
        viewHolder.greetingsP.setText(dataModel.getPronounce());


        return convertView;
    }

}
