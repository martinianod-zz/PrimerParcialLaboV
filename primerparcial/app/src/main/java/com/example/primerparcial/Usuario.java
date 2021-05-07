package com.example.primerparcial;

public class Usuario {

    private String nombre;
    private String contraseña;
    private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nombre, String contraseña, String tipoUsuario) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String usuario) {
        this.nombre = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
