package com.isabel.examen_vinted.productos.anadirProducto;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.beans.ProductoDTO;
import com.isabel.examen_vinted.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnadirProductoModel implements AnadirProductoContract.Model {

    @Override
    public void addProductoWS(Context context, OnAddProductoListener onAddProductoListener, ProductoDTO productoDTO) {

        ApiClient apiClient = new ApiClient(context);

        final Call<Producto> request = apiClient.addProducto(productoDTO);

        request.enqueue(new Callback<Producto>() {

            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                onAddProductoListener.onFinished(response.body());

            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                t.printStackTrace();
                onAddProductoListener.onFailure("No se ha podido registrar el producto");
            }
        });
    }
}
