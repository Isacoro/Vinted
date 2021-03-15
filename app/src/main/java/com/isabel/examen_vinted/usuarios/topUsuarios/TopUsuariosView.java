package com.isabel.examen_vinted.usuarios.topUsuarios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.adapter.UsuarioAdapter;
import com.isabel.examen_vinted.beans.Usuario;

import java.util.ArrayList;

public class TopUsuariosView extends AppCompatActivity implements TopUsuariosContract.View {

    private RecyclerView recycler;
    private TopUsuariosPresenter topUsuariosPresenter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_usuario_view);

        topUsuariosPresenter = new TopUsuariosPresenter(this);
        topUsuariosPresenter.getUsuariosTop();
    }

    @Override
    public void success(ArrayList<Usuario> usuarios) {
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        UsuarioAdapter adapter = new UsuarioAdapter(usuarios);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

    }
}