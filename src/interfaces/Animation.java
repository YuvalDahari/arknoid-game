/**
 * @author Yuval Dahari
 * 209125939
 */

package interfaces;

import biuoop.DrawSurface;

/**
 * Interface to represent an interfaces.Animation objects.
 */

public interface Animation {
    /**
     * The function is in charge of the logic in the game loop.
     * @param d (DrawSurface)
     */
    void doOneFrame(DrawSurface d);

    /**
     * The function is in charge of stopping condition in the game loop.
     *
     * @return boolean - stopping condition in the game loop.
     */
    boolean shouldStop();
}
