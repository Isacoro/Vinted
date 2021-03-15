package com.isabel.examen_vinted.productos.topProductos;

import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public interface TopProductoContract {

    interface View{
        void success(ArrayList<Producto> productos);
        void error(String message);
    }

    interface Presenter{
        void getProductosTop();
    }

    interface Model{
        void getProductosTopWS(OnListaProductosTopListener onListaProductosTopListener);

        interface OnListaProductosTopListener{
            void onFinished(ArrayList<Producto> productos);
            void onFailure(String error);
        }
    }
}
