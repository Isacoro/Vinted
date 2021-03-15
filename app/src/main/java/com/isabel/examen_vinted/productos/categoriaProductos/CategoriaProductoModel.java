package com.isabel.examen_vinted.productos.categoriaProductos;

import android.os.AsyncTask;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoriaProductoModel implements CategoriaProductoContract.Model {

    private ArrayList<Producto> listaCategoriaProductos;
    OnCategoriaProductoListener onCategoriaProductoListener;

    @Override
    public void getCategoriaProductosWS(OnCategoriaProductoListener onCategoriaProductoListener, String categoria) {
        this.onCategoriaProductoListener = onCategoriaProductoListener;

        HashMap<String, String> param = new HashMap<>();
        param.put("ACTION", "PRODUCTO.FIND_ALL");
        param.put("FILTRO", "CATEGORIA");
        param.put("CATEGORIA", categoria);

        TareaSegundoPlano hilo = new TareaSegundoPlano(param);
        hilo.execute("http://192.168.1.18:8090/Vinted_Isabel/Controller");
    }

    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {

        private HashMap<String, String> parametros = null;

        public TareaSegundoPlano(HashMap<String, String> parametros) {
            super();
            this.parametros = parametros;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            String url = strings[0];

            try {
                Post post = new Post();
                System.out.println(parametros.toString() + url);
                JSONArray listaProductos = post.getServerDataPost(parametros, url);
                listaCategoriaProductos = Producto.getArrayListFromJSon(listaProductos);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }


        protected void onPostExecute(Boolean respuesta) {
            if (respuesta) {
                if (listaCategoriaProductos != null && listaCategoriaProductos.size() > 0) {
                    onCategoriaProductoListener.onFinished(listaCategoriaProductos);
                }
            } else {
                onCategoriaProductoListener.onFailure("Error al traer los datos");
            }
        }
    }
}
