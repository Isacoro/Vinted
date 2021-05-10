package com.isabel.examen_vinted.productos.topProductos;

import android.content.Context;

import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;

public interface TopProductoContract {

    interface View{
        void success(ArrayList<Producto> productos);
        void error(String message);
    }

    interface Presenter{
        void getProductosTop(Context context);
    }

    interface Model{
        void getProductosTopWS(Context context, OnListaProductosTopListener onListaProductosTopListener);

        interface OnListaProductosTopListener{
            void onFinished(ArrayList<Producto> productos);
            void onFailure(String error);
        }
    }
}
