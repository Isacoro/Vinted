package com.isabel.examen_vinted.productos.listaProductos;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public class ListaProductosPresenter implements ListaProductosContract.Presenter {

    private ListaProductosModel listaProductosModel;
    private ListaProductosContract.View vista;

    public ListaProductosPresenter(ListaProductosContract.View vista){
        this.vista = vista;
        this.listaProductosModel = new ListaProductosModel();
    }


    @Override
    public void getProductos(Context context) {
        listaProductosModel.getProductosWS(context, new ListaProductosContract.Model.OnListProductosListener() {
            @Override
            public void onFinished(ArrayList<Producto> productos) {
                vista.success(productos);
            }

            @Override
            public void onFailure(String error) {
                vista.error("Error al traer los datos");
            }
        });
    }
}
