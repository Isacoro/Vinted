package com.isabel.examen_vinted.usuarios.registro;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;

public class RegistroUsuarioModel implements RegistroUsuarioContract.Model{
    @Override
    public void getRegistroUsuarioWS(Context context, OnLoginRegistroUsuarioListener onLoginRegistroUsuarioListener, Usuario usuario) {

    }

//    @Override
//    public void getRegistroUsuarioWS(Context context, OnLoginRegistroUsuarioListener onLoginRegistroUsuarioListener, Usuario usuario) {
//
//        UsuarioApi usuarioApi = new UsuarioApi(context);
//
//        Usuario nuevoUsuario = new Usuario();
//        final Call<Usuario> request = ApiClient.saveUsuarios(nuevoUsuario.getNombre(), nuevoUsuario.getEmail(), nuevoUsuario.getPassword());
//
//        request.enqueue(new Callback<Usuario>() {
//            @Override
//            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
//                if(response != null){
//                    onLoginRegistroUsuarioListener.onFinished(nuevoUsuario);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Usuario> call, Throwable t) {
//                t.printStackTrace();
//                onLoginRegistroUsuarioListener.onFailure("No se ha podido realizar el registro");
//            }
//        });
//    }
}
