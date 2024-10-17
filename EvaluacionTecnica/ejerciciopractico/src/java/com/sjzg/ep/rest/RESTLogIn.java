package com.sjzg.ep.rest;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.sjzg.ep.controller.ControllerLogIn;
import com.sjzg.ep.model.Usuario;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
/**
 *
 * @author 14sim
 */
@Path("log")
public class RESTLogIn extends Application{
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("in")
    public Response logIn(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        Usuario usu = gson.fromJson(datos, Usuario.class);
        String out = null;
        ControllerLogIn cl = new ControllerLogIn();
        
        try {
            if (cl.login(usu.getCorreo(), usu.getContrasenia()) != null){
                out = new Gson().toJson(cl.login(usu.getCorreo(), usu.getContrasenia()));
            }else{
                out = """
                      {"error":"Datos de Credencial Incorrectos"}
                      """;
            }
        } catch (Exception e) {
            e.printStackTrace();
            out = """
                  {"excepcion":"%s"}
                  """;
            out = String.format(out, e.toString());
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
