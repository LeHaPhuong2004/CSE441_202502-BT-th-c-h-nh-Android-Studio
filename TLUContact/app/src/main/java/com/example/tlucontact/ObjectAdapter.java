package com.example.tlucontact;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ObjectAdapter extends RecyclerView.Adapter<ObjectViewHolder>{

    private CBNV[] cbnv;


    public ObjectAdapter(CBNV[] cbnv) { //nhan student ảo
        this.cbnv = cbnv;
    }


    @NonNull
    @Override
    public ObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vcbnv = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cbnv,parent,false);

        return new ObjectViewHolder(vcbnv);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectViewHolder holder, int position) {
        holder.bindCbnv(cbnv[position]); //người dùng cuộn hiển thị sv tương ứng

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("ten ", cbnv[position].getName());
            intent.putExtra("sdt", cbnv[position].getSdt());
            intent.putExtra("email", cbnv[position].getEmail());
            intent.putExtra("don_vi_ct", cbnv[position].getDvct());
            intent.putExtra("avatar", cbnv[position].getAvatarcb());
            intent.putExtra("chuc_vu", cbnv[position].getChucvu());
            intent.putExtra("hoc_vi", cbnv[position].getHocvi());
            intent.putExtra("bo_mon", cbnv[position].getBomon());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return cbnv.length; //string vua định nghĩa

    }
}
