package com.oneshopproject.oneshopproject;


import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/products")
public class ProductResource {
    private final ProductDAO dao = ProductDAO.getInstance();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return  Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(dao.listAll())
                .build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Product product = dao.get(id);
        if (product != null) {
            return Response.ok(product, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public Response add(@QueryParam("Name") String Name,@QueryParam("Description") String Description,@QueryParam("Url") String Url,@QueryParam("Price") float Price) {
       Product product = new Product(0, Name,Url,Price,Description) ;
        if (dao.add(product)){
            return Response
                    .ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Content-Type", "application/json")
                    .header("Access-Control-Allow-Headers", "origin,Content-Type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity("product :"+product)
                    .build();
        }else {
            return Response
                    .notModified()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin,Content-Type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity("product :"+product)
                    .build();
        }

    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update")
    public Response update(@QueryParam("id") int id, @QueryParam("Name") String Name,@QueryParam("Description") String Description,@QueryParam("Url") String Url,@QueryParam("Price") float Price) {
        Product product = new Product(id, Name,Url,Price,Description) ;
        if (dao.update(product)) {
            return Response.ok()
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, Content-Type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity("product :"+product)
                    .build();
        } else {
            return Response
                    .notModified()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity("Error :"+product)
                    .build();
        }
    }
    @DELETE
    @Path("delete")
    public Response delete(@QueryParam("id") int id) {
        if (dao.delete(id)) {
            return Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity("product id:"+id)
                    .build();
        } else {
            return Response
                    .notModified()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity("product id:"+id)
                    .build();
        }
    }

    @OPTIONS
    @Path("{path : .*}")
    public Response options() {
        return Response.ok("")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }

}