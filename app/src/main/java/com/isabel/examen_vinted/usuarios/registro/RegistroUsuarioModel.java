package com.isabel.examen_vinted.usuarios.registro;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroUsuarioModel implements RegistroUsuarioContract.Model{
    @Override
    public void getRegistroUsuarioWS(Context context, OnLoginRegistroUsuarioListener onLoginRegistroUsuarioListener, Usuario usuario) {

        ApiClient apiClient = new ApiClient(context);

        final Call<Usuario> request = apiClient.saveUsuarios(usuario);

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
