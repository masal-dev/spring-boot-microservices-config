package it.salernitano.spring_boot_microservices_config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// This say to Spring that the class is a bean
@Configuration
// This say which group of settings to map
@ConfigurationProperties("db")
public class DbSettings {

    // Spring map the settings that match the name of setting via set methods
    // During the compilation a type check is performed.
    // (Class have to be at least a POJO)
    private String connection;
    private String host;
    private int port;

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
