package com.pta.flowers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class view_holder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView name, description, price;

    public view_holder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.flower_name);
        description = itemView.findViewById(R.id.flower_description);
        price = itemView.findViewById(R.id.flower_price);

    }

    public void bindflower(flowers flowers) {
        image.setImageResource(flowers.getImage());
        name.setText(flowers.getName());
        description.setText(flowers.getDescription());
        price.setText(flowers.getPrice());

    }
}
