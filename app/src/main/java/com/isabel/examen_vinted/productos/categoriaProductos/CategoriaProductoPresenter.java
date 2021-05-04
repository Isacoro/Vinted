package com.isabel.examen_vinted.productos.categoriaProductos;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public class CategoriaProductoPresenter implements CategoriaProductoContract.Presenter {

    private CategoriaProductoContract.View vista;
    private CategoriaProductoModel categoriaProductoModel;

    public CategoriaProductoPresenter (CategoriaProductoContract.View vista){
        this.vista = vista;
        categoriaProductoModel = new CategoriaProductoModel();
    }

    @Override
    public void getProductosCategoria(Context context, String categoria) {
        categoriaProductoModel.getCategoriaProductosWS(context, new CategoriaProductoContract.Model.OnCategoriaProductoListener() {
            @Override
            public void onFinished(ArrayList<Producto> listaProductosCategoria) {
                vista.success(listaProductosCategoria);
            }

            @Override
            public void onFailure(String error) {
                vista.error("Error al traer los datos");
            }
        },categoria);
    }
}
