package edu.upc.dsa;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jersey.listing.ApiListingResourceJSON;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Es defineix la classe Main
 *
 */
public class Main {


    // Es defineix la variable estàtica BASE_URI que representa la direcció base del servidor HTTP Grizzly
    public static final String BASE_URI = "http://localhost:8080/dsaApp/";


    /**
     * Inicia el servidor HTTP Grizzly exposant els recursos JAX-RS definits en aquesta aplicació
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.dsa package
        final ResourceConfig rc = new ResourceConfig().packages("edu.upc.dsa.services");

        rc.register(io.swagger.jaxrs.listing.ApiListingResource.class);
        rc.register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();

        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/dsaApp");
        beanConfig.setContact("support@example.com");
        beanConfig.setDescription("REST API for Tracks Manager");
        beanConfig.setLicenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html");
        beanConfig.setResourcePackage("edu.upc.dsa.services");
        beanConfig.setTermsOfServiceUrl("http://www.example.com/resources/eula");
        beanConfig.setTitle("REST API");
        beanConfig.setVersion("1.0.0");
        beanConfig.setScan(true);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }


    /**
     * Mètode Main --> és el mètode d'entrada principal de l'aplicació.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();

//Es crea un "StaticHttpHandler" que maneja les sol·licituds estàtiques i se li assigna la ruta /public/.
//Aixo significa que les sol·licituds que coincideixin amb aquesta ruta seràn manejades pel StaticHttpHandler,
// que servirà arxius estàtics des del directori públic.
        StaticHttpHandler staticHttpHandler = new StaticHttpHandler("./public/");

        server.getServerConfiguration().addHttpHandler(staticHttpHandler, "/");

//S'imprimeix un missatge en pantalla indicant que l'aplicació Jersey s'ha iniciat correctament, junt amb
//l'URL on es pot accedir a la documentació WADL de la API: http://localhost:8080/swagger/#/
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));

        System.in.read(); //espera que es presioni enter
        server.stop();
    }
}

