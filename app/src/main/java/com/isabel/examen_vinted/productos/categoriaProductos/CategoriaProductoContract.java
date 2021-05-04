package com.isabel.examen_vinted.productos.categoriaProductos;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public interface CategoriaProductoContract {

    interface View{
        void success(ArrayList<Producto> productos);
        void error(String message);
    }

    interface Presenter{
        void getProductosCategoria(Context context, String categoria);
    }

    interface Model{
        void getCategoriaProductosWS(Context context, OnCategoriaProductoListener onCategoriaProductoListener, String categoria);

        interface OnCategoriaProductoListener{
            void onFinished(ArrayList<Producto> listaProductosCategoria);
            void onFailure(String error);
        }
    }
}
