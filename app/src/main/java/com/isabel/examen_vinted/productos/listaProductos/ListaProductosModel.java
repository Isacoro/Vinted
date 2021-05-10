package com.isabel.examen_vinted.productos.listaProductos;

import android.content.Context;


import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.retrofit.ProductoApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaProductosModel implements ListaProductosContract.Model {


    @Override
    public void getProductosWS(Context context, OnListProductosListener onListProductosListener) {
        ProductoApi productoApi = new ProductoApi(context);

        final Call<List<Producto>> request = productoApi.getProductos();

        request.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response != null && response.body() != null) {
                    onListProductosListener.onFinished(new ArrayList<Producto>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                    t.printStackTrace();
                    onListProductosListener.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
