package com.isabel.examen_vinted.productos.categoriaProductos;

import android.content.Context;
import androidx.annotation.Nullable;
import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriaProductoModel implements CategoriaProductoContract.Model {

    @Override
    public void getCategoriaProductosWS(Context context, OnCategoriaProductoListener onCategoriaProductoListener, String categoria) {
        ApiClient apiClient = new ApiClient(context);

        final Call<List<Producto>> request = apiClient.getProductosCategoria(categoria);

        request.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if(response != null && response.body() != null){
                    onCategoriaProductoListener.onFinished(new ArrayList<>(response.body()));
                }
            }

            @Override
            public void onFailure(@Nullable  Call<List<Producto>> call, @Nullable Throwable t) {
                t.printStackTrace();
                onCategoriaProductoListener.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
