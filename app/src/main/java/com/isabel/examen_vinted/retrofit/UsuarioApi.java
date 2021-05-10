package com.isabel.examen_vinted.retrofit;

import android.content.Context;

import com.isabel.examen_vinted.BuildConfig;
import com.isabel.examen_vinted.beans.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioApi {

//    private Retrofit retrofit;
//    private Usuario usuario;
//
//    public UsuarioApi(Usuario usuario){
//        this.usuario = usuario;
//
//        retrofit = new Retrofit.Builder()
//                .baseUrl(BuildConfig.URL_BASE)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//
//    //Todos los usuarios
//    public Call<List<Usuario>> getUsuarios(){
//        UsuarioApiInterface service = retrofit.create(UsuarioApiInterface.class);
//        return service.getUsuarios();
//    }
//
//    //Registro usuario
//    public Call<Usuario> saveUsuarios(String nombre, String email, String password){
//        UsuarioApiInterface service = retrofit.create(UsuarioApiInterface.class);
//        return service.saveUsuario(nombre, email, password);
//    }
//
//    //Login usuario
//    public Call<Usuario> getUsuarioLogin(String email, String password){
//        UsuarioApiInterface service = retrofit.create(UsuarioApiInterface.class);
//        return service.getUsuarioLogin(email, password);
//    }
//
//    //Usuarios top
//    public Call<Usuario> getUsuariosTop(){
//        UsuarioApiInterface service = retrofit.create(UsuarioApiInterface.class);
//        return  service.getUsuariosTop();
//    }
}
