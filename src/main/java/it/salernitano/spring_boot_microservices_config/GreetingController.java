package it.salernitano.spring_boot_microservices_config;

import it.salernitano.spring_boot_microservices_config.components_by_profile.GenericComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController

public class GreetingController {

    // *** PROPERTIES ARE BY DEFAULT IN FILE: resources/application.properties
    // except in the cases listed below in the 'my.greeting' injection

    // I can just inject an hard coded value, like an assignment
    @Value("Static Greeting")
    private String staticMessage;

    // I can use a comma separated list of values as property
    // and have it injected as list
    // (my.list.of.values=One,Two,Three)
    @Value("${my.list.of.values}")
    private List<String> myListOfValues;

    // I can also use #{} to evaluate a property wrote
    // as SPEL (Spring Expression Language)
    // to inject an entire list of properties as object notation
    // in a map object of key-value pairs.
    // (db.values={configurationString: 'http://...', username: 'foo', password: 'pass'})
    @Value("#{${db.values}}")
    private Map<String, String> dbValues;


    // this could be assigned with @Value here or injected with constructor
    private final String greetingMessage;

    // values can also be all managed via a class created and injected as as bean
    // (see DbSettings class)
    //@Autowired -> constructor injection is recommended instead
    private final DbSettings dbSettings;

    private final GenericComponent genericComponent;

    public GreetingController(
            // I can put after colon a value assigned if property is not found
            // either in the application.properties in the jar
            // or the application.properties in the same dir of jar
            // or in a --property=<value> parameter of java -jar command
            @Value("${my.greeting: Default Greeting if property not found}") String greeting,
            DbSettings dbSettings,
            // for this component a different implementation is injected according to profile
            GenericComponent genericComponent) {
        this.greetingMessage = greeting;
        this.dbSettings = dbSettings;
        this.genericComponent = genericComponent;
    }

    @GetMapping("/greeting")
    public String greeting (){
        return greetingMessage + "<br/>"
                + staticMessage + "<br/>"
                + myListOfValues + "<br/>"
                + dbValues + "<br/>"
                + dbSettings.getConnection() + "<br/>"
                + dbSettings.getHost() + "<br/>"
                + dbSettings.getPort() + "<br/>" + "<br/>"
                + genericComponent.genericMethod();
    }
}
