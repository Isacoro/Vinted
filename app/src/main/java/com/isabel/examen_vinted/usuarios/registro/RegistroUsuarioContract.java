package com.isabel.examen_vinted.usuarios.registro;

import android.content.Context;

import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.beans.UsuarioDTO;

public interface RegistroUsuarioContract {

    interface View{
        void successRegistro(Usuario nuevoUsuario);
        void error(String message);
    }

    interface Presenter{
        void addUsuario(Context context, UsuarioDTO usuarioDTO);
    }

    interface Model{
        void addUsuarioWS(Context context, OnRegistroUsuarioListener onRegistroUsuarioListener, UsuarioDTO usuarioDTO);

        interface OnRegistroUsuarioListener{
            void onFinished(Usuario nuevoUsuario);
            void onFailure(String error);
        }
    }
}
