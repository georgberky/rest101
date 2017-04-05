package de.gb.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class GotItResourceTest {

    private static final String GOTIT_JSON = "{\n" + "  \"message\": \"Got it!\"\n" + "}";

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void plainText() {
        String responseMsg = target.path("/gotit")
                .request()
                .accept(MediaType.TEXT_PLAIN)
                .get(String.class);

        assertThat(responseMsg, equalTo("Got it!"));
    }

    @Test
    public void json() {
        String responseMsg = target.path("/gotit")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        assertThat(responseMsg, equalTo(GOTIT_JSON));
    }

    @Test
    public void putAndGetJson() throws Exception {
        target.path("/gotit/1")
                .request()
                .put(Entity.entity(GOTIT_JSON, MediaType.APPLICATION_JSON_TYPE), String.class);

        String response = target.path("/gotit/1")
                .request()
                .get(String.class);


        assertThat(response, equalTo(GOTIT_JSON));
    }
}
