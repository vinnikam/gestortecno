package edu.ucentral.vinni.infraestructura;

import edu.ucentral.vinni.aplicacion.PortatilServicio;
import edu.ucentral.vinni.dominio.Portatil;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/portatiles")
public class PortatilRecursos {
    @Inject
    PortatilServicio portatilServicio;

    @POST
    @Path("/crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(Portatil portatil){
        this.portatilServicio.crear(portatil);
        return Response.status(Response.Status.CREATED).build();
    }
}
