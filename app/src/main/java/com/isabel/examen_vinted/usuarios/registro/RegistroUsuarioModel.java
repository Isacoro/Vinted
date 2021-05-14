package com.isabel.examen_vinted.usuarios.registro;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.beans.UsuarioDTO;
import com.isabel.examen_vinted.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroUsuarioModel implements RegistroUsuarioContract.Model{

    @Override
    public void addUsuarioWS(Context context, OnRegistroUsuarioListener onRegistroUsuarioListener, UsuarioDTO usuarioDTO) {

        ApiClient apiClient = new ApiClient(context);

        final Call<Usuario> request = apiClient.addUsuario(usuarioDTO);

        request.enqueue(new Callback<Usuario>() {

            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    onRegistroUsuarioListener.onFinished(response.body());

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                t.printStackTrace();
                onRegistroUsuarioListener.onFailure("No se ha podido realizar el registro");
            }
        });
    }
}
