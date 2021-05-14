package com.isabel.examen_vinted.productos.anadirProducto;


import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.beans.ProductoDTO;

public interface AnadirProductoContract {

    interface View{
        void successAddProducto(Producto nuevoProducto);
        void error (String message);
    }

    interface Presenter{
        void addProducto(Context context, ProductoDTO productoDTO);
    }

    interface Model{
        void addProductoWS(Context context, OnAddProductoListener onAddProductoListener, ProductoDTO productoDTO);

        interface OnAddProductoListener{
            void onFinished(Producto nuevoProducto);
            void onFailure(String error);
        }
    }


}
