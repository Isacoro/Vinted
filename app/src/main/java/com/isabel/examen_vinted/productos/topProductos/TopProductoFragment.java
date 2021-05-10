package com.isabel.examen_vinted.productos.topProductos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.adapter.ProductoAdapter;
import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public class TopProductoFragment extends Fragment implements TopProductoContract.View {

    private RecyclerView recycler;
    private TopProductoPresenter topProductoPresenter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.fragment_listado_productos_top, viewGroup, false);

        initComponents(view);

        topProductoPresenter = new TopProductoPresenter(this);
        topProductoPresenter.getProductosTop(getContext());

        return view;
    }

    private void initComponents(View view){
        recycler = view.findViewById(R.id.recycler_lista_productos_top);
    }

    @Override
    public void success(ArrayList<Producto> productos) {
        recycler.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 2);
        recycler.setLayoutManager(layoutManager);

        ProductoAdapter adapter = new ProductoAdapter(productos);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
       System.out.println(message);
    }
}
