import ch.hevs.cloudio.endpoint.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class myEndpoint implements CloudioEndpointListener{
    static Logger log = LogManager.getLogger(myEndpoint.class);
    CloudioEndpoint endpoint;

    public myEndpoint() {
        try{
            endpoint = new CloudioEndpoint("example");
            endpoint.addEndpointListener(this);
            endpoint.addNodesFromResource("demoNodes.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        myEndpoint ep = new myEndpoint();
    }

    @Override
    public void endpointIsOnline(CloudioEndpoint endpoint) {
        log.info("Endpoint is online");
    }

    @Override
    public void endpointIsOffline(CloudioEndpoint endpoint) {
        log.info("Endpoint is offline");
    }
}