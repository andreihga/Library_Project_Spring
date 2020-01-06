package sda.library.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("sda.library.*")
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class);
    }
}