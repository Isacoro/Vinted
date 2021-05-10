package com.isabel.examen_vinted.usuarios.login;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginUsuarioModel implements LoginUsuarioContract.Model {


    @Override
    public void getUsuarioWS(Context context, OnLoginUsuarioListener onLoginUsuarioListener, String email, String password) {
        ApiClient apiClient = new ApiClient(context);

        final Call<Usuario> request = apiClient.getUsuarioLogin(email, password);

        request.enqueue(new Callback<Usuario>() {

           // @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response != null && response.body() != null){
                    Usuario usuario = new Usuario();
                    usuario.setEmail(response.body().getEmail());
                    usuario.setPassword(response.body().getPassword());
                    onLoginUsuarioListener.onFinished(usuario);
            }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                t.printStackTrace();
                onLoginUsuarioListener.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
