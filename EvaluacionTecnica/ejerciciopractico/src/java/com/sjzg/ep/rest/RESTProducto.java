package com.sjzg.ep.rest;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.sjzg.ep.controller.ControllerProducto;
import com.sjzg.ep.model.Producto;
import com.sjzg.ep.model.Usuario;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
/**
 *
 * @author 14sim
 */
@Path("producto")
public class RESTProducto extends Application{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAll")
    public Response getAll() {
        String out = null;
        ControllerProducto cm = null;
        List<Producto> productos = null;

        try {
            cm = new ControllerProducto();
            productos = cm.getAll();
            out = new Gson().toJson(productos);
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"exeption\":\"Error interno del servidor.\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("guardar")
    public Response guardar(@FormParam("datosProducto") @DefaultValue("") String datosProducto,
            @FormParam("datosUsuario") @DefaultValue("") String datosUsuario){
        
        String out = null;
        Gson gson = new Gson();
        Producto prod = null;
        Usuario usu = null;
        ControllerProducto cp = new ControllerProducto();
        
        try{
            usu = gson.fromJson(datosUsuario, Usuario.class);
            if ("Administrador".equals(usu.getRol().getNombreRol())){
                prod = gson.fromJson(datosProducto, Producto.class);
                cp.insertarProducto(prod, usu);
                out = gson.toJson(prod);
            } else {
                out = """
                      {"error":"No tiene permisos para realizar esta operación."}
                      """;
            }
        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            out = """
                {"exception":"Formato JSON de datos incorrectos."}
                """;
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"exception":"%s"}
                  """;
            out = String.format(out, e.toString());
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("editarCantidad")
    public Response editarCantidad(@FormParam("datosProducto") @DefaultValue("") String datosProducto,
            @FormParam("datosUsuario") @DefaultValue("") String datosUsuario){
        
        String out = null;
        Gson gson = new Gson();
        Producto prod = null;
        Usuario usu = null;
        ControllerProducto cp = new ControllerProducto();
        
        try{
            usu = gson.fromJson(datosUsuario, Usuario.class);
            if ("Administrador".equals(usu.getRol().getNombreRol())){
                prod = gson.fromJson(datosProducto, Producto.class);
                cp.editarCantidad(prod);
                out = gson.toJson(prod);
            } else {
                out = """
                      {"error":"No tiene permisos para realizar esta operación."}
                      """;
            }
        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            out = """
                {"exception":"Formato JSON de datos incorrectos."}
                """;
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"exception":"%s"}
                  """;
            out = String.format(out, e.toString());
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("delete")
    public Response delete(@FormParam("datosProductos") @DefaultValue("") String datosProductos,
            @FormParam("datosUsuario") @DefaultValue("") String datosUsuario){
        String out = null;
        Gson gson = new Gson();
        Producto prod = null;
        Usuario usu = null;
        ControllerProducto cp = new ControllerProducto();
   
        try{
            usu = gson.fromJson(datosUsuario, Usuario.class);
            if ("Administrador".equals(usu.getRol().getNombreRol())){
                prod = gson.fromJson(datosProductos, Producto.class);
                cp.borrarProducto(prod.getEstatus() ,prod.getIdProducto());
                out = gson.toJson(prod);
            } else {
                out = """
                      {"error":"No tiene permisos para realizar esta operación."}
                      """;
            }
        } catch (JsonParseException jpe) {
            jpe.printStackTrace();
            out = """
                {"exception":"Formato JSON de datos incorrectos."}
                """;
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"exception":"%s"}
                  """;
            out = String.format(out, e.toString());
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
