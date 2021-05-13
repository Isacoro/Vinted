package com.isabel.examen_vinted.productos.anadirProducto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isabel.examen_vinted.MainActivity;
import com.isabel.examen_vinted.R;
import com.isabel.examen_vinted.beans.Producto;

public class AnadirProductoView extends AppCompatActivity implements AnadirProductoContract.View {

    private AnadirProductoPresenter anadirProductoPresenter;
    private EditText etNombre, etDescripcion, etPrecio, etCategoria;
    private Button aceptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_producto_view);

        initComponents();

        anadirProductoPresenter = new AnadirProductoPresenter(this);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto producto = new Producto();

                producto.setNombre(etNombre.getText().toString());
                producto.setDescripcion(etDescripcion.getText().toString());
                producto.setPrecio(etPrecio.getAlpha());
                producto.setCategoria(etCategoria.getText().toString());

                anadirProductoPresenter.getAddProducto(producto);
            }
        });
    }


    private void initComponents() {
        etNombre = findViewById(R.id.etNombre);
        etDescripcion = findViewById(R.id.etDescripcion);
        etPrecio = findViewById(R.id.etPrecio);
        etCategoria = findViewById(R.id.etCategoria);
        aceptar = findViewById(R.id.btAceptar);
    }


    @Override
    public void successAddProducto(Producto nuevoProducto) {
        Toast.makeText(this, "Producto añadido", Toast.LENGTH_SHORT).show();
        Intent navegar = new Intent(getBaseContext(), MainActivity.class);
        startActivity(navegar);

    }

    @Override
    public void error(String message) {
        System.out.println(message);
    }
}