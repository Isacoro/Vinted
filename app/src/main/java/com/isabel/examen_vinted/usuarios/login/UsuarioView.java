package com.isabel.examen_vinted.usuarios.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.isabel.examen_vinted.MainActivity;
import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.productos.anadirProducto.AnadirProductoView;

public class UsuarioView extends AppCompatActivity {

    private FloatingActionButton btHome, btAnadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_view);

        initComponents();

        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioView.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioView.this, AnadirProductoView.class);
                startActivity(intent);
            }
        });

    }

    public void initComponents(){
        btHome = findViewById(R.id.activity_usuario_home);
        btAnadir = findViewById(R.id.activity_usuario_anadir);

    }
}