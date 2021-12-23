package ru.rosbank.robot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosbank.robot.models.IRobot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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
     * Нажимает ЛКМ.
     */
    @Override
    public void mousePress() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    /**
     * Вводит текст в поле.
     *
     * @param keys текст
     */
    public void sendKeys(String keys) {
        for (char c : keys.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException(String.format("Key code not found for character '%s'", c));
            }
            robot.keyPress(keyCode);
            robot.delay(100);
            robot.keyRelease(keyCode);
            robot.delay(100);
        }
    }

    /**
     * Нажимает клавишу на клавиатуре.
     *
     * @param key ключ клавишы.
     */
    public void keyPress(int key) {
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(key));
    }
}