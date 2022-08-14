/**
 * @author Yuval Dahari
 * 209125939
 */

package elements;

import biuoop.DrawSurface;
import common.Counter;
import game.GameLevel;
import interfaces.Sprite;

import java.awt.Color;

/**
 * Class to represent the score board.
 */

public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * The function creates a new elements.ScoreIndicator.
     *
     * @param score (common.Counter)
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(360, 25, "Score: " + this.score.getValue(), 20);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
