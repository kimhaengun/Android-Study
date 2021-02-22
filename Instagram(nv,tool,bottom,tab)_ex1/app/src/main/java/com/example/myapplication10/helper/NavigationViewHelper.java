//package com.example.myapplication10.helper;
//
//import android.content.Context;
//import android.util.Log;
//
//import com.example.myapplication.R;
//import com.google.android.material.navigation.NavigationView;
//
//public class NavigationViewHelper {
//
//    private static final String TAG = "NavigationViewHelper";
//    public static void enable(Context context, NavigationView view){
//        view.setNavigationItemSelectedListener(item -> {
//            int id = item.getItemId();
//
//            if(id == R.id.item1){
//                Log.d(TAG, "enable: 메뉴1 번클릭 됨");
//            }else if(id == R.id.item2){
//                Log.d(TAG, "enable: 메뉴2 번클릭 됨");
//            }else  if(id == R.id.item3){
//                Log.d(TAG, "enable: 메뉴3 클릭됨");
//            }
//            return false;
//        });
//    }
//}
