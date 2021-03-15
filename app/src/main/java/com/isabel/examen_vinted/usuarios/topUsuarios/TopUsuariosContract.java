package com.isabel.examen_vinted.usuarios.topUsuarios;

import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.beans.Usuario;
import com.isabel.examen_vinted.productos.topProductos.TopProductoContract;

import java.util.ArrayList;

public interface TopUsuariosContract {

    interface View{
        void success(ArrayList<Usuario> usuarios);
        void error(String message);
    }

    interface Presenter{
        void getUsuariosTop();
    }

    interface Model{
        void getUsuariosTopWS(OnListaUsuariosTopListener onListaUsuariosTopListener);

        interface OnListaUsuariosTopListener{
            void onFinished(ArrayList<Usuario> usuarios);
            void onFailure(String error);
        }
    }
}
