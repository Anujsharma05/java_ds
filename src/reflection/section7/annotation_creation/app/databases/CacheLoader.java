package reflection.section7.annotation_creation.app.databases;

import reflection.section7.annotation_creation.annotations.InitializerClass;
import reflection.section7.annotation_creation.annotations.InitializerMethod;

@InitializerClass
public class CacheLoader {

    @InitializerMethod
    public void loadCache() {
        System.out.println("Loading data from cache");
    }

    public void reloadCache() {
        System.out.println("Reload cache");
    }
}
