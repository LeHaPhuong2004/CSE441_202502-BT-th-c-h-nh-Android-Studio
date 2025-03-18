package com.example.droidcafe;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    public StudentViewHolder(@NonNull View itemView) {

        super(itemView);
        imvAvatar = itemView.findViewById(R.id.imv_student_ava);
        txtName = itemView.findViewById(R.id.txt_student_name);
        txtSid = itemView.findViewById(R.id.txt_student_id);

    }

    public void bind(Student sid){
        imvAvatar.setImageResource(sid.getAvatar());
        txtName.setText(sid.getFullname());
        txtSid.setText(sid.getSid());
    }

    private ImageView imvAvatar;
    private TextView txtSid, txtName;

}
