package com.isabel.examen_vinted.productos.listaProductos;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public interface ListaProductosContract {

    interface View{
        void success(ArrayList<Producto> productos);
        void error(String message);
    }

    interface Presenter{
        void getProductos(Context context);
    }

    interface Model{
        void getProductosWS(Context context, OnListProductosListener onListProductosListener);

        interface OnListProductosListener{
            void onFinished(ArrayList<Producto> productos);
            void onFailure(String error);
        }
    }
}
