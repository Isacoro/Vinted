package com.isabel.examen_vinted.productos.listaProductos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.isabel.examen_vinted.MainActivity;
import com.isabel.examen_vinted.R;
import com.squareup.picasso.Picasso;

public class DetalleProductosView extends AppCompatActivity {

    private ImageView url;
    private TextView nombre, descripcion, precio;
    private FloatingActionButton buttonFavourite, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_productos_view);

        initComponents();

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleProductosView.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonFavourite.setColorFilter(Color.GRAY);
                buttonFavourite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonFavourite.setColorFilter(Color.WHITE);
                    }
                });
            }
        });

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String descrip = intent.getStringExtra("descripcion");
        String nomb = intent.getStringExtra("nombre");
        String pre = intent.getStringExtra("precio");

        nombre.setText(nomb);
        descripcion.setText(descrip);
        precio.setText(pre);
        Picasso.get().load(url).into(this.url);

    }

    public void initComponents(){
        url = findViewById(R.id.imgImagen);
        descripcion = findViewById(R.id.txtDescripcion);
        nombre = findViewById(R.id.txtNombre);
        precio = findViewById(R.id.txtPrecio);
        buttonFavourite = findViewById(R.id.activityFavorite);
        buttonBack = findViewById(R.id.activityBack);
    }
}