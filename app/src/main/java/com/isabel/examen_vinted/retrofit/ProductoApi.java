package com.isabel.examen_vinted.retrofit;

import android.content.Context;

import com.isabel.examen_vinted.BuildConfig;
import com.isabel.examen_vinted.beans.Producto;

import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductoApi {

    private Retrofit retrofit;
    private Context context;

    public ProductoApi(Context context){
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //Todos los productos
    public Call<List<Producto>> getProductos(){
        ProductoApiInterface service = retrofit.create(ProductoApiInterface.class);
        return service.getProductos();
    }

    //Productos top
    public Call<List<Producto>> getProductosTop(){
        ProductoApiInterface service = retrofit.create(ProductoApiInterface.class);
        return  service.getProductosTop();
    }

    //Productos por categoria
    public Call<List<Producto>> getProductosCategoria(String categoria){
        ProductoApiInterface service = retrofit.create(ProductoApiInterface.class);
        return service.getProductosCategoria(categoria);
    }

    //Añadir producto
    public Call<Producto> saveProducto(Producto producto){
        ProductoApiInterface service = retrofit.create(ProductoApiInterface.class);
        return  service.saveProducto(producto);
    }
}
