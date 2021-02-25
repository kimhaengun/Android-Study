package com.cos.fireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    private Button btnLogout;
    private FirebaseAuth mAuth;
    private TextView tvUserEmail,tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        Log.d(TAG, "onCreate: 로그인 사용자"+user.getEmail());

        btnLogout = findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(v -> {
            mAuth.signOut(); //세션 없애기(로그아웃 시키기)

            startActivity(new Intent(HomeActivity.this,LoginActivity.class));
        });

        tvUserEmail=findViewById(R.id.tv_useremail);
        tvPassword=findViewById(R.id.tv_password);
//
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url

            String email = user.getEmail();
//            String name = user.get

            tvUserEmail.setText(email);
            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }
    }
}