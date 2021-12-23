package ru.rosbank.robot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rosbank.robot.services.CypressRobotService;

import java.awt.event.KeyEvent;

@RestController
@RequestMapping("/click")
@RequiredArgsConstructor
public class CypressRobotController {
    private final CypressRobotService robotService;

    @GetMapping
    public void textInputWithPressEnter(@RequestParam("x") int x, @RequestParam("y") int y, @RequestParam("text") String text) {
        robotService.mouseMove(x, y);
        robotService.mousePress();
        robotService.sendKeys(text);
        robotService.keyPress(KeyEvent.VK_ENTER);
    }
}
