package psamolysov.demo.restws.benchmark;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
public class RestImplementationsBenchmark {

    @Param("localhost")
    private String server;

    @Param("9080")
    private int port;
    
    @Param("/message")
    private String path;
    
    @State(Scope.Thread)
    public static class BenchmarkContext {
        private static final String MAIN_URL_FMT = 
                "http://{host}:{port}/rest-ws-{implementation}/api";
        
        @Param({"ejb", "cdi", "spring"})
        private String implementation;        
        
        private WebTarget target;
        
        @Setup
        public void initClient() {
            target = ClientBuilder.newClient().target(MAIN_URL_FMT);
        }
    }
    
    @Benchmark
    public void messages(BenchmarkContext ctx) {
        ctx.target.resolveTemplate("host", server)
                  .resolveTemplate("port", port)
                  .resolveTemplate("implementation", ctx.implementation)
                  .path(path)
                  .request()
                  .get(String.class);
    }
}
