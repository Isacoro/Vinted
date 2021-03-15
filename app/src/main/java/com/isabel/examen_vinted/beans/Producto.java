package com.isabel.examen_vinted.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Producto {

    private static final String ID = "idProducto";
    private static final String NOMBRE = "nombre";
    private static final String PRECIO = "precio";
    private static final String DESCRIPCION = "descripcion";
    private static final String CATEGORIA = "idCategoria";
    private static final String PUNTOS = "puntos";
    private static final String URL = "url";

    private int idProducto;
    private String nombre;
    private String descripcion;
    private String imagen;
    private int precio;
    private int idCategoria;
    private int puntos;
    private String url;

    public Producto(){

    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static ArrayList<Producto> getArrayListFromJSon(JSONArray listaProductos){
        ArrayList<Producto> lista = null;
        try {
            if(listaProductos!=null && listaProductos.length() > 0 ){
                lista = new ArrayList<Producto>();
            }
            for (int i = 0; i < listaProductos.length(); i++) {
                JSONObject json_data = listaProductos.getJSONObject(i);

                Producto producto = new Producto();

                producto.setIdProducto(json_data.getInt(ID));
                producto.setNombre(json_data.getString(NOMBRE));
                producto.setPrecio(json_data.getInt(PRECIO));
                producto.setDescripcion(json_data.getString(DESCRIPCION));
                producto.setIdCategoria(json_data.getInt(CATEGORIA));
                producto.setPuntos(json_data.getInt(PUNTOS));
                producto.setUrl(json_data.getString(URL));

                lista.add(producto);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
