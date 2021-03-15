package com.isabel.examen_vinted.usuarios.topUsuarios;

import com.isabel.examen_vinted.beans.Usuario;

import java.util.ArrayList;

public class TopUsuariosPresenter implements TopUsuariosContract.Presenter {

    private TopUsuariosModel topUsuariosModel;
    private TopUsuariosContract.View vista;

    public TopUsuariosPresenter (TopUsuariosContract.View vista){
        this.vista = vista;
        topUsuariosModel = new TopUsuariosModel();
    }


    @Override
    public void getUsuariosTop() {
        topUsuariosModel.getUsuariosTopWS(new TopUsuariosContract.Model.OnListaUsuariosTopListener() {
            @Override
            public void onFinished(ArrayList<Usuario> usuarios) {
                vista.success(usuarios);
            }

            @Override
            public void onFailure(String error) {
                vista.error(error);
            }
        });
    }
}
