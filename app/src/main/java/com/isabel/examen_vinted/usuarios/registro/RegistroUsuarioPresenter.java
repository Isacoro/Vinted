package com.isabel.examen_vinted.usuarios.registro;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;

public class RegistroUsuarioPresenter implements RegistroUsuarioContract.Presenter {

    private RegistroUsuarioModel registroUsuarioModel;
    private RegistroUsuarioContract.View vista;

    public RegistroUsuarioPresenter(RegistroUsuarioContract.View vista){
        this.vista = vista;
        this.registroUsuarioModel = new RegistroUsuarioModel();
    }


    @Override
    public void getRegistroUsuario(Context context, Usuario usuario) {
        registroUsuarioModel.getRegistroUsuarioWS(context, new RegistroUsuarioContract.Model.OnLoginRegistroUsuarioListener(){

            @Override
            public void onFinished(Usuario usuario) {
                vista.successRegistro(usuario);
            }

            @Override
            public void onFailure(String error) {
                vista.error(error);
            }
        },usuario);
    }
}
