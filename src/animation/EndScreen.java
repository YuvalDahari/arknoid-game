/**
 * @author Yuval Dahari
 * 209125939
 */

package animation;

import biuoop.DrawSurface;
import interfaces.Animation;

import java.awt.Color;

/**
 * Class which creates the end screens.
 */

public class EndScreen implements Animation {
    private boolean stop;
    private boolean winning;
    private int scoresCounter;

    /**
     * The function creates new EndScreen.
     *
     * @param winning       (boolean)
     * @param scoresCounter (int)
     */
    public EndScreen(boolean winning, int scoresCounter) {
        this.winning = winning;
        this.scoresCounter = scoresCounter;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.winning) {
            d.setColor(new Color(25, 13, 55));
            d.drawText(220, 265, "You Win! Your score is: " + this.scoresCounter, 30);
        } else {
            d.setColor(new Color(120, 13, 40));
            d.drawText(220, 265, "Game Over! Your score is: " + this.scoresCounter, 30);
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}