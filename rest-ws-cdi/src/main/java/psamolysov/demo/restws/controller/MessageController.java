package psamolysov.demo.restws.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import psamolysov.demo.restws.service.MessageService;

@Path("/")
@ApplicationScoped
public class MessageController {

    @Inject
    private MessageService service;
    
    @GET
    @Path("/message")
    @Produces({"text/plain"})
    public String message() {
        return service.message();
    }
}
