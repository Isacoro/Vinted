package com.isabel.examen_vinted.productos.topProductos;


import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopProductoModel implements TopProductoContract.Model {

    @Override
    public void getProductosTopWS(Context context, OnListaProductosTopListener onListaProductosTopListener) {
        ApiClient apiClient = new ApiClient(context);

        final Call<List<Producto>> request = apiClient.getProductosTop();

        request.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if(response != null && response.body() != null){
                    onListaProductosTopListener.onFinished(new ArrayList<>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                t.printStackTrace();
                onListaProductosTopListener.onFailure(t.getLocalizedMessage());

            }
        });
    }
}
