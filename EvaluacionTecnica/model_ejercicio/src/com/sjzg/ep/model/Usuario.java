package com.sjzg.ep.model;

/**
 *
 * @author 14sim
 */
public class Usuario {

    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasenia;
    private Rol rol;
    private int estatus;

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

}
