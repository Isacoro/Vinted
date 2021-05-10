package com.isabel.examen_vinted.retrofit;

import com.isabel.examen_vinted.beans.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UsuarioApiInterface {

    //Todos los usuarios
    @GET("usuarios")
    Call<List<Usuario>> getUsuarios();

    //Registrar usuario
    @POST("usuarios")
    Call<Usuario> saveUsuario(@Field("nombre") String nombre,
                              @Field("email") String email,
                              @Field("password") String password);

    //Login usuario
    @GET("usuarios/email-password")
    Call<Usuario> getUsuarioLogin(@Query("email") String email,
                                  @Query("password") String password);

    //Top usuarios
    @GET("usuarios/top")
    Call<Usuario> getUsuariosTop();
}
