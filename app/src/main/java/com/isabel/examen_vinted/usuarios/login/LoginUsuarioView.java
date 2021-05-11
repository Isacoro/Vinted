package com.isabel.examen_vinted.usuarios.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isabel.examen_vinted.MainActivity;
import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.productos.listaProductos.ListaProductosFragment;
import com.isabel.examen_vinted.usuarios.registro.RegistroUsuarioView;


public class LoginUsuarioView extends AppCompatActivity implements LoginUsuarioContract.View {


    private EditText email;
    private EditText password;
    private Button login, registro;
    private LoginUsuarioPresenter loginUsuarioPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario_view);

        initComponents();

        loginUsuarioPresenter = new LoginUsuarioPresenter(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsuarioPresenter.getUsuarioLogin(getBaseContext(),
                        email.getText().toString(),
                        password.getText().toString());
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navegar = new Intent(getBaseContext(), RegistroUsuarioView.class);
                startActivity(navegar);

            }
        });
    }

    private void initComponents(){
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);
        login = findViewById(R.id.btLogin);
        registro = findViewById(R.id.btRegistro);
    }


    @Override
    public void successLogin(@NonNull Usuario usuario) {
        Intent navegar = new Intent(getBaseContext(), MainActivity.class);
        startActivity(navegar);

        Toast.makeText(this, "Bienvenido ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(String message) {
        System.out.println(message);

    }
}

