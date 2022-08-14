/**
 * @author Yuval Dahari
 * 209125939
 */

package animation;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import common.SpriteCollection;
import interfaces.Animation;

import java.awt.Color;

/**
 * Class which creates CountdownAnimation.
 */

public class CountdownAnimation implements Animation {
    private final Sleeper sleeper = new Sleeper();
    private boolean running = true;
    private SpriteCollection spriteCollection;
    private int number = 3;

    /**
     * The function creates new CountdownAnimation.
     *
     * @param spriteCollection (SpriteCollection)
     */
    public CountdownAnimation(SpriteCollection spriteCollection) {
        this.spriteCollection = spriteCollection;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.spriteCollection.drawAllOn(d);
        if (number == 3) {
            d.setColor(Color.RED);
        }
        if (number == 2) {
            d.setColor(Color.ORANGE);
        }
        if (number == 1) {
            d.setColor(Color.GREEN);
        }
        d.drawText(375, 300, String.valueOf(number), 80);
        if (number != 3) {
            this.sleeper.sleepFor(2000 / 3);
        }
        if (number == 0) {
            this.running = false;
        } else {
            number--;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
