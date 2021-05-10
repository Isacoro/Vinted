package com.isabel.examen_vinted.usuarios.topUsuarios;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.retrofit.UsuarioApi;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;

public class TopUsuariosModel implements TopUsuariosContract.Model {


    @Override
    public void getUsuariosTopWS(Context context, OnListaUsuariosTopListener onListaUsuariosTopListener) {
      //  UsuarioApi usuarioApi = new UsuarioApi(context);

    }
}
