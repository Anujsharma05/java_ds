package reflection.section7.annotation_creation.app.http;


import reflection.section7.annotation_creation.annotations.InitializerClass;
import reflection.section7.annotation_creation.annotations.InitializerMethod;

@InitializerClass
public class ServiceRegistry {

    @InitializerMethod
    public void registerService() {
        System.out.println("Service successfully registered");
    }
}
