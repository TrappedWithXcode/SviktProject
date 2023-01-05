package edu.fei.piecing; ////Grouping related classes (somethink like folder in a file directory), This is user-defined package...

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;               // In this statements we imported from external librares framework

@SpringBootApplication

public class PiecingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiecingApplication.class, args);
    }

}
//Spring Boot @SpringBootApplication annotation is used to mark a configuration class that declares one or more @Bean
// methods and also triggers auto-configuration and component scanning.