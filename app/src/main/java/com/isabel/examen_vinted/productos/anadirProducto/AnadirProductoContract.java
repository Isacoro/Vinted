package com.isabel.examen_vinted.productos.anadirProducto;


import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;

public interface AnadirProductoContract {

    interface View{
        void successAddProducto(Producto producto);
        void error (String message);
    }

    interface Presenter{
        void getAddProducto(Producto producto);
    }

    interface Model{
        void getAddProductoWS(OnAddProductoListener onAddProductoListener, Producto producto);

        interface OnAddProductoListener{
            void onFinished(Producto producto);
            void onFailure(String error);
        }
    }


}
