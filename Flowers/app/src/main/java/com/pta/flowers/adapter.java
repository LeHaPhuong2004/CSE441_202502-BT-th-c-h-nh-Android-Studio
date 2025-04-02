package com.pta.flowers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<view_holder> {
    private flowers[] flowers;
    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View flowers = LayoutInflater.from(parent.getContext()).inflate(R.layout.flowerslist, parent, false);
        return new view_holder(flowers);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
        holder.bindflower(flowers[position]); // Gọi phương thức bindflower để hiển thị dữ liệu
    }

    @Override
    public int getItemCount() {
        return flowers.length;
    }

    public void flowersAdapter(flowers[] flowers) {
        this.flowers = flowers;
    }

}
