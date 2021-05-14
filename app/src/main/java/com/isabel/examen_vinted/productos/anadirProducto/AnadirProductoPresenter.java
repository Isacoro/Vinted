package com.isabel.examen_vinted.productos.anadirProducto;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.beans.ProductoDTO;

public class AnadirProductoPresenter implements AnadirProductoContract.Presenter{

    private AnadirProductoModel anadirProductoModel;
    private AnadirProductoContract.View vista;
    private ProductoDTO productoDTO;

    public AnadirProductoPresenter(AnadirProductoContract.View vista){
        this.vista = vista;
        anadirProductoModel = new AnadirProductoModel();
        productoDTO = new ProductoDTO();
    }


    @Override
    public void addProducto(Context context, ProductoDTO productoDTO) {
        this.productoDTO = productoDTO;
        anadirProductoModel.addProductoWS(context, new AnadirProductoContract.Model.OnAddProductoListener() {
            @Override
            public void onFinished(Producto nuevoProducto) {
                vista.successAddProducto(nuevoProducto);
            }

            @Override
            public void onFailure(String error) {
                vista.error(error);
            }
        },productoDTO);

    }
}
