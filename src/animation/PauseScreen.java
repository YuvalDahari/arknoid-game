/**
 * @author Yuval Dahari
 * 209125939
 */

package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

import java.awt.Color;

/**
 * Class which creates PauseScreen.
 */

public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * The function creates new pause screen.
     *
     * @param k (KeyboardSensor)
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.fillRectangle(0, 0, 1000, 1000);
        d.setColor(Color.WHITE);
        d.drawText(50, 250, "paused press space to continue", 50);
        d.setColor(Color.RED);
        d.fillRectangle(400, 300, 35, 90);
        d.fillRectangle(350, 300, 35, 90);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
