package com.isabel.examen_vinted.retrofit;

import com.isabel.examen_vinted.beans.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ProductoApiInterface {

    //Todos los productos
    @GET("productos")
    Call<List<Producto>> getProductos();

    //Productos top
    @GET("productos/top")
    Call<List<Producto>> getProductosTop();

    //Productos por categoría
    @GET("productos/categoria")
    Call<List<Producto>> getProductosCategoria(@Query("categoria") String categoria);

    //Añadir producto
    @POST("productos")
    Call<Producto> saveProducto(@Body Producto producto);
}
