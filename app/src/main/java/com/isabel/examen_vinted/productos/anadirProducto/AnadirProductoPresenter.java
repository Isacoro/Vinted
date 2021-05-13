package com.isabel.examen_vinted.productos.anadirProducto;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;

public class AnadirProductoPresenter implements AnadirProductoContract.Presenter{

    private AnadirProductoModel anadirProductoModel;
    private AnadirProductoContract.View vista;

    public AnadirProductoPresenter(AnadirProductoContract.View vista){
        this.vista = vista;
        this.anadirProductoModel = new AnadirProductoModel();
    }


    @Override
    public void getAddProducto(Producto producto) {
        anadirProductoModel.getAddProductoWS(new AnadirProductoContract.Model.OnAddProductoListener() {
            @Override
            public void onFinished(Producto producto) {
                vista.successAddProducto(producto);
            }

            @Override
            public void onFailure(String error) {
                vista.error(error);
            }
        },producto);

    }
}
