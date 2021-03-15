package com.isabel.examen_vinted.productos.topProductos;

import android.os.AsyncTask;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.utils.Post;

import org.json.JSONArray;

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

        TareaSegundoPlano hilo = new TareaSegundoPlano(param);
        hilo.execute("http://192.168.1.18:8090/Vinted_Isabel/Controller");
    }

    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean>{
        private HashMap<String, String> parametros = null;

        public TareaSegundoPlano(HashMap<String, String> parametros){
            super();
            this.parametros = parametros;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            String url = strings[0];

            try{
                Post post = new Post();
                System.out.println(parametros.toString() + url);

                JSONArray listaProductos = post.getServerDataPost(parametros, url);
                listaArrayProductos = Producto.getArrayListFromJSon(listaProductos);
            }catch (Exception e){
                e.printStackTrace();
            }
            return true;
        }

        protected void onPostExecute(Boolean respuesta){
            if(respuesta){
                if(listaArrayProductos != null && listaArrayProductos.size() > 0){
                    onListaProductosTopListener.onFinished(listaArrayProductos);
                }
            }else {
                onListaProductosTopListener.onFailure("Error al traer los datos");
            }
        }
    }
}
