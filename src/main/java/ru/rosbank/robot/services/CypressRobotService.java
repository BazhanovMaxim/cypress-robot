package ru.rosbank.robot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosbank.robot.models.IRobot;

import java.awt.*;
import java.awt.event.InputEvent;

@Service
public class CypressRobotService implements IRobot {
    private Robot robot;

    @Autowired
    public void CypressRobotService(Robot robot) {
        this.robot = robot;
    }

    /**
     * Перемещает указатель мыши в заданные координаты экрана.
     *
     * @param x позиция X
     * @param y позиция Y
     */
    @Override
    public void mouseMove(int x, int y) {
        robot.mouseMove(x, y);
    }

    /**
     * нажимает кнопки.
     */
    @Override
    public void mousePress() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}