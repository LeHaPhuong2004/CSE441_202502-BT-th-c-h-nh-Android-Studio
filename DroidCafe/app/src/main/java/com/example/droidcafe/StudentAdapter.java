package com.example.droidcafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private Student[] students;

    public StudentAdapter(Student[] students) { //nhan student ảo
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//vẽ ra giao diện
        //tiemlayout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student,parent,false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bind(students[position]); //người dùng cuộn hiển thị sv tương ứng

    }

    @Override
    public int getItemCount() {
        return students.length; //string vua định nghĩa
    }
}
