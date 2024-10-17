package com.sjzg.ep.controller;

import com.sjzg.ep.bd.ConexionMySQL;
import com.sjzg.ep.model.Producto;
import com.sjzg.ep.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
/**
 *
 * @author 14sim
 */
public class ControllerProducto {
    
    public int insertarProducto(Producto p, Usuario u) throws Exception{
        String query = "CALL insertarProducto(?, ?, ?, ?, ?, ?);";
        
        int idProducto = -1;
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        CallableStatement ctm = conn.prepareCall(query);
        
        ctm.setString(1, p.getNombreProducto());
        ctm.setString(2, p.getDescripcion());
        ctm.setInt(3, p.getCantidadInventario());
        ctm.setInt(4, p.getEstatus());
        ctm.setInt(5, u.getIdUsuario());
        
        ctm.registerOutParameter(6, Types.INTEGER);        
        
        ctm.executeUpdate();
        
        idProducto = ctm.getInt(6);
        p.setIdProducto(idProducto);
        
        ctm.close();
        connMySQL.close();
        
        return idProducto;
    }
    
    public int editarCantidad(Producto p) throws Exception{
        String query = "UPDATE productos set cantidadInventario = ? WHERE idProducto=?;";
        ConexionMySQL connMySQL = new ConexionMySQL();

        Connection conn = connMySQL.open();

        try (CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1,p.getCantidadInventario());
            cs.setInt(2, p.getIdProducto());
            
            cs.execute();
        }
        return p.getIdProducto();
    }
    
    public void borrarProducto(int estatus, int id) throws Exception {
        String query = "UPDATE productos SET estatus = "+estatus+" WHERE idProducto = "+id;
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        Statement stm = conn.createStatement();
        stm.executeUpdate(query);
        stm.close();
        connMySQL.close();
    }
    
    public List<Producto> getAll()throws Exception{
        String query = "SELECT * FROM productos;";
        
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
