package com.isabel.examen_vinted.usuarios.topUsuarios;

import com.isabel.examen_vinted.beans.Usuario;


import java.util.ArrayList;
import java.util.HashMap;

public class TopUsuariosModel implements TopUsuariosContract.Model {

    private ArrayList<Usuario> listaArrayUsuarios;
    OnListaUsuariosTopListener onListaUsuariosTopListener;


    @Override
    public void getUsuariosTopWS(OnListaUsuariosTopListener onListaUsuariosTopListener) {

    }
}
