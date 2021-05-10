package com.isabel.examen_vinted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.isabel.examen_vinted.productos.categoriaProductos.CategoriaProductoView;
import com.isabel.examen_vinted.productos.listaProductos.ListaProductosContract;
import com.isabel.examen_vinted.productos.listaProductos.ListaProductosFragment;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.productos.listaProductos.ListaProductosPresenter;
import com.isabel.examen_vinted.productos.topProductos.TopProductoFragment;
import com.isabel.examen_vinted.usuarios.login.LoginUsuarioFragment;
import com.isabel.examen_vinted.usuarios.topUsuarios.TopUsuarioFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListaProductosContract.View {

    private ListaProductosPresenter listaProductosPresenter;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutManager;
    private FragmentManager fragmentManager;
    private RelativeLayout relativeLayout;
    private BottomNavigationView bottomNavigationView;

//    private Spinner spinner;
//    private String[] elegir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaProductosPresenter = new ListaProductosPresenter(this);
        listaProductosPresenter.getProductos(this);

        initComponents();

        bottomNavigationView.setSelectedItemId(R.id.menu_nav1);
        inicioBottomNavigation();

        fragmentManager = getSupportFragmentManager();

        fragmentInicio();
    }


    private void initComponents(){
        relativeLayout = findViewById(R.id.layout_principal);
        bottomNavigationView = findViewById(R.id.menu_navigation);
//        spinner = findViewById(R.id.categoriaTextView);
    }


    private void inicioBottomNavigation(){
        bottomNavigationView.setOnNavigationItemReselectedListener((item) -> {

            switch(item.getItemId()){

                case R.id.menu_nav1:
                    fragmentInicio();
                    break;

                case R.id.menu_nav2:
                    fragmentProductosTop();
                    break;

                case R.id.menu_nav3:
                    fragmentUsuariosTop();
                    break;
//
//                    case R.id.menu_nav4:
//                        showFragmentCuenta();
//                        break;
            }

            return;
        });
    }

    private void fragmentInicio(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ListaProductosFragment listaProductosFragment = new ListaProductosFragment();
        transaction.replace(R.id.layout_fragment, listaProductosFragment);
//        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void fragmentProductosTop(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TopProductoFragment topProductoFragment = new TopProductoFragment();
        transaction.replace(R.id.layout_fragment, topProductoFragment);
//        transaction.addToBackStack(null);
        transaction.commit();

    }

    private void fragmentUsuariosTop(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TopUsuarioFragment topUsuarioFragment = new TopUsuarioFragment();
        transaction.replace(R.id.layout_fragment, topUsuarioFragment);
//        transaction.addToBackStack(null);
        transaction.commit();

    }
//
//    private void fragmentCuenta(){
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        LoginUsuarioFragment loginUsuarioFragment = new LoginUsuarioFragment();
//        transaction.replace(R.id.layout_fragment, loginUsuarioFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//
//    }


    @Override
    public void success(ArrayList<Producto> listaProductos) {

    }

    @Override
    public void error(String message) {
        System.out.println(message);

    }

//    private void cargaSpinner() {
//        final AutoCompleteTextView spinner = findViewById(R.id.categoriaTextView);
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