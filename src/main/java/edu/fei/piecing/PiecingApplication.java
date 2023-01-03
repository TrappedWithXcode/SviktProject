package edu.fei.piecing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication

public class PiecingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiecingApplication.class, args);
    }

}
