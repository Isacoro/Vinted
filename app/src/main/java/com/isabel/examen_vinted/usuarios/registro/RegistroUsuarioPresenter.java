package com.isabel.examen_vinted.usuarios.registro;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.beans.UsuarioDTO;

public class RegistroUsuarioPresenter implements RegistroUsuarioContract.Presenter {

    private RegistroUsuarioModel registroUsuarioModel;
    private RegistroUsuarioContract.View vista;
    private UsuarioDTO usuarioDTO;

    public RegistroUsuarioPresenter(RegistroUsuarioContract.View vista){
        this.vista = vista;
        registroUsuarioModel = new RegistroUsuarioModel();
        usuarioDTO = new UsuarioDTO();
    }


    @Override
    public void addUsuario(Context context, UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
        registroUsuarioModel.addUsuarioWS(context, new RegistroUsuarioContract.Model.OnRegistroUsuarioListener(){

            @Override
            public void onFinished(Usuario nuevoUsuario) {
                vista.successRegistro(nuevoUsuario);
            }

            @Override
            public void onFailure(String error) {
                vista.error(error);
            }
        },usuarioDTO);
    }
}
