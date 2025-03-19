package com.example.fullstack.resource;

import com.example.fullstack.repository.UserRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("hello-world")
public class AppResource {

    @Path("hello")
    @GET
    @Produces
    public String hello() {
        return "Hello";
    }

}
