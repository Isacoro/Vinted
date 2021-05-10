package com.isabel.examen_vinted.usuarios.topUsuarios;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.retrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopUsuariosModel implements TopUsuariosContract.Model {


    @Override
    public void getUsuariosTopWS(Context context, OnListaUsuariosTopListener onListaUsuariosTopListener) {
        ApiClient apiClient = new ApiClient(context);

        final Call<List<Usuario>> request = apiClient.getUsuariosTop();

        request.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response != null && response.body() != null){
                    onListaUsuariosTopListener.onFinished(new ArrayList<>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                t.printStackTrace();
                onListaUsuariosTopListener.onFailure(t.getLocalizedMessage());
            }
        });

    }
}
