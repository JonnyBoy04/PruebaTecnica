package com.sjzg.ep.rest;

import com.google.gson.Gson;
import com.sjzg.ep.controller.ControllerMovimiento;
import com.sjzg.ep.controller.ControllerProducto;
import com.sjzg.ep.model.MovimientoInventario;
import com.sjzg.ep.model.Producto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author 14sim
 */
@Path("movimiento")
public class RESTMovimiento extends Application{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAll")
    public Response getAll() {
        String out = null;
        ControllerMovimiento cm = null;
        List<MovimientoInventario> movimientoInventarios = null;

        try {
            cm = new ControllerMovimiento();
            movimientoInventarios = cm.getAll();
            out = new Gson().toJson(movimientoInventarios);
        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"exeption\":\"Error interno del servidor.\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
