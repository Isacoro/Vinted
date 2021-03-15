package com.isabel.examen_vinted.usuarios.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.productos.listaProductos.ListaProductosView;


public class LoginUsuarioView extends AppCompatActivity implements LoginUsuarioContract.View {

    private EditText nombre, password;
    private Button login;
    private LoginUsuarioPresenter loginUsuarioPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario_view);
        loginUsuarioPresenter = new LoginUsuarioPresenter(this);

        initComponents();

        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();

                usuario.setNombre(nombre.getText().toString());
                usuario.setPassword(password.getText().toString());

                loginUsuarioPresenter.getUsuario(usuario);
            }
        });
    }

    private void initComponents(){
        nombre = findViewById(R.id.etNombre);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btLogin);
    }


    @Override
    public void successLogin(Usuario usuario) {
        Intent navegar = new Intent(getBaseContext(), ListaProductosView.class);
        startActivity(navegar);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }
}

