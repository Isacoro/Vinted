package com.isabel.examen_vinted.retrofit;

import com.isabel.examen_vinted.BuildConfig;
import com.isabel.examen_vinted.beans.Producto;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductoApi {

    private Retrofit retrofit;
    private Producto producto;

    public ProductoApi(Producto producto){
        this.producto = producto;

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public Call<Producto> saveProducto(Producto producto){
        ProductoApiInterface service = retrofit.create(ProductoApiInterface.class);
        return  service.saveProducto(producto);
    }
}
