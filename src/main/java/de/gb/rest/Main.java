package de.gb.rest;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.injectors.SetterInjection;

public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp";

    public static void main(String[] args) throws IOException {

        HttpServer server = startServer();

        System.out.println(String.format("Jersey app started with WADL available at %s/application.wadl", BASE_URI));
        System.out.println("Hit enter to stop it...");

        System.in.read();
        server.stop();
    }

    private static MutablePicoContainer assembleApplicationComponents() {
        MutablePicoContainer container = new DefaultPicoContainer(new SetterInjection());
        container.addComponent(GotItResource.class);
        container.addComponent(GotItService.class);
        container.addComponent(MapDbStore.class);

        return container;
    }

    public static HttpServer startServer() {
        MutablePicoContainer container = assembleApplicationComponents();

        // create a resource config that scans for JAX-RS resources and providers
        // in de.gb.rest package
        ResourceConfig rc = new ResourceConfig()
                .register(container.getComponent(GotItResource.class));

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
}

