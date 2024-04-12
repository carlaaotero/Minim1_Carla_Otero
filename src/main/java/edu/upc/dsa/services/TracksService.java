package edu.upc.dsa.services;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/*Aquesta classe actua com a servei web RESTful per gestionar pistes de cançons*/
@Api(value = "/tracks", description = "Endpoint to Track Service")
@Path("/tracks")
public class TracksService {

    private TracksManager tm;

    public TracksService() {
        this.tm = TracksManagerImpl.getInstance(); //obté una instància del gestor de pistes
        if (tm.size()==0) {
            //si el gestor de pistes està buit, agrega algunes pistes d'exemple
            this.tm.addTrack("La Barbacoa", "Georgie Dann");
            this.tm.addTrack("Despacito", "Luis Fonsi");
            this.tm.addTrack("Enter Sandman", "Metallica");
        }


    }

    @GET
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



    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Track.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {
        //crea una nova pista amb la info proporcionada
        //si el títol o el cantant no estan especificats retorna 500 (Validation Error)
        if (track.getSinger()==null || track.getTitle()==null)
            return Response.status(500).entity(track).build();
        this.tm.addTrack(track);//agrega la nova pista al gestor de pistes
        return Response.status(201).entity(track).build();
    }

}