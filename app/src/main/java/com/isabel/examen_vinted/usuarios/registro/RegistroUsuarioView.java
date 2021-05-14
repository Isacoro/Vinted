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
import com.isabel.examen_vinted.beans.UsuarioDTO;
import com.isabel.examen_vinted.productos.listaProductos.ListaProductosFragment;
import com.isabel.examen_vinted.usuarios.login.UsuarioView;

public class RegistroUsuarioView extends AppCompatActivity implements RegistroUsuarioContract.View {

    private RegistroUsuarioPresenter registroUsuarioPresenter;
    private EditText edtNombre, edtApellidos, edtCiudad, edtEmail, edtPassword;
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

                UsuarioDTO usuarioDTO = new UsuarioDTO();

                usuarioDTO.setNombre(edtNombre.getText().toString());
                usuarioDTO.setApellidos(edtApellidos.getText().toString());
                usuarioDTO.setCiudad(edtCiudad.getText().toString());
                usuarioDTO.setEmail(edtEmail.getText().toString());
                usuarioDTO.setPassword(edtPassword.getText().toString());


                registroUsuarioPresenter.addUsuario(v.getContext(), usuarioDTO);
            }
        });
    }


    private void initComponents(){
        edtNombre= findViewById(R.id.edtNombre);
        edtApellidos = findViewById(R.id.edtApellidos);
        edtCiudad = findViewById(R.id.edtCiudad);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        registrar = findViewById(R.id.btAceptar);
    }

    @Override
    public void successRegistro(Usuario usuario) {
        Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
        Intent navegar = new Intent(getBaseContext(), UsuarioView.class);
        startActivity(navegar);
    }

    @Override
    public void error(String message) {
        System.out.println(message);
    }
}