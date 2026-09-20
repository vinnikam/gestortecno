package edu.ucentral.vinni;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/genericos")
public class GenericResource {

    @GET
    @Path(("/version"))
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
            summary = "Consultar version del aplicativo ",
            description = "Devuelve el texto del la version del aplicativo y su autor"
    )
    @APIResponse(
            responseCode = "200",
            description = "Información de la version"
    )
    public String version() {
        return "Version 1.0 Aplicacion ejemplo @Autor: Vinni";
    }
}
