package ru.rosbank.robot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rosbank.robot.models.IRobot;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
        var stringSelection = new StringSelection(keys);
        var clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
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