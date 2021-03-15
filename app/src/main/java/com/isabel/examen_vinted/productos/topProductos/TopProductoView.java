package com.isabel.examen_vinted.productos.topProductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.adapter.ProductoAdapter;

import java.util.ArrayList;

public class TopProductoView extends AppCompatActivity implements TopProductoContract.View {

    private RecyclerView recycler;
    private TopProductoPresenter topProductoPresenter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_producto_view);

        topProductoPresenter = new TopProductoPresenter(this);
        topProductoPresenter.getProductosTop();
    }

    @Override
    public void success(ArrayList<Producto> productos) {
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        ProductoAdapter adapter = new ProductoAdapter(productos);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

    }
}