package com.isabel.examen_vinted.retrofit;

import com.isabel.examen_vinted.beans.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UsuarioApiInterface {

    //Todos los usuarios
    @GET("usuarios")
    Call<List<Usuario>> getUsuarios();

    //Registrar usuario
    @POST("usuarios")
    Call<Usuario> saveUsuario(@Body Usuario usuario);

    //Login usuario
    @GET("usuarios/email-password")
    Call<Usuario> getUsuarioLogin(String email, String password);

    //Top usuarios
    @GET("usuarios/top")
    Call<Usuario> getUsuariosTop();
}
