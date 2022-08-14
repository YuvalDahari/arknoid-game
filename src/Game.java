/**
 * @author Yuval Dahari
 * 209125939
 */

import animation.AnimationRunner;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import game.GameFlow;
import interfaces.LevelInformation;
import levels.FirstLevel;
import levels.ForthLevel;
import levels.SecondLevel;
import levels.ThirdLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class of the game.
 */

public class Game {
    private static final int FIRST_LEVEL = 1;
    private static final int SECOND_LEVEL = 2;
    private static final int THIRD_LEVEL = 3;
    private static final int FORTH_LEVEL = 4;

    //Const numbers for set the GUI proportions.
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    /**
     * The main function of the project.
     *
     * @param args (String[])
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        KeyboardSensor keyboard = gui.getKeyboardSensor();
        AnimationRunner runner = new AnimationRunner(gui);
        List<LevelInformation> levels = new ArrayList<>();
        int levelNumber;
        for (String s : args) {
            try {
                levelNumber = Integer.parseInt(s);
                switch (levelNumber) {
                    case FIRST_LEVEL -> levels.add(new FirstLevel());
                    case SECOND_LEVEL -> levels.add(new SecondLevel());
                    case THIRD_LEVEL -> levels.add(new ThirdLevel());
                    case FORTH_LEVEL -> levels.add(new ForthLevel());
                    default -> {
                    }
                }
            } catch (Exception ignored) {
            }
        }
        if (levels.size() == 0) {
            levels.add(new FirstLevel());
            levels.add(new SecondLevel());
            levels.add(new ThirdLevel());
            levels.add(new ForthLevel());
        }
        GameFlow gameFlow = new GameFlow(gui, keyboard, runner);
        gameFlow.runLevels(levels);
    }
}
