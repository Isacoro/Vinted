package com.isabel.examen_vinted.beans;

import com.google.gson.annotations.SerializedName;

public class Producto {

    @SerializedName("id")
    private long idProducto;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("descripcion")
    private String descripcion;
    @SerializedName("precio")
    private float precio;
    @SerializedName("puntos")
    private int puntos;
    @SerializedName("categoria")
    private String categoria;
    @SerializedName("url")
    private String url;


    private Usuario usuario;

    public String getUsuario(){
        return usuario.getNombre();
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }


    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio='" + precio + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
