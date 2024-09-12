package it.salernitano.spring_boot_microservices_config.components_by_profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
// Seems that when multiple implementation of same interface are provided,
// if depending on profile, also the one for default profile must be annotated.
@Profile("default")
public class GenericComponentImpl1 implements GenericComponent {
    @Override
    public String genericMethod() {
        return "String for generic method for Spring Profile 'default'";
    }
}
