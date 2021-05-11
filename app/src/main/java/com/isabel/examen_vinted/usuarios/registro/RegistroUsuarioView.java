package com.isabel.examen_vinted.usuarios.registro;

import androidx.appcompat.app.AppCompatActivity;

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

public class RegistroUsuarioView extends AppCompatActivity implements RegistroUsuarioContract.View {

    private RegistroUsuarioPresenter registroUsuarioPresenter;
    private EditText nombre, email, password;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario_view);

        initComponents();

        registroUsuarioPresenter = new RegistroUsuarioPresenter(this);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();

                usuario.setNombre(nombre.getText().toString());
                usuario.setEmail(email.getText().toString());
                usuario.setPassword(password.getText().toString());

                registroUsuarioPresenter.getRegistroUsuario(getBaseContext(), usuario);

            }
        });
    }
    private void initComponents(){
        nombre = findViewById(R.id.edtNombre);
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);
        registrar = findViewById(R.id.btAceptar);
    }

    @Override
    public void successRegistro(Usuario usuario) {
        Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
        Intent navegar = new Intent(getBaseContext(), MainActivity.class);
        startActivity(navegar);
    }

    @Override
    public void error(String message) {
        System.out.println(message);
    }
}