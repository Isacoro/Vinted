package com.isabel.examen_vinted.productos.listaProductos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private BottomNavigationView bottomNavigationView;


//    private Spinner spinner;
//    private String[] elegir = {"", "Mujer", "Hombre", "Niños"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_productos, viewGroup, false);

        initComponents(view);

        listaProductosPresenter = new ListaProductosPresenter(this);
        listaProductosPresenter.getProductos(getContext());

        return view;
//        cargaSpinner();
    }

    private void initComponents(View vista) {
        recycler = vista.findViewById(R.id.recycler_lista_productos);
    }

    @Override
    public void success(ArrayList<Producto> listaProductos) {
        recycler.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 2);
        recycler.setLayoutManager(layoutManager);

        ProductoAdapter adapter = new ProductoAdapter(listaProductos);
        recycler.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        System.out.println(message);

//        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

//    private void cargaSpinner() {
//        final AutoCompleteTextView spinner = findViewById(R.id.spinnerFiltro);
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.layout_spinner, elegir);
//        spinner.setAdapter(arrayAdapter);
//        spinner.setSelected(false);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String categoria = parent.getItemAtPosition(position).toString();
//
//                if(categoria == "")
//                    return;
//                Intent navegar = new Intent(getBaseContext(), CategoriaProductoView.class);
//                navegar.putExtra("categoria", categoria);
//                startActivity(navegar);
//
//                }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                Toast.makeText(parent.getContext(), "Selecciona una categoría", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
