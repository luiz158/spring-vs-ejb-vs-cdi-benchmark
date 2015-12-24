package psamolysov.demo.restws.resource;

import javax.ejb.Stateless;

@Stateless
public class EJBResourceA {

    public String message() {
        return "A#" + System.currentTimeMillis();
    }
}
