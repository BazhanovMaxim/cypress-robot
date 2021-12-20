package ru.rosbank.robot.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rosbank.robot.exceptions.RobotCreateException;

import java.awt.*;

@Configuration
public class ContextConfig {

    /**
     * @return Создаёт Bean Robot'a.
     */
    @Bean
    public Robot getRobot() {
        try {
            return new Robot();
        } catch (AWTException e) {
            throw new RobotCreateException(e);
        }
    }
}
