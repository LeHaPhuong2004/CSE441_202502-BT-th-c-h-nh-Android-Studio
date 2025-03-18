package com.example.tlucontact;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DonviViewHolder extends RecyclerView.ViewHolder {

    private ImageView AvatarDonvi;
    private TextView tenDonvi,  SDTDV, emailDV;
    public DonviViewHolder(@NonNull View itemView) {
        super(itemView);
        AvatarDonvi = itemView.findViewById(R.id.imv_donvi);
        tenDonvi = itemView.findViewById(R.id.txt_tendv);
        SDTDV = itemView.findViewById(R.id.txt_sdt);
        emailDV = itemView.findViewById(R.id.txt_emaildonvi);
    }

    public void bindDonvi(Donvi tendv){

        AvatarDonvi.setImageResource(tendv.getAvatarDV());
        SDTDV.setText(tendv.getSdtDV());
        tenDonvi.setText(tendv.getTenDV());
        emailDV.setText(tendv.getEmailDV());
    }
}
