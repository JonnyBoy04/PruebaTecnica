package com.sjzg.ep.model;

/**
 *
 * @author 14sim
 */
public class RolPermiso {

    private Rol rol;
    private Permiso permiso;

    public RolPermiso(Rol rol, Permiso permiso) {
        this.rol = rol;
        this.permiso = permiso;
    }

    public Rol getRol() {
        return rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

}
