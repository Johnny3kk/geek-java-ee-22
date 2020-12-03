package ru.geekbrains.shop.rest;

import ru.geekbrains.shop.service.ProductRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("v1/shop")
public interface ProductServiceRs {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(ProductRepr productRepr);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductRepr productRepr);

    @DELETE
    @Path("/{id}")
    void delete(Long id);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findById(@PathParam("id") Long id);

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findAll();
}
