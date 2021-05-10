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
import com.isabel.examen_vinted.productos.listaProductos.ListaProductosFragment;
import com.isabel.examen_vinted.usuarios.registro.RegistroUsuarioView;


public class LoginUsuarioView extends AppCompatActivity implements LoginUsuarioContract.View {

    private EditText email, password;
    private Button login, registro;
    private LoginUsuarioPresenter loginUsuarioPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario_view);

        loginUsuarioPresenter = new LoginUsuarioPresenter(this);

        initComponents();

        login.setOnClickListener(v -> {
            Usuario usuario = new Usuario();

            usuario.setEmail(email.getText().toString());
            usuario.setPassword(password.getText().toString());

          //  loginUsuarioPresenter.getUsuarioLogin();

        });

        registro.setOnClickListener(v -> {
            Intent navegar = new Intent(getBaseContext(), RegistroUsuarioView.class);
            startActivity(navegar);
        });
    }

    private void initComponents(){
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);
        login = findViewById(R.id.btLogin);
        registro = findViewById(R.id.btRegistro);
    }


    @Override
    public void successLogin(Usuario usuario) {
        Intent navegar = new Intent(getBaseContext(), ListaProductosFragment.class);
        startActivity(navegar);

        Toast.makeText(this, "Bienvenido " + usuario.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }
}

