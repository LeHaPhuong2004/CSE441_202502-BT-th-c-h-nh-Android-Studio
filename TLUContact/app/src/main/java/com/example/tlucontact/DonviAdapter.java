package com.example.tlucontact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DonviAdapter extends RecyclerView.Adapter<DonviViewHolder>{

    private Donvi[] donvi;

    public DonviAdapter(Donvi[] donvi) { //nhan student ảo
        this.donvi = donvi;
    }

    @NonNull
    @Override
    public DonviViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vdonvi = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_donvi,parent,false);
        return new DonviViewHolder(vdonvi);
    }

    @Override
    public void onBindViewHolder(@NonNull DonviViewHolder holder, int position) {
        holder.bindDonvi(donvi[position]); //người dùng cuộn hiển thị sv tương ứng
    }

    @Override
    public int getItemCount() {
        return donvi.length; //string vua định nghĩa
    }
}
