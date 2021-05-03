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

public class SentencesCustomAdapter extends ArrayAdapter<DaysDataModel> {

    private ArrayList<DaysDataModel> dataSet;
    Context mContext;

    public SentencesCustomAdapter(ArrayList<DaysDataModel> data, Context context) {
        super(context, R.layout.template_sentences, data);
        this.dataSet = data;
        this.mContext=context;

    }
    private static class ViewHolder {
        TextView sentencesF,sentencesE;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        DaysDataModel dataModel = getItem(position);
        SentencesCustomAdapter.ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.template_sentences, parent, false);
            viewHolder.sentencesE = (TextView) convertView.findViewById(R.id.sentencesEnglish);
            viewHolder.sentencesF = (TextView) convertView.findViewById(R.id.sentencesFrench);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (SentencesCustomAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.sentencesE.setText(dataModel.getEnglish());
        viewHolder.sentencesF.setText(dataModel.getFrench());

        return convertView;
    }
}
