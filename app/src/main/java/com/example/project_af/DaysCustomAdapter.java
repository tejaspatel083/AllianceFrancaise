package com.example.project_af;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DaysCustomAdapter extends ArrayAdapter<DaysDataModel> {

    private ArrayList<DaysDataModel> dataSet;
    Context mContext;

    public DaysCustomAdapter(ArrayList<DaysDataModel> data, Context context) {
        super(context, R.layout.template_days, data);
        this.dataSet = data;
        this.mContext=context;

    }
    private static class ViewHolder {
        TextView daysF,daysE;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        DaysDataModel dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.template_days, parent, false);
            viewHolder.daysE = (TextView) convertView.findViewById(R.id.daysEnglish);
            viewHolder.daysF = (TextView) convertView.findViewById(R.id.daysFrench);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.daysE.setText(dataModel.getEnglish());
        viewHolder.daysF.setText(dataModel.getFrench());

        return convertView;
    }
}
