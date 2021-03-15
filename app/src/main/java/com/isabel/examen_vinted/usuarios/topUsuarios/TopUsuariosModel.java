package com.isabel.examen_vinted.usuarios.topUsuarios;

import android.os.AsyncTask;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.productos.topProductos.TopProductoModel;
import com.isabel.examen_vinted.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class TopUsuariosModel implements TopUsuariosContract.Model {

    private ArrayList<Usuario> listaArrayUsuarios;
    OnListaUsuariosTopListener onListaUsuariosTopListener;


    @Override
    public void getUsuariosTopWS(OnListaUsuariosTopListener onListaUsuariosTopListener) {
        this.onListaUsuariosTopListener = onListaUsuariosTopListener;

        HashMap<String, String> param = new HashMap<>();
        param.put("ACTION", "USUARIO.TOP10");
        param.put("FILTRO", "TOP10");

        TareaSegundoPlano hilo = new TareaSegundoPlano(param);
        hilo.execute("http://192.168.1.18:8090/Vinted_Isabel/Controller");
    }

    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {
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

                JSONArray listaUsuarios = post.getServerDataPost(parametros, url);
                listaArrayUsuarios = Usuario.getArrayListFromJSon(listaUsuarios);
            }catch (Exception e){
                e.printStackTrace();
            }
            return true;
        }

        protected void onPostExecute(Boolean respuesta){
            if(respuesta){
                if(listaArrayUsuarios != null && listaArrayUsuarios.size() > 0){
                    onListaUsuariosTopListener.onFinished(listaArrayUsuarios);
                }
            }else {
                onListaUsuariosTopListener.onFailure("Error al traer los datos");
            }
        }
    }

}
