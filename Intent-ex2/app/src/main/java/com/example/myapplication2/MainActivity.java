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
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Context mContext = MainActivity.this;
    private FloatingActionButton fabRoute;
    private static final String TAG = "MainActivity";
    private ConstraintLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml에 있는 그림이 메모리에 올라오는 과정 = 인플레이트

        mainLayout = findViewById(R.id.main_layout);


        fabRoute=findViewById(R.id.fab_route);
        fabRoute.setOnClickListener(v -> {
            //intent에 넣을 수 있는값
            //1.현재 내화면, 이동할 화면
            //2.현재 내화면, 내부앱의 이동할 화면.
//            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01022227777"));
            //intent = 트럭과 같다 (현재 내위치, 이동할 위치정보, 이동할 때 가져갈 박스(정보))
            //다른 앱으로 이동 = 트럭(상대방 앱의 키, 데이터)

            User user = new User();
            user.setId(1);
            user.setUsername("cos");
            user.setPassword("1234");



//            Bundle bundle = new Bundle();
////            bundle.putInt("id",user.getId());
////            bundle.putString("username",user.getUsername());
////            bundle.putString("password",user.getPassword());
//            bundle.putSerializable("user",user);


            Intent intent = new Intent(mContext, SubActivity.class);
            intent.putExtra("username","ssar");
            startActivity(intent);


            //gson으로 json변환 putExtra로 넘기고 다시 gson으로 자바 오브젝트 변환
            //serializable
            //Bundle(택배박스)
//            Intent intent = new Intent(mContext, SubActivity.class);
//            intent.putExtra("username","ssar");
//            startActivity(intent);

            startActivityForResult(intent,300);
        });

    }
    
    //finish()될 때 콜백되는 함수
    //서브 액티비티의 setResult() 함수의 파라메터가 전달된다. = @Nullable Intent data
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: 실행됨.");
        Log.d(TAG, "requestCode: "+requestCode);
        Log.d(TAG, "resultCode: "+resultCode);


        //Window 가 무엇인지? AlertDialog 사용!!

        if (requestCode==300){ //서브 엑티비티에서 돌아왔다.
            if(resultCode==1){//로직 성공
//                Toast.makeText(mContext, "인증 성공함:"+data.getStringExtra("auth"), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout,"인증성공함", BaseTransientBottomBar.LENGTH_LONG).show();
            }else{ //로직이 실패함
                Toast.makeText(mContext, "인증 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }
}