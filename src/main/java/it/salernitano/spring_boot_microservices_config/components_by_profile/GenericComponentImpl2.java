package it.salernitano.spring_boot_microservices_config.components_by_profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class GenericComponentImpl2 implements GenericComponent {
    @Override
    public String genericMethod() {
        return "String for generic method for Spring Profile 'test'";
    }
}
