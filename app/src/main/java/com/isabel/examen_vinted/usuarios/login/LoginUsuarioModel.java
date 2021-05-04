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
    }


}
