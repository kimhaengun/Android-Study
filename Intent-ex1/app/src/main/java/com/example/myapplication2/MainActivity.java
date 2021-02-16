package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private Context mContext = MainActivity.this;
    private FloatingActionButton fabRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml에 있는 그림이 메모리에 올라오는 과정 = 인플레이트

        fabRoute=findViewById(R.id.fab_route);
        fabRoute.setOnClickListener(v -> {
            //intent에 넣을 수 있는값
            //1.현재 내화면, 이동할 화면
            //2.현재 내화면, 내부앱의 이동할 화면.
//            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01022227777"));
            //intent = 트럭과 같다 (현재 내위치, 이동할 위치정보, 이동할 때 가져갈 박스(정보))
            //다른 앱으로 이동 = 트럭(상대방 앱의 키, 데이터)
            Intent intent = new Intent(mContext, SubActivity.class);
            startActivity(intent);
        });

    }

}