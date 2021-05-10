package com.isabel.examen_vinted.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.productos.listaProductos.DetalleProductosView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private ArrayList<Producto> listaProductos;

    public ProductoAdapter(ArrayList<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder{
        public ImageView url;
        public TextView nombre;
        public TextView descripcion;
        public TextView precio;

        public ProductoViewHolder(@NonNull View view) {
            super(view);

            url = view.findViewById(R.id.imgImagen);
            nombre = view.findViewById(R.id.txtNombre);
            descripcion = view.findViewById(R.id.txtDescripcion);
            precio = view.findViewById(R.id.txtPrecio);
        }
    }


    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos_row, parent, false);
        return new ProductoViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {

        Producto producto = listaProductos.get(position);

        holder.nombre.setText(producto.getNombre());
        holder.precio.setText(producto.getPrecio() + "€");
        Picasso.get().load(producto.getUrl()).fit().centerCrop().into(holder.url);


        holder.itemView.setOnClickListener(v -> {
            Intent navegar = new Intent(v.getContext(), DetalleProductosView.class);

            navegar.putExtra("precio", producto.getPrecio() + "€");
            navegar.putExtra("nombre", producto.getNombre());
            navegar.putExtra("descripcion", producto.getDescripcion());
            navegar.putExtra("url", producto.getUrl());
            v.getContext().startActivity(navegar);
        });
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }
}
