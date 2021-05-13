package com.isabel.examen_vinted.productos.anadirProducto;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.retrofit.ApiClient;
import com.isabel.examen_vinted.retrofit.ProductoApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnadirProductoModel implements AnadirProductoContract.Model {

    @Override
    public void getAddProductoWS(OnAddProductoListener onAddProductoListener, Producto producto) {

        ProductoApi productoApi = new ProductoApi(producto);

        final Call<Producto> request = productoApi.saveProducto(producto);

        request.enqueue(new Callback<Producto>() {

            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                onAddProductoListener.onFinished(producto);

            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                t.printStackTrace();
                onAddProductoListener.onFailure("No se ha podido registrar el producto");
            }
        });
    }
}
