/**
 * @author Yuval Dahari
 * 209125939
 */

package interfaces;

import elements.Ball;
import elements.Block;

/**
 * Interface to represent an interfaces.HitListener objects.
 */

public interface HitListener {
    /**
     * The function calls whenever the beingHit object is hit.
     * The hitter parameter is the elements.Ball that's doing the hitting.
     *
     * @param beingHit (elements.Block)
     * @param hitter   (elements.Ball)
     */
    void hitEvent(Block beingHit, Ball hitter);
}