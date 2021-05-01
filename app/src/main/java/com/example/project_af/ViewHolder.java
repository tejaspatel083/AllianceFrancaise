package com.example.project_af;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {


    View view;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;
    }


    public void setDetails(Context context,String English,String French, String Image)
    {
        TextView txtEng = view.findViewById(R.id.templateEnglish);
        TextView txtFre = view.findViewById(R.id.templateFrench);
        ImageView img = view.findViewById(R.id.templateImage);


        txtEng.setText(English);
        txtFre.setText(French);
        Picasso.get().load(Image).into(img);
    }
}
