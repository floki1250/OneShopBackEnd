package com.oneshopproject.oneshopproject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/User")
public class UserResource {
    private final ProductDAO dao = ProductDAO.getInstance();
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("User") String User,@QueryParam("Password") String Password) {
        User user = dao.getUser(User , Password);
        if (user != null) {
            return Response.ok(user, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
