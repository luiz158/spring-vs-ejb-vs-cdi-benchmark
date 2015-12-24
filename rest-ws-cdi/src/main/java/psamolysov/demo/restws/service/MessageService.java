package psamolysov.demo.restws.service;

import javax.inject.Inject;

import psamolysov.demo.restws.resource.CDIResourceA;
import psamolysov.demo.restws.resource.CDIResourceB;

public class MessageService {

    @Inject
    private CDIResourceA aresource;
    
    @Inject
    private CDIResourceB bresource;
    
    public String message() {
        return aresource.message() + bresource.message(); 
    }
}
