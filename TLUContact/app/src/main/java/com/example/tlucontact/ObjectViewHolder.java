package com.example.tlucontact;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ObjectViewHolder extends RecyclerView.ViewHolder {

    private ImageView AvatarCbnv;

    private TextView tenCbnv,  SDTcbnv, emailCbnv;

    public ObjectViewHolder(@NonNull View itemView) {
        super(itemView);

        AvatarCbnv = itemView.findViewById(R.id.imv_cbnv);
        tenCbnv = itemView.findViewById(R.id.txt_name);
        SDTcbnv = itemView.findViewById(R.id.txt_phone);
        emailCbnv = itemView.findViewById(R.id.txt_email);




    }

    public void bindCbnv(CBNV tencbnv){
        AvatarCbnv.setImageResource(tencbnv.getAvatarcb());
        SDTcbnv.setText(tencbnv.getSdt());
        tenCbnv.setText(tencbnv.getName());
        emailCbnv.setText(tencbnv.getEmail());
    }



}
