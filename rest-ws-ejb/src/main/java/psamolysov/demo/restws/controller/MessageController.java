package psamolysov.demo.restws.controller;

import javax.ejb.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import psamolysov.demo.restws.service.MessageService;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Path("/")
public class MessageController {

    @EJB
    private MessageService service;
    
    @GET
    @Path("/message")
    @Produces({"text/plain"})
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public String message() {
        return service.message();
    }
}
