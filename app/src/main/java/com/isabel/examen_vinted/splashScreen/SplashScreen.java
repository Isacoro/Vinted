package com.isabel.examen_vinted.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.isabel.examen_vinted.MainActivity;
import com.isabel.examen_vinted.R;

public class SplashScreen extends AppCompatActivity {
//    private static final int SCREEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(() ->{
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        },3000);
    }
}