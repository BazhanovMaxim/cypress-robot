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
     * нажимает кнопки.
     */
    void mousePress();
}
