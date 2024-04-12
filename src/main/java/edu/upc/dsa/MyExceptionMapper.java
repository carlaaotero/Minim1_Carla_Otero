package edu.upc.dsa;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.glassfish.grizzly.utils.Exceptions;

//Classe que implementa l'interfaz "ExceptionMapper". Aquesta classe s'utilitza per
//manejar excepcions que ocorren durant l'execució de l'API REST i convertir-les
//en respostes HTTP apropiades.

@Provider
public class MyExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception ex) {
        return Response.status(500).entity(Exceptions.getStackTraceAsString(ex)).type("text/plain")
                .build();
    }
}