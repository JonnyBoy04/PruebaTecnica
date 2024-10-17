package com.sjzg.ep.model;

/**
 *
 * @author 14sim
 */
public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String descripcion;
    private int cantidadInventario;
    private int estatus;
    private String fechaAlta;
    private String fechaBaja;

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public int getEstatus() {
        return estatus;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadInventario(int catidadInventario) {
        this.cantidadInventario = catidadInventario;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

}
