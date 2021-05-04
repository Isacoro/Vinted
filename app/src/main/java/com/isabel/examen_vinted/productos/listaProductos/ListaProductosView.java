package com.isabel.examen_vinted.productos.listaProductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.adapter.ProductoAdapter;
import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.productos.categoriaProductos.CategoriaProductoView;
import com.isabel.examen_vinted.productos.topProductos.TopProductoView;
import com.isabel.examen_vinted.usuarios.topUsuarios.TopUsuariosView;

import java.util.ArrayList;

public class ListaProductosView extends AppCompatActivity implements ListaProductosContract.View {

    private ListaProductosPresenter listaProductosPresenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;

    private Button btTop, btTopUsuarios;
    private Spinner spinner;
    private String[] elegir = {"", "Mujer", "Hombre", "Niños"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos_view);

        listaProductosPresenter = new ListaProductosPresenter(this);
        listaProductosPresenter.getProductos(this);

        btTop = findViewById(R.id.btTop);
        btTopUsuarios = findViewById(R.id.btTopUsuarios);


        btTop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TopProductoView.class);
                v.getContext().startActivity(intent);
            }
        });

        btTopUsuarios.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TopUsuariosView.class);
                v.getContext().startActivity(intent);
            }
        });

        cargaSpinner();
    }

    @Override
    public void success(ArrayList<Producto> listaProductos) {
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        ProductoAdapter adapter = new ProductoAdapter(listaProductos);
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

                if(categoria == "")
                    return;
                Intent navegar = new Intent(getBaseContext(), CategoriaProductoView.class);
                navegar.putExtra("CATEGORIA", categoria);
                startActivity(navegar);
                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "Selecciona una categoría", Toast.LENGTH_SHORT).show();
            }
        });
    }
}