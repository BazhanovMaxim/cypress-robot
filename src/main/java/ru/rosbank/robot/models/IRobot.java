package ru.rosbank.robot.models;

public interface IRobot {

    /**
     * Перемещает указатель мыши в заданные координаты экрана.
     *
     * @param x позиция X
     * @param y позиция Y
     */
    void mouseMove(int x, int y);

    /**
     * Нажимает ЛКМ.
     */
    void mousePress();

    /**
     * Вводит текст в поле.
     *
     * @param keys текст
     */
    void sendKeys(String keys);

    /**
     * Нажимает клавишу на клавиатуре.
     *
     * @param key ключ клавишы.
     */
    void keyPress(int key);
}
