package com.isabel.examen_vinted.productos.topProductos;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.productos.listaProductos.ListaProductosContract;

import java.util.ArrayList;

public class TopProductoPresenter implements TopProductoContract.Presenter {

    private TopProductoModel topProductoModel;
    private TopProductoContract.View vista;

    public TopProductoPresenter (TopProductoContract.View vista){
        this.vista = vista;
        topProductoModel = new TopProductoModel();
    }

    @Override
    public void getProductosTop(Context context) {
        topProductoModel.getProductosTopWS(context, new TopProductoContract.Model.OnListaProductosTopListener() {
            @Override
            public void onFinished(ArrayList<Producto> productos) {
                vista.success(productos);
            }

            @Override
            public void onFailure(String error) {
                vista.error(error);
            }
        });
    }
}
