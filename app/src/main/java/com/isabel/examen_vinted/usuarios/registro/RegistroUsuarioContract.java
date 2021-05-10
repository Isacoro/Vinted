package com.isabel.examen_vinted.usuarios.registro;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;

public interface RegistroUsuarioContract {

    interface View{
        void succesRegistro(Usuario usuario);
        void error(String message);
    }

    interface Presenter{
        void getRegistroUsuario(Context context);
    }

    interface Model{
        void getRegistroUsuarioWS(Context context, OnLoginRegistroUsuarioListener onLoginRegistroUsuarioListener, Usuario usuario);

        interface OnLoginRegistroUsuarioListener{
            void onFinished(Usuario usuario);
            void onFailure(String error);
        }
    }
}
