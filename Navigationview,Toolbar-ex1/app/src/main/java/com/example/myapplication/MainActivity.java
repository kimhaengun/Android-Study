package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbarMain;
    private ImageView ivPerson,ivMenu;
    private DrawerLayout drawer;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        ivPerson= findViewById(R.id.iv_person);
        ivPerson.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,PersonActivity.class);
            startActivity(intent);
        });

        //Menu버튼 클릭시 이벤트
        drawer = findViewById(R.id.drawer);
        ivMenu = findViewById(R.id.iv_menu);

        ivMenu.setOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START);
        });

        //네이게이션 바 이벤트
        nv = findViewById(R.id.nv);
        NavigationViewHelper.enable(MainActivity.this,nv);
    }
}