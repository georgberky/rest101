package de.gb.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
    public Response readJson(String payload) {
        GotIt gotIt = gson.fromJson(payload, GotIt.class);

        return Response.ok(gotIt.getMessage()).build();
    }

    public void setService(Service service) {
        this.service = service;
    }
}
