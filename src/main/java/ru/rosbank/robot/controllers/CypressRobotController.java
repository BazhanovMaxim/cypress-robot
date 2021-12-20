package ru.rosbank.robot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rosbank.robot.services.CypressRobotService;

@RestController
@RequestMapping("/click")
@RequiredArgsConstructor
public class CypressRobotController {
    private final CypressRobotService robotService;

    @GetMapping
    public void mouseClick(@RequestParam("x") int x, @RequestParam("y") int y) {
        robotService.mouseMove(x, y);
        robotService.mousePress();
    }
}
