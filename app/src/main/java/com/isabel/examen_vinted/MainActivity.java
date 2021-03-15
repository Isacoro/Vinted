package com.isabel.examen_vinted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.isabel.examen_vinted.usuarios.login.LoginUsuarioView;

public class MainActivity extends AppCompatActivity {
    private static final int SCREEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent navegar = new Intent(
                                getBaseContext(), LoginUsuarioView.class);
                        startActivity(navegar);
                    }
                }
                ,3000
        );
    }
}