package com.sjzg.ep.controller;

import com.sjzg.ep.bd.ConexionMySQL;
import com.sjzg.ep.model.MovimientoInventario;
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
public class ControllerMovimiento {
    public List<MovimientoInventario> getAll()throws Exception{
        String query = "SELECT * FROM vHistorialMovimiento;";
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstm = conn.prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        
        List<MovimientoInventario> movimientoInventarios = new ArrayList<>();
        
        while(rs.next()){
            movimientoInventarios.add(fill(rs));
        }
        
        rs.close();
        pstm.close();
        connMySQL.close();
        
        return movimientoInventarios;
    }
    
    private MovimientoInventario fill(ResultSet rs) throws Exception{
        Producto p = new Producto();
        Usuario u = new Usuario();
        MovimientoInventario mi = new MovimientoInventario();
        
        p.setIdProducto(rs.getInt("idProducto"));
        p.setNombreProducto(rs.getString("nombreProducto"));
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNombre(rs.getString("nombre"));
        mi.setIdMovimiento(rs.getInt("idMovimiento"));
        mi.setTipoMovimiento(rs.getString("tipoMovimiento"));
        mi.setCantidad(rs.getInt("cantidad"));
        mi.setFechaMovimiento(rs.getString("fechaMovimiento"));
        mi.setProducto(p);
        mi.setUsuario(u);
        
        return mi;
    }
}
