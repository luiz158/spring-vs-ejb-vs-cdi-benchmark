package psamolysov.demo.restws.resource;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CDIResourceA {

    public String message() {
        return "A#" + System.currentTimeMillis();
    }
}
