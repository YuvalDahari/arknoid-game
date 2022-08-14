/**
 * @author Yuval Dahari
 * 209125939
 */

package listeners;

import common.Counter;
import elements.Ball;
import elements.Block;
import interfaces.HitListener;

/**
 * Class which is in charge on keeping scores.
 */

public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * The function creates a new listeners.ScoreTrackingListener.
     *
     * @param scoreCounter (common.Counter)
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * The function update the score while hitting occurs.
     *
     * @param beingHit (elements.Block)
     * @param hitter   (elements.Ball)
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}