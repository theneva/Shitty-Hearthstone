package fu.bar.config;

import fu.bar.card.Hand;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static fu.bar.util.CardHelper.getRagnaros;

@Path("/")
public class Environment
{
    @GET
    public String hello() {
        return "<form action=\"ananas\" method=\"post\">\n" +
                "  <input type=\"text\" name=\"personName\"/>\n" +
                "  <input type=\"submit\"/>\n" +
                "</form>";
    }

    @POST
    @Path("ananas")
    public String jonas(@FormParam("personName") final String name) {
        return "Hello, " + name + "!";
    }

    @GET
    @Path("json_stuff")
    @Produces("application/json")
    public Response getSomethingAsJson() {

        final Hand hand = new Hand();
        hand.addCard(getRagnaros());

        return Response.ok(hand).build();
    }
}
