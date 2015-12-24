package psamolysov.demo.restws.resource;

import javax.ejb.Stateless;

@Stateless
public class EJBResourceB {
    
    public String message() {
        return "B#" + System.currentTimeMillis();
    }
}
