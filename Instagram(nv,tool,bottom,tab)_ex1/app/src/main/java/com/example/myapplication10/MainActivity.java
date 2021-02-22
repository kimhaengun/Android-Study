package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Person;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    //1.바텀 네비게이션 클릭
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbarMain;
    private ImageView ivMenu;
    private DrawerLayout drawer;
    private NavigationView nv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.바텀 네비게이션 구성
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        //최초 실행시 fragment_container에 PersonFragment를 띄움
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PersonFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.bottom_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.bottom_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.bottom_display:
                    selectedFragment = new DisplayFragment();
                    break;
                case R.id.bottom_favorite:
                    selectedFragment = new FavoriteFragment();
                    break;
                case R.id.bottom_person:
                    selectedFragment = new PersonFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        });

        //3.네비게이션 바
        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        //Menu 버튼 클릭 시 이벤트
        drawer = findViewById(R.id.drawer);
        ivMenu = findViewById(R.id.iv_menu);

        //Menu 버튼 클릭 하면
        ivMenu.setOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START);
        });

//        //네비게이션 바 (메뉴1~3)클릭 하면
//        nv = findViewById(R.id.nv);
//        NavigationViewHelper.enable(MainActivity.this,nv);



    }

}