package com.isabel.examen_vinted.usuarios.login;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;

import java.util.ArrayList;

public interface LoginUsuarioContract {

    interface View{
        void successLogin(Usuario loginUsuario);
        void error(String message);
    }

    interface Presenter{
        void getUsuarioLogin(Context context, String email, String password);
    }

    interface Model{
        void getUsuarioWS(Context context, OnLoginUsuarioListener onLoginUsuarioListener, String email, String password);

        interface OnLoginUsuarioListener{
            void onFinished(Usuario usuario);
            void onFailure(String error);
        }
    }
}
