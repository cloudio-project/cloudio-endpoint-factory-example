package localTest;

import ch.hevs.cloudio.endpoint.CloudioAttribute;
import ch.hevs.cloudio.endpoint.CloudioObject;
import ch.hevs.cloudio.endpoint.Measure;

public class MyObject extends CloudioObject {
    @Measure
    public CloudioAttribute<Integer> myCount;
}
