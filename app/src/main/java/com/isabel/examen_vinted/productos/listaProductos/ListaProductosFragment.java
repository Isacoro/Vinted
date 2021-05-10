package com.isabel.examen_vinted.productos.listaProductos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.adapter.ProductoAdapter;
import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public class ListaProductosFragment extends Fragment implements ListaProductosContract.View {

    private ListaProductosPresenter listaProductosPresenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_productos, viewGroup, false);

//        progressBar.setVisibility(View.VISIBLE);

        initComponents(view);

        listaProductosPresenter = new ListaProductosPresenter(this);
        listaProductosPresenter.getProductos(getContext());

        return view;
    }

    private void initComponents(View vista) {
        recycler = vista.findViewById(R.id.recycler_lista_productos);
//        progressBar = vista.findViewById(R.id.activity_ProgressBar);
    }

    @Override
    public void success(ArrayList<Producto> listaProductos) {
//        progressBar.setVisibility(View.GONE);
        recycler.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 2);
        recycler.setLayoutManager(layoutManager);

        ProductoAdapter adapter = new ProductoAdapter(listaProductos);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        System.out.println(message);


    }
}
