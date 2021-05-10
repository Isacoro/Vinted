package com.isabel.examen_vinted.usuarios.topUsuarios;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.adapter.UsuarioAdapter;
import com.isabel.examen_vinted.beans.Usuario;

import java.util.ArrayList;

public class TopUsuarioFragment extends Fragment implements TopUsuariosContract.View {

    private RecyclerView recycler;
    private TopUsuariosPresenter topUsuariosPresenter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
       View view = layoutInflater.inflate(R.layout.fragment_listado_usuarios_top, viewGroup, false);

       initComponents(view);

        topUsuariosPresenter = new TopUsuariosPresenter(this);
        topUsuariosPresenter.getUsuariosTop(getContext());

        return view;
    }


    private void initComponents(View view){
        recycler = view.findViewById(R.id.recycler_lista_usuarios_top);
}

    @Override
    public void success(ArrayList<Usuario> usuarios) {
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        UsuarioAdapter adapter = new UsuarioAdapter(usuarios);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        System.out.println(message);
    }
}
