package localTest;

import ch.hevs.cloudio.endpoint.CloudioAttributeConstraintException;
import ch.hevs.cloudio.endpoint.CloudioDynamicNode;
import ch.hevs.cloudio.endpoint.CloudioFactoryConfigurable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class MyNode extends CloudioDynamicNode implements CloudioFactoryConfigurable, Runnable{
    static Logger log = LogManager.getLogger(MyNode.class);

    public MyObject myObject;
    private int max = 100;
    private int step = 1;
    private int delay = 1000;
    private int i = 0;

    public MyNode() {
        super();

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void setConfigurationProperties(Map<String, Object> properties) {
        max = (int)properties.getOrDefault("max", 100);
        step = (int) properties.getOrDefault("step", 1);
        delay = (int) properties.getOrDefault("delay", 1000);
    }

    @Override
    public void run() {
        while (true){
            try {
                log.trace("Value is "+ i);

                this.myObject.myCount.setValue(i);

                i = i + step;
                i %= max;

                Thread.sleep(delay);
            } catch (InterruptedException | CloudioAttributeConstraintException e) {
                e.printStackTrace();
            }
        }
    }
}
