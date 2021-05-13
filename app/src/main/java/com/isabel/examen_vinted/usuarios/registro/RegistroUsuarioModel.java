package com.isabel.examen_vinted.usuarios.registro;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.retrofit.ApiClient;
import com.isabel.examen_vinted.retrofit.UsuarioApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroUsuarioModel implements RegistroUsuarioContract.Model{
    @Override
    public void getRegistroUsuarioWS(OnLoginRegistroUsuarioListener onLoginRegistroUsuarioListener, Usuario usuario) {

        UsuarioApi usuarioApi = new UsuarioApi(usuario);

        final Call<Usuario> request = usuarioApi.saveUsuario(usuario);

        request.enqueue(new Callback<Usuario>() {

            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response != null){
                    onLoginRegistroUsuarioListener.onFinished(usuario);
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                t.printStackTrace();
                onLoginRegistroUsuarioListener.onFailure("No se ha podido realizar el registro");
            }
        });
    }
}
