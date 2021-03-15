package com.isabel.examen_vinted.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.beans.Usuario;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    private ArrayList<Usuario> listaUsuarios;

    public UsuarioAdapter(ArrayList<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre;
        public TextView ciudad;
        public TextView ventas;


        public UsuarioViewHolder(@NonNull View view) {
            super(view);

            nombre = view.findViewById(R.id.txtNombre);
            ciudad = view.findViewById(R.id.txtCiudad);
            ventas = view.findViewById(R.id.txtVentas);
        }
    }


    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuarios_row, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.UsuarioViewHolder holder, int position) {

        Usuario usuario = listaUsuarios.get(position);

        holder.nombre.setText(usuario.getNombre());
        holder.ciudad.setText(usuario.getCiudad());
        holder.ventas.setText(usuario.getVentas() + " ventas");
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }
}
