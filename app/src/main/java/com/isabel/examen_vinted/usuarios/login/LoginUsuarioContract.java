package com.isabel.examen_vinted.usuarios.login;

import com.isabel.examen_vinted.beans.Usuario;

import java.util.ArrayList;

public interface LoginUsuarioContract {

    interface View{
        void successLogin(Usuario usuario);
        void error(String message);
    }

    interface Presenter{
        void getUsuario(Usuario usuario);
    }

    interface Model{
        void getUsuarioWS(OnLoginUsuarioListener onLoginUsuarioListener, Usuario usuario);

        interface OnLoginUsuarioListener{
            void onFinished(Usuario usuario);
            void onFailure(String error);
        }
    }
}
