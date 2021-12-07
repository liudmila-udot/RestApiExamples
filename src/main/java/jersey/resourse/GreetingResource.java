package jersey.resourse;

import common.model.Greeting;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

@Path("/greeting")
public class GreetingResource {

    private static final String template = "Hello, %s From Jersey!";
    private final AtomicLong counter = new AtomicLong();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting greeting(@QueryParam("name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGreeting(Greeting greeting) {
        System.out.println(greeting);
        return Response.ok("Test post method Jersey", MediaType.APPLICATION_JSON).build();
    }
}
