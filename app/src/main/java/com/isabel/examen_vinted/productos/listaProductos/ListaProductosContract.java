package com.isabel.examen_vinted.productos.listaProductos;

import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public interface ListaProductosContract {

    interface View{
        void success(ArrayList<Producto> listaProductos);
        void error(String message);
    }

    interface Presenter{
        void getProductos();
    }

    interface Model{
        void getProductosWS(OnListProductosListener onListProductosListener);

        interface OnListProductosListener{
            void onFinished(ArrayList<Producto> listaProductos);
            void onFailure(String error);
        }
    }
}
