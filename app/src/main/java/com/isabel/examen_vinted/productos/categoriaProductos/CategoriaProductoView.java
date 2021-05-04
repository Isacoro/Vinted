package com.isabel.examen_vinted.productos.categoriaProductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.adapter.ProductoAdapter;
import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public class CategoriaProductoView extends AppCompatActivity implements CategoriaProductoContract.View {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private CategoriaProductoPresenter categoriaProductoPresenter;

    private Spinner spinner;
    private String[] elegir = {"", "Mujer", "Hombre", "Niños"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_producto_view);

        Intent navegar = this.getIntent();
        Bundle extra = navegar.getExtras();

        String categoria = navegar.getStringExtra("categoria");

        categoriaProductoPresenter = new CategoriaProductoPresenter(this);
        categoriaProductoPresenter.getProductosCategoria(this, categoria);

        cargaSpinner();
    }

    @Override
    public void success(ArrayList<Producto> listaProductosCategoria) {

        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        ProductoAdapter adapter = new ProductoAdapter(listaProductosCategoria);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    private void cargaSpinner() {
        spinner = findViewById(R.id.spinnerFiltro);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, elegir);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelected(false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String categoria = parent.getItemAtPosition(position).toString();
                Intent navegar = new Intent(getBaseContext(), CategoriaProductoView.class);

                if(categoria == "")
                    return;

                navegar.putExtra("categoria", categoria);
                startActivity(navegar);
                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "Selecciona una categoría", Toast.LENGTH_SHORT).show();
            }
        });
    }
}