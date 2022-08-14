/**
 * @author Yuval Dahari
 * 209125939
 */

package levels;

import biuoop.DrawSurface;
import game.GameLevel;
import interfaces.Sprite;

import java.awt.Color;

/**
 * Class to represent the name level.
 */

public class NameLevel implements Sprite {
    private String levelName;

    /**
     * The function creates new levelName.
     *
     * @param levelName (String)
     */
    public NameLevel(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.drawText(10, 25, this.levelName, 20);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
