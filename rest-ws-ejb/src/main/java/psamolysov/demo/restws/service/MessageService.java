package psamolysov.demo.restws.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import psamolysov.demo.restws.resource.EJBResourceA;
import psamolysov.demo.restws.resource.EJBResourceB;

@Stateless
public class MessageService {

    @EJB
    private EJBResourceA aresource;
    
    @EJB
    private EJBResourceB bresource;
    
    public String message() {
        return aresource.message() + bresource.message();
    }
}
