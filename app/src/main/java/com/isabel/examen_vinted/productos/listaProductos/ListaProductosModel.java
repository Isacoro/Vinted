package com.isabel.examen_vinted.productos.listaProductos;

import android.os.AsyncTask;
import android.util.Log;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaProductosModel implements ListaProductosContract.Model {

    private ArrayList<Producto> listaProductos;
    OnListProductosListener onListProductosListener;


    @Override
    public void getProductosWS(OnListProductosListener onListProductosListener) {
        this.onListProductosListener = onListProductosListener;
        HashMap<String, String> param = new HashMap<>();
        param.put("ACTION", "PRODUCTO.FIND_ALL");

        TareaSegundoPlano hilo = new TareaSegundoPlano(param);
        hilo.execute("http://192.168.1.18:8090/Vinted_Isabel/Controller");
    }

    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {
        private HashMap<String, String> parametros = null;

        public TareaSegundoPlano( HashMap<String, String> parametros) {
            super();
            this.parametros = parametros;
        }

        @Override
        protected Boolean  doInBackground(String... params) {
            String url_select = params[0];
            try {
                Post post = new Post();
                JSONArray result = post.getServerDataPost(parametros,url_select);
                listaProductos = Producto.getArrayListFromJSon(result);
            }catch (Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            try {
                if(resp){
                    onListProductosListener.onFinished(listaProductos);
                }
            }catch (Exception e) {
                onListProductosListener.onFailure("Fallo al traer los productos");
            }
        }
    }
}
