package ru.rosbank.robot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RobotApplication {

    public static void main(String[] args) {
        var builder = new SpringApplicationBuilder(RobotApplication.class);
        builder.headless(false).run(args);
    }
}
