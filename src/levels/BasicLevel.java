/**
 * @author Yuval Dahari
 * 209125939
 */

package levels;

import common.Velocity;
import elements.Ball;
import elements.Block;
import elements.Paddle;
import geometric.Rectangle;
import interfaces.LevelInformation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent all kind of levels.
 */

public abstract class BasicLevel implements LevelInformation {
    private List<Ball> ballList;
    private List<Block> blocks;
    private String levelName;
    private Paddle paddle;

    /**
     * The function create new level.
     */
    protected BasicLevel() {
        this.ballList = new ArrayList<>();
        this.blocks = new ArrayList<>();
    }

    @Override
    public int numberOfBalls() {
        return this.ballList.size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (Ball ball : this.ballList) {
            velocities.add(ball.getVelocity());
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return this.paddle.speed();
    }

    @Override
    public int paddleWidth() {
        return (int) this.paddle.getWidth();
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }

    @Override
    public List<Ball> getBallsList() {
        return this.ballList;
    }

    @Override
    public Rectangle getPaddleRectangle() {
        return paddle.getBlock().getRectangle();
    }

    @Override
    public Color getPaddleColor() {
        return paddle.getBlock().getColor();
    }

    @Override
    public int getPaddleSpeed() {
        return this.paddle.speed();
    }

    /**
     * The function sets new level name.
     *
     * @param name (String)
     */
    public void setLevelName(String name) {
        this.levelName = name;
    }
}
