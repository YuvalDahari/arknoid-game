/**
 * @author Yuval Dahari
 * 209125939
 */

package listeners;

import common.Counter;
import elements.Ball;
import elements.Block;
import game.GameLevel;
import interfaces.HitListener;

/**
 * Class which is in charge of removing balls from the game, as well as keeping count
 * of the number of balls that remain.
 */

public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * The function creates a new listeners.BallRemover.
     *
     * @param gameLevel           (game.Game)
     * @param remainingBalls (common.Counter)
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    /**
     * The function remove the object which being hit.
     *
     * @param beingHit (elements.Block)
     * @param hitter   (elements.Ball)
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease();
    }

    /**
     * The function returns the game member.
     *
     * @return game.Game - the game member
     */
    public GameLevel getGame() {
        return gameLevel;
    }

    /**
     * The function sets new value to the game member.
     *
     * @param gameLevel (game.Game)
     */
    public void setGame(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    /**
     * The function returns the counter member.
     *
     * @return common.Counter - the number of remain blocks.
     */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }

    /**
     * The function sets new value to the counter member.
     *
     * @param remainingBalls (common.Counter)
     */
    public void setRemainingBalls(Counter remainingBalls) {
        this.remainingBalls = remainingBalls;
    }
}
