package psamolysov.demo.restws.resource;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CDIResourceB {

    public String message() {
        return "B#" + System.currentTimeMillis();
    }
}
