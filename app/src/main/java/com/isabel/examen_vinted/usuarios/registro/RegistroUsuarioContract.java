package com.isabel.examen_vinted.usuarios.registro;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;

public interface RegistroUsuarioContract {

    interface View{
        void successRegistro(Usuario usuario);
        void error(String message);
    }

    interface Presenter{
        void getRegistroUsuario(Usuario usuario);
    }

    interface Model{
        void getRegistroUsuarioWS(OnLoginRegistroUsuarioListener onLoginRegistroUsuarioListener, Usuario usuario);

        interface OnLoginRegistroUsuarioListener{
            void onFinished(Usuario usuario);
            void onFailure(String error);
        }
    }
}
