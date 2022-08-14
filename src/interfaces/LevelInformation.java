/**
 * @author Yuval Dahari
 * 209125939
 */

package interfaces;

import common.Velocity;
import elements.Ball;
import elements.Block;
import geometric.Rectangle;

import java.awt.Color;
import java.util.List;

/**
 * Interface to represent an interfaces.Levels.
 */

public interface LevelInformation {
    /**
     * The function returns the number of balls int the level.
     *
     * @return int - the number of balls int the level.
     */
    int numberOfBalls();

    /**
     * The function returns the initial velocity of each ball.
     *
     * @return List<> - the initial velocity of each ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * The function returns the paddle speed.
     *
     * @return int - paddle speed
     */
    int paddleSpeed();

    /**
     * The function returns the paddle width.
     *
     * @return int - paddle width
     */
    int paddleWidth();

    /**
     * The function returns the level name.
     *
     * @return String - the level name.
     */
    String levelName();

    /**
     * The function returns the sprite with the background of the level.
     *
     * @return Sprite - the background of the level.
     */
    Sprite getBackground();

    /**
     * The function returns list of the blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return List<> - list of blocks of the level.
     */
    List<Block> blocks();

    /**
     * The function returns the number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return int - the number of blocks in the level.
     */
    int numberOfBlocksToRemove();

    /**
     * The function returns the rectangle of the level's paddle.
     *
     * @return Rectangle - paddle's rectangle.
     */
    Rectangle getPaddleRectangle();

    /**
     * The function returns the color of the level's paddle.
     *
     * @return Color - paddle's color.
     */
    Color getPaddleColor();

    /**
     * The function returns the speed of the level's paddle.
     *
     * @return int - paddle's speed.
     */
    int getPaddleSpeed();

    /**
     * The function returns list of the balls.
     *
     * @return List<> - list of balls of the level.
     */
    List<Ball> getBallsList();

    /**
     * The function returns the width of the level's paddle.
     *
     * @return int - paddle's width.
     */
    int getPaddleWidth();
}
