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
 * Class which is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */

public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * The function creates a new listeners.BlockRemover.
     *
     * @param gameLevel            (game.Game)
     * @param remainingBlocks (common.Counter)
     */
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * The function remove the object which being hit.
     *
     * @param beingHit (elements.Block)
     * @param hitter   (elements.Ball)
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease();
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
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    /**
     * The function sets new value to the counter member.
     *
     * @param remainingBlocks (common.Counter)
     */
    public void setRemainingBlocks(Counter remainingBlocks) {
        this.remainingBlocks = remainingBlocks;
    }
}