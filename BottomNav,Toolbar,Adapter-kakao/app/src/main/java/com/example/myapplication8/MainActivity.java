package com.example.myapplication8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import info.androidhive.fontawesome.FontDrawable;

public class MainActivity extends AppCompatActivity {
//    private ImageView ivHeart;
private static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;
    public Integer num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.bottom_user:
                    selectedFragment = new UserFragment();
                    break;
                case R.id.bottom_chat:
                    selectedFragment = new ChatFragment();
                break;
                case R.id.bottom_settings:
                    selectedFragment = new SettingFragment();
                    break;
                case R.id.bottom_navigation:
                    selectedFragment = new NavigationFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return  true;
        });

    }
}