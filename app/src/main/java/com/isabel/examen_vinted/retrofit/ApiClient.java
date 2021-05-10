package com.isabel.examen_vinted.retrofit;

import android.content.Context;

import com.isabel.examen_vinted.BuildConfig;
import com.isabel.examen_vinted.beans.Producto;
import com.isabel.examen_vinted.beans.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private Retrofit retrofit;
    private Context context;

    public ApiClient(Context context){
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //Todos los productos
    public Call<List<Producto>> getProductos(){
        ProductoApiInterface service = retrofit.create(ProductoApiInterface.class);
        return service.getProductos();
    }

    //Productos top
    public Call<List<Producto>> getProductosTop(){
        ProductoApiInterface service = retrofit.create(ProductoApiInterface.class);
        return  service.getProductosTop();
    }

    //Productos por categoria
    public Call<List<Producto>> getProductosCategoria(String categoria){
        ProductoApiInterface service = retrofit.create(ProductoApiInterface.class);
        return service.getProductosCategoria(categoria);
    }

    //Añadir producto
    public Call<Producto> saveProducto(Producto producto){
        ProductoApiInterface service = retrofit.create(ProductoApiInterface.class);
        return  service.saveProducto(producto);
    }

    //Todos los usuarios
    public Call<List<Usuario>> getUsuarios(){
        UsuarioApiInterface service = retrofit.create(UsuarioApiInterface.class);
        return service.getUsuarios();
    }

    //Registro usuario
    public Call<Usuario> saveUsuarios(String nombre, String email, String password){
        UsuarioApiInterface service = retrofit.create(UsuarioApiInterface.class);
        return service.saveUsuario(nombre, email, password);
    }

    //Login usuario
    public Call<Usuario> getUsuarioLogin(String email, String password){
        UsuarioApiInterface service = retrofit.create(UsuarioApiInterface.class);
        return service.getUsuarioLogin(email, password);
    }

    //Usuarios top
    public Call<List<Usuario>> getUsuariosTop(){
        UsuarioApiInterface service = retrofit.create(UsuarioApiInterface.class);
        return  service.getUsuariosTop();
    }
}
