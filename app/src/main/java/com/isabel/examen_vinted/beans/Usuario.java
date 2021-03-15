package com.isabel.examen_vinted.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {

    private static final String ID = "idUsuario";
    private static final String NOMBRE = "nombre";
    private static final String APELLIDOS = "apellidos";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String CIUDAD = "ciudad";
    private static final String VENTAS = "ventas";
    private static final String PUNTOS = "puntos";


    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String ciudad;
    private int ventas;
    private int puntos;


    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public static ArrayList<Usuario> getArrayListFromJSon(JSONArray listaUsuarios){
        ArrayList<Usuario> lista = null;
        try {
            if(listaUsuarios!=null && listaUsuarios.length() > 0 ){
                lista = new ArrayList<Usuario>();
            }
            for (int i = 0; i < listaUsuarios.length(); i++) {
                JSONObject json_data = listaUsuarios.getJSONObject(i);

                Usuario usuario = new Usuario();

                usuario.setId(json_data.getInt(ID));
                usuario.setNombre(json_data.getString(NOMBRE));
                usuario.setApellidos(json_data.getString(APELLIDOS));
                usuario.setEmail(json_data.getString(EMAIL));
                usuario.setPassword(json_data.getString(PASSWORD));
                usuario.setCiudad(json_data.getString(CIUDAD));
                usuario.setVentas(json_data.getInt(VENTAS));
                usuario.setPuntos(json_data.getInt(PUNTOS));

                lista.add(usuario);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
