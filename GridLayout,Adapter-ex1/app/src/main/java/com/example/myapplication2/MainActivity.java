package com.example.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    private GridView gvMovie;
    List<Movie> movies;
    MovieAdapter adapter;


    // 1번 실행
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        adapter = new MovieAdapter(movies);
        gvMovie.setAdapter(adapter);
    }

    // 2번 실행
    @Override
    protected void onStart() {
        super.onStart();
    }

    // 3번 실행
    @Override
    protected void onResume() {
        super.onResume();
    } // 액티비티에 그림 그려짐

    private void init(){
        gvMovie = findViewById(R.id.gv_movie);
        movies = new ArrayList<>();
        download();
    }

    private void download(){
        // 스레드로 돌아야함. 2초 걸림
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                movies.add(new Movie(1, "제목", R.drawable.mov01));
                movies.add(new Movie(2, "제목", R.drawable.mov02));
                movies.add(new Movie(3, "제목", R.drawable.mov03));
                movies.add(new Movie(4, "제목", R.drawable.mov04));
                movies.add(new Movie(5, "제목", R.drawable.mov05));
                movies.add(new Movie(6, "제목", R.drawable.mov06));
                movies.add(new Movie(7, "제목", R.drawable.mov07));
                movies.add(new Movie(8, "제목", R.drawable.mov08));
                movies.add(new Movie(9, "제목", R.drawable.mov09));
                movies.add(new Movie(10, "제목", R.drawable.mov10));
                movies.add(new Movie(11, "제목", R.drawable.mov11));
                movies.add(new Movie(12, "제목", R.drawable.mov12));
                // main스레드=ui스레드가 adapter.notifyDataSetChanged();를 실행시키게 하면 됨.

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();



    }




//        2
//        lvMovie=findViewById(R.id.lv_movie);
//
//        List<Movie> movies = new ArrayList<>();
//
//        for (int i=0; i<13; i++){
//            movies.add(new Movie(i,"제목",i));
//        }
//        ItemAdapter adapter = new ItemAdapter(movies);
//
//        lvMovie.setAdapter(adapter);



//        //어댑터=>내장 어댑터 - 간단한 디자인의 리스트
//        //커스텀 리스트를 만들때는 어댑터를 직접만들어야 한다.
//        List<String> mid = new ArrayList<>();
//        mid.add("가쉽걸");
//        mid.add("덱스터");
//        mid.add("왕자의게임");
//        mid.add("브레이킹배드");
//        mid.add("배터콜사울");
//
//        //어댑터는 화면 사이즈, 리스트 하나의 아이템 사이즈를 알아야하고  다음에 데이터 컬렉션을 알아야 한다.
//        //(화면사이즈, 리스트 하나의 아이템 사이즈, 데이터 컬렉션)
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, mid);
//        lvMovie.setAdapter(adapter);
//
//        mid.add("");

}