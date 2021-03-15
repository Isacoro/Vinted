package com.isabel.examen_vinted.usuarios.login;

import android.os.AsyncTask;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginUsuarioModel implements LoginUsuarioContract.Model {

    private ArrayList<Usuario> listaArrayUsuarios;
    OnLoginUsuarioListener onLoginUsuarioListener;

    @Override
    public void getUsuarioWS(OnLoginUsuarioListener onLoginUsuarioListener, Usuario usuario) {
        this.onLoginUsuarioListener = onLoginUsuarioListener;

        HashMap<String, String> param = new HashMap<>();

        param.put("ACTION", "USUARIO.LOGIN");
        param.put("NOMBRE", usuario.getNombre());
        param.put("PASSWORD", usuario.getPassword());

        TareaSegundoPlano hilo = new TareaSegundoPlano(param);
        hilo.execute("http://192.168.1.18:8090/Vinted_Isabel/Controller");
    }

    class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {
        private HashMap<String, String> parametros;

        public TareaSegundoPlano(HashMap<String, String> parametros){
            this.parametros = parametros;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            String url = strings[0];

            try{
                Post post = new Post();

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
                    onLoginUsuarioListener.onFinished(listaArrayUsuarios.get(0));
                }
            }else{
                onLoginUsuarioListener.onFailure("Usuario incorrecto o no registrado");
            }
        }
    }
}
