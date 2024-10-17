package com.sjzg.ep.model;

/**
 *
 * @author 14sim
 */
public class MovimientoInventario {

    private int idMovimiento;
    private Producto producto;
    private Usuario usuario;
    private String tipoMovimiento;
    private int cantidad;
    private String fechaMovimiento;

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

}
