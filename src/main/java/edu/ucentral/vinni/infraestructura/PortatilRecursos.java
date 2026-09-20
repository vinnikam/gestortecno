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
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/portatiles")
public class PortatilRecursos {
    @Inject
    PortatilServicio portatilServicio;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Crear un nuevo equipo tecnologico",
            description = "Registra el los datos:  serial, marca y megas  de memoria(int)"
    )
    @APIResponse(
            responseCode = "201",
            description = "Equipo Tecno creado"
    )
    @APIResponse(
            responseCode = "400",
            description = "Datos de entrada invalidos"
    )
    public Response crear(Portatil portatil){
        this.portatilServicio.crear(portatil);
        return Response.status(Response.Status.CREATED).build();
    }
}
