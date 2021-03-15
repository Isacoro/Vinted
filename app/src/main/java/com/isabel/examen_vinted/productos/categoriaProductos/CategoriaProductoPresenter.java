package com.isabel.examen_vinted.productos.categoriaProductos;

import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public class CategoriaProductoPresenter implements CategoriaProductoContract.Presenter {

    private CategoriaProductoContract.View vista;
    private CategoriaProductoModel categoriaProductoModel;

    public CategoriaProductoPresenter (CategoriaProductoContract.View categoriaProductoVista){
        this.vista = categoriaProductoVista;
        categoriaProductoModel = new CategoriaProductoModel();
    }


    @Override
    public void getProductosCategoria(String categoria) {
        categoriaProductoModel.getCategoriaProductosWS(new CategoriaProductoContract.Model.OnCategoriaProductoListener() {
            @Override
            public void onFinished(ArrayList<Producto> listaProductosCategoria) {
                vista.success(listaProductosCategoria);
            }

            @Override
            public void onFailure(String error) {
                vista.error(error);

            }
        },categoria);
    }
}
