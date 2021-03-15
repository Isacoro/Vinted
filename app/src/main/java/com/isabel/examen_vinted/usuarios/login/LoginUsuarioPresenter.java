package com.isabel.examen_vinted.usuarios.login;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.usuarios.login.LoginUsuarioContract;
import com.isabel.examen_vinted.usuarios.login.LoginUsuarioModel;

import java.util.ArrayList;

public class LoginUsuarioPresenter implements LoginUsuarioContract.Presenter {

    private LoginUsuarioModel loginUsuarioModel;
    private LoginUsuarioContract.View vista;

    public LoginUsuarioPresenter(LoginUsuarioContract.View vista){
        this.vista = vista;
        this.loginUsuarioModel = new LoginUsuarioModel();
    }


    @Override
    public void getUsuario(Usuario usuario) {
        loginUsuarioModel.getUsuarioWS(new LoginUsuarioContract.Model.OnLoginUsuarioListener() {
            @Override
            public void onFinished(Usuario usuario) {
                vista.successLogin(usuario);
            }

            @Override
            public void onFailure(String error) {
                vista.error(error);

            }
        }, usuario);

    }
}
