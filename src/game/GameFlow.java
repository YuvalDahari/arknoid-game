/**
 * @author Yuval Dahari
 * 209125939
 */

package game;

import animation.AnimationRunner;
import animation.EndScreen;
import animation.KeyPressStoppableAnimation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import common.Counter;
import interfaces.LevelInformation;

import java.util.List;

/**
 * Class which manage the entire game.
 */

public class GameFlow {
    private GUI gui;
    private biuoop.KeyboardSensor keyboard;
    private AnimationRunner runner;
    private Counter scoresCounter = new Counter(0);

    /**
     * The function creates new GameFlow.
     *
     * @param gui      (GUI)
     * @param keyboard (KeyboardSensor)
     * @param runner   (AnimationRunner)
     */
    public GameFlow(GUI gui, KeyboardSensor keyboard, AnimationRunner runner) {
        this.gui = gui;
        this.keyboard = keyboard;
        this.runner = runner;
    }

    /**
     * The function runs all the game's levels.
     *
     * @param levels (List<>)
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean winning = true;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.gui, this.scoresCounter, this.runner);
            level.initialize();
            while (!level.shouldStop()) {
                level.run();
            }
            if (level.getNumOfRemainingBalls() == 0) {
                winning = false;
                break;
            }
        }
        this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                new EndScreen(winning, this.scoresCounter.getValue())));
        this.gui.close();
    }
}
