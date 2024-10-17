package com.sjzg.ep.model;

/**
 *
 * @author 14sim
 */
public class Permiso {

    private int idPermiso;
    private String nombrePermiso;

    public Permiso(int idPermiso, String nombrePermiso) {
        this.idPermiso = idPermiso;
        this.nombrePermiso = nombrePermiso;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

}
