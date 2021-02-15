package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//메인쓰레드= onCreate() = UI쓰레드
//                      = 이벤트 스레드[          ]확인  ==> UI스레드(이벤트 스레드(무한루프 [A버튼, B버튼]))
//                      = 이벤트 리스너(OS가 관리)[A 버튼]
//A버튼 클릭 시 안드로이드 OS가 감지해서 이벤트 스레드[A 버튼]에 넘겨줌.
//이벤트 스택에는 최소한의 코드를 작성해야한다. 길게작성하면 다음 이벤트를 처리할 수 없기 때문에...
//방벙 = 새로운 스레드를 생성해서 따로 돌려준다. --> 단점 함수에서 새로 생성된 스레드의 결과(리턴) 값을 받아오기 힘들다

//public class MainActivity extends AppCompatActivity {
//    private static final String TAG = "MainActivity2";
//    private TextView tvTitle;



    //매니페스트에서 설정된 자바 파일이 실행될 때 가장 먼저 실행되는 함수 = onCreate()
    //onCreate()가 실행되면 존재하는 쓰레드는 2종류이다 why? 메인쓰레드, 이벤트 쓰레드가 동작되기 때문에
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        // 그림 그리는 함수 = 페인팅 -->무엇을 = activity_main =>자바 코드
//
////        try {
////            Thread.sleep(5000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        //확인 결과 = Hello를 그리고 Hi를 그리는것이아니라 메모리에 띄워놓고 나중에 Hi만 그린다.
////
////        tvTitle = findViewById(R.id.tv_title); //id로 등록하면 R.id에 저장된다.
////        tvTitle.setText("Hi");
//
//        Log.d(TAG, "onCreate: ");
//    }
    //onCreate이 종료되어도 화면이 떠있는 이유 = 이벤트를 받기위해 무한대로 돌고 있는 다른 쓰레드가 존재 하기 때문에
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d(TAG, "onStart: ");
//    }
//
//    //앱이 잠시 멈출때..
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d(TAG, "onStop: ");
//    }
//
//    //화면 그림그려지기 직전에 --> 데이터 다운로드
//    @Override
//    protected void onResume() {
//        super.onResume();
//        SharedPreferences sp = getSharedPreferences("movie",MODE_PRIVATE);
//        String title = sp.getString("title","없음");
//        Log.d(TAG, "onResume: "+title);
//    }    //onResume() 종료되면 그림이 그려진다.
//
//    //앱 종료시
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d(TAG, "onDestroy: ");
//
//        //1.파일 / 파일에는 그림이나 카메라로 찍은 사진 저장
//        //2.내부 DB = (SQL Lite) / 내부 DB에는 주소록,메모장, 달력 저장
//        //<통신할 때>
//        //3.외부 서버 = 외부 DB / ex) 인스타그램에 업로드할 사진..
//        //4.메모리 엑세스 저장소 (제일 많이 씀) = 앱마다 달려있음 = 실제로 한개(키로 구분)로 관리 = Shared Preference
//        SharedPreferences sp = getSharedPreferences("movie",MODE_PRIVATE); //이미 만들어져 있기때문에 get
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("title","바람과 함께 사라지다.");
//        editor.commit();
//    }
    public class MainActivity extends AppCompatActivity {
        private static final String TAG = "MainActivity2";
        private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
    }
}