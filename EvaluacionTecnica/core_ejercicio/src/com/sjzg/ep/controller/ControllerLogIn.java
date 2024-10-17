package com.sjzg.ep.controller;

import com.sjzg.ep.bd.ConexionMySQL;
import com.sjzg.ep.model.Rol;
import com.sjzg.ep.model.Usuario;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author 14sim
 */
public class ControllerLogIn {
    public Usuario login(String correo, String contrasenia) throws Exception{
        String query = "SELECT U.*, R.nombreRol FROM usuarios AS U INNER JOIN roles AS R ON U.idRol = R.idRol WHERE correo = ? AND contrasenia = ?";
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = null;
        
        pstmt.setString(1, correo);
        pstmt.setString(2, contrasenia);
        
        rs = pstmt.executeQuery();
        
        Usuario u = null;
        
        if(rs.next()){
            u = fill(rs);
        }
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        
        return u;
    }
    
    private Usuario fill(ResultSet rs) throws Exception{
        Usuario u = new Usuario();
        Rol r = new Rol();
        
        r.setIdRol(rs.getInt("idRol"));
        r.setNombreRol(rs.getString("nombreRol"));
        
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNombre(rs.getString("nombre"));
        u.setCorreo(rs.getString("correo"));
        u.setContrasenia(rs.getString("contrasenia"));
        u.setRol(r);
        u.setEstatus(rs.getInt("estatus"));
        
        return u;
    }
}
