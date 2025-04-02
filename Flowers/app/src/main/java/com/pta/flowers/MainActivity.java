package com.pta.flowers;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvflowers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        flowers[] flowers = {
                new flowers(R.drawable.xau,"rose","dfsafas", 200 ),
                new flowers(R.drawable.xau,"sunflower","afsfas", 200),
        };
        rcvflowers = findViewById(R.id.recycleview);
        rcvflowers.setLayoutManager(new LinearLayoutManager(this));
        adapter flowerAdapter = new adapter();
        flowerAdapter.flowersAdapter(flowers); // Truyền dữ liệu vào adapter
        rcvflowers.setAdapter(flowerAdapter); // Gắn adapter vào RecyclerView
    }
}