package edu.upc.dsa.services;


import edu.upc.dsa.VuelosManager;
import edu.upc.dsa.VuelosManagerImpl;
import edu.upc.dsa.models.Dron;
import edu.upc.dsa.models.Pilot;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/*Aquesta classe actua com a servei web RESTful per gestionar drons*/
@Api(value = "/drons", description = "Endpoint to Drons Service")
@Path("/tracks")
public class VuelosService {

    private VuelosManager tm;

    public VuelosService() {
        this.tm = VuelosManagerImpl.getInstance(); //obté una instància del VuelosManager
    }


    @POST
    @ApiOperation(value = "Afegir un Dron", notes = "new Dron")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response afegirDron(Dron dron) {
        //si tota la info no es correcta retorna 500 (Validation Error)
        if (dron.getIdDron()==null || dron.getNomDron()==null || dron.getModel()==null || dron.getFabricant() == null)
            return Response.status(500).entity(dron).build();
        VuelosManager man = VuelosManagerImpl.getInstance();
        man.afegirDron(dron.getIdDron(), dron.getNomDron(), dron.getFabricant(), dron.getModel(), dron.getHoresDron());//agrega el nou dron al gestor de vols
        return Response.status(201).entity(dron).build();
    }
    /*@POST
    @ApiOperation(value = "Afegir un Pilot", notes = "new Pilot")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Pilot.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response afegirPilot(Pilot pilot) {
        //si tota la info no es correcta retorna 500 (Validation Error)
        if (pilot.getIdPilot()==null || pilot.getNomPilot()==null || pilot.getCognomPilot()==null)
            return Response.status(500).entity(pilot).build();
        VuelosManager man = VuelosManagerImpl.getInstance();
        man.afegirPilot(pilot.getIdPilot(), pilot.getNomPilot(), pilot.getCognomPilot(), pilot.getHoresPilot());//agrega el nou pilot al gestor de vols
        return Response.status(201).entity(pilot).build();
    }*/








/* @GET
    @ApiOperation(value = "get all Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {
        //obté totes les pistes de cançons del gestor de pistes
        List<Track> tracks = this.tm.findAll();
        //Crea un objecte d'entitat genèrica per envolver la llista de pistes
        GenericEntity<List<Track>> entity = new GenericEntity<List<Track>>(tracks) {};
        //retorna una resposa amb l'estat 201 (successful) i la llista de pistes
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id); //obté una pista de cançó pel seu ID
        //si la pista no es troba, retorna una resposta 404 (Track not found)
        if (t == null) return Response.status(404).build();
        //si es troba, doncs retorna 201 (successful)
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);//elimina una pista de cançó pel seu ID
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.tm.updateTrack(track);//actualitza una pista amb la informació proporcionada a l'objecte Track

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }

*/

}
