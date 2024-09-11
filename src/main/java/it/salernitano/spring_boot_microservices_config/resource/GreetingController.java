package it.salernitano.spring_boot_microservices_config.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingController {

    private final String greetingMessage;

    public GreetingController(@Value("${my.greeting}") String greeting) {
        this.greetingMessage = greeting;
    }

    @GetMapping("/greeting")
    public String greeting (){
        return greetingMessage;
    }
}
