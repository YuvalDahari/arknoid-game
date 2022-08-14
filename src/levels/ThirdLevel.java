/**
 * @author Yuval Dahari
 * 209125939
 */

package levels;

import common.Background;
import common.Velocity;
import elements.Ball;
import elements.Block;
import elements.Paddle;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class which defines the first level.
 */

public class ThirdLevel extends BasicLevel {
    private static final int BALLS_NUM = 2;
    public static final int WIDTH = 800;
    private static final int COLOR_RANGE = 255;
    public static final int BLOCK_WIDTH = 62;
    public static final int BLOCK_HEIGHT = 30;

    private Paddle paddle;


    /**
     * Third level constructor.
     */
    public ThirdLevel() {
        super();
        this.setLevelName("Third Level");
        Rectangle rectangle = new Rectangle(new Point(WIDTH / 2 - 60, 580), 120, 30);
        Block paddleBlock = new Block(rectangle, new Color(120, 13, 40));
        this.paddle = new Paddle(paddleBlock, null, rectangle.getWidth());
        createBalls();
        createBlocks();
    }

    /**
     * The function creates the second level balls.
     */
    private void createBalls() {
        for (int i = 0; i < BALLS_NUM; i++) {
            Ball ball = new Ball(new Point(400, 570), 7, Color.WHITE);
            ball.setVelocity(Velocity.fromAngleAndSpeed(10 * i - 50, 6));
            this.getBallsList().add(ball);
        }
    }

    /**
     * The function creates the second level blocks.
     */
    private void createBlocks() {
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 13 - i; j++) {
                Rectangle rectangle = new Rectangle(new Point(WIDTH - ((j) * BLOCK_WIDTH),
                        i * BLOCK_HEIGHT + 100), BLOCK_WIDTH, BLOCK_HEIGHT);
                Block block = new Block(rectangle);
                if (i == 0) {
                    block.setColor(new Color(0, 200, 200));
                }
                if (i == 1) {
                    block.setColor(new Color(0, 120, 120));
                }
                if (i == 2) {
                    block.setColor(new Color(0, 250, 180));
                }
                if (i == 3) {
                    block.setColor(new Color(0, 160, 1));
                }
                if (i == 4) {
                    block.setColor(new Color(0, 100, 18));
                }
                if (i == 5) {
                    block.setColor(new Color(0, 75, 0));
                }
                this.blocks().add(block);
            }
        }
    }

    @Override
    public Sprite getBackground() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        return new Background(new Color(100, 90, 56), sprites);

    }

    @Override
    public Rectangle getPaddleRectangle() {
        return this.paddle.getBlock().getRectangle();
    }

    @Override
    public Color getPaddleColor() {
        return this.paddle.getBlock().getColor();
    }

    @Override
    public int getPaddleSpeed() {
        return this.paddle.speed();
    }

    @Override
    public int getPaddleWidth() {
        return (int) this.paddle.getBlock().getRectangle().getWidth();
    }

    /**
     * The function randoms a color.
     *
     * @return Color - random color.
     */
    public static Color generateColor() {
        Random rand = new Random();
        int g = rand.nextInt(COLOR_RANGE);
        int b = rand.nextInt(COLOR_RANGE);
        return new Color(0, g, b);
    }

}