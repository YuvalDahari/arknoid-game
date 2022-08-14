/**
 * @author Yuval Dahari
 * 209125939
 */

package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import interfaces.Animation;

/**
 * Class who takes an Animation object and runs it.
 */

public class AnimationRunner {
    private GUI gui;
    private final int framesPerSecond = 60;
    private final Sleeper sleeper = new Sleeper();

    /**
     * The function creates new AnimationRunner.
     *
     * @param gui (GUI)
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
    }

    /**
     * The function run an animation.
     *
     * @param animation (Animation)
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
