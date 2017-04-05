package de.gb.rest;

import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("gotit")
public class GotItResource {

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private Service service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return service.loadPlain();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        GotIt response = new GotIt("Got it!");
        return gson.toJson(response);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Response readJson(@PathParam("id") int id, String payload) {
        GotIt gotIt = gson.fromJson(payload, GotIt.class);

        service.saveMyGotIt(gotIt);

        return Response.ok(gotIt.getMessage()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response readJson(@PathParam("id") int id) {
        return service.getMyGotIt(id)
                .map(gotIt1 -> Response.ok(gson.toJson(gotIt1)).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());

    }

    public void setService(Service service) {
        this.service = service;
    }
}
