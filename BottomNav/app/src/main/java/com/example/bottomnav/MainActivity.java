package com.example.bottomnav;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bottomnav.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView bottomNavView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bottomNavView = findViewById(R.id.bottom_nav);//val BottomNavview: bottmNavView = findviewbyId(R.id....)//val bottmNavView = findviewbyId<BottomNavView>(R.id....)
        //val frameMain = findViewByID<FrameLayout>(R.id.frame_main);
        //xử lý sk
        bottomNavView.setOnItemSelectedListener(
                R.id.menu_item_running -> {
                    Toast.makeText(this, "running", Toast.LENGTH_SHORT).show();
                    loadFragment((RunningFragment));
                    true
        }
        R.id.menu_item_cycling -> {

            Toast.makeText(this, "cycling", Toast.LENGTH_SHORT).show();
            true
        }
        );
    }
    private fun loadFragment(fragment: Fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,fragment).commit()

    }
}