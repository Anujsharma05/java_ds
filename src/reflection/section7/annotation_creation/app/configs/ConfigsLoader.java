package reflection.section7.annotation_creation.app.configs;

import reflection.section7.annotation_creation.annotations.InitializerClass;
import reflection.section7.annotation_creation.annotations.InitializerMethod;

@InitializerClass
public class ConfigsLoader {

    @InitializerMethod
    public void loadAllConfigs() {
        System.out.println("Loading all configuration files");
    }
}
