package com.isabel.examen_vinted.productos.topProductos;


import com.isabel.examen_vinted.beans.Producto;

import java.util.ArrayList;
import java.util.HashMap;

public class TopProductoModel implements TopProductoContract.Model {

    private ArrayList<Producto> listaArrayProductos;
    OnListaProductosTopListener onListaProductosTopListener;

    @Override
    public void getProductosTopWS(OnListaProductosTopListener onListaProductosTopListener) {
        this.onListaProductosTopListener = onListaProductosTopListener;

        HashMap<String, String> param = new HashMap<>();
        param.put("ACTION", "PRODUCTO.FIND_ALL");
        param.put("FILTRO", "TOP10");
    }
}
