package com.sjzg.ep.controller;

import com.sjzg.ep.bd.ConexionMySQL;
import com.sjzg.ep.model.Producto;
import com.sjzg.ep.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
/**
 *
 * @author 14sim
 */
public class ControllerSalida {
    
    public void editarCantidad(Producto p, Usuario u) throws Exception{
        String query = "CALL cambiarCantidad(?, ?, ?);";
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        CallableStatement ctm = conn.prepareCall(query);
        
        ctm.setInt(1, p.getCantidadInventario());
        ctm.setInt(2, p.getIdProducto());
        ctm.setInt(3, u.getIdUsuario());
        
        ctm.executeUpdate();      
        
        ctm.close();
        connMySQL.close();
    }
    
    public List<Producto> getAll()throws Exception{
        String query = "SELECT * FROM productos WHERE estatus = 1;";
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstm = conn.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        
        List<Producto> productos = new ArrayList<>();
        
        while(rs.next()){
            productos.add(fill(rs));
        }
        
        rs.close();
        pstm.close();
        connMySQL.close();
        
        return productos;
    }
    
    private Producto fill(ResultSet rs) throws Exception{
        Producto p = new Producto();
        
        p.setIdProducto(rs.getInt("idProducto"));
        p.setNombreProducto(rs.getString("nombreProducto"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setCantidadInventario(rs.getInt("cantidadInventario"));
        p.setEstatus(rs.getInt("estatus"));
        p.setFechaAlta(rs.getString("fechaAlta"));
        
        return p;
    }
}
