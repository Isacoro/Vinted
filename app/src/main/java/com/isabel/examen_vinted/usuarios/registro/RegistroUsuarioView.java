package com.isabel.examen_vinted.usuarios.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        registroUsuarioPresenter = new RegistroUsuarioPresenter();

        initComponents();

        registrar.setOnClickListener(v -> {
            Usuario usuario = new Usuario();

            usuario.setNombre(nombre.getText().toString());
            usuario.setEmail(email.getText().toString());
            usuario.setPassword(password.getText().toString());

//            registroUsuarioPresenter.getRegistroUsuario(c);
        });
    }

    private void initComponents(){
        nombre = findViewById(R.id.edtNombre);
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);
        registrar = findViewById(R.id.btAceptar);
    }

    @Override
    public void succesRegistro(Usuario usuario) {
        Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
        Intent navegar = new Intent(getBaseContext(), ListaProductosFragment.class);
        startActivity(navegar);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}