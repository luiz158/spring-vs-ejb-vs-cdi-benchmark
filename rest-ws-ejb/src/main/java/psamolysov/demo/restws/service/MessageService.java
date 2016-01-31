package psamolysov.demo.restws.service;

import javax.ejb.*;

import psamolysov.demo.restws.resource.EJBResourceA;
import psamolysov.demo.restws.resource.EJBResourceB;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class MessageService {

    @EJB
    private EJBResourceA aresource;
    
    @EJB
    private EJBResourceB bresource;

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public String message() {
        return aresource.message() + bresource.message();
    }
}
