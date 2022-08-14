/**
 * @author Yuval Dahari
 * 209125939
 */

package interfaces;

import biuoop.DrawSurface;
import game.GameLevel;

/**
 * Interface to represent an interfaces.Sprite objects.
 */

public interface Sprite {
    /**
     * The function draws the sprite to the screen.
     *
     * @param d (DrawSurface)
     */
    void drawOn(DrawSurface d);

    /**
     * The function notifies the sprite that time has passed.
     */
    void timePassed();

    /**
     * The function add the sprite object to is relevant lists.
     *
     * @param gameLevel (game.Game)
     */
    void addToGame(GameLevel gameLevel);
}