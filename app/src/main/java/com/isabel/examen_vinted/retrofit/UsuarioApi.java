package com.isabel.examen_vinted.retrofit;

import com.isabel.examen_vinted.BuildConfig;
import com.isabel.examen_vinted.beans.Usuario;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioApi {

    private Retrofit retrofit;
    private Usuario usuario;

    public UsuarioApi(Usuario usuario){
        this.usuario = usuario;

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public Call<Usuario> saveUsuario(Usuario usuario){
        UsuarioApiInterface service = retrofit.create(UsuarioApiInterface.class);
        return  service.saveUsuario(usuario);
    }
}

