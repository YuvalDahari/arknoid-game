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
import elements.Circle;

import geometric.Point;
import geometric.Rectangle;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class which defines the second level.
 */

public class SecondLevel extends BasicLevel {
    private static final int BALLS_NUM = 12;
    private static final int BLOCKS_NUM = 13;
    private static final int COLOR_RANGE = 255;
    public static final int BLOCK_WIDTH = 62;
    public static final int BLOCK_HEIGHT = 30;

    private Paddle paddle;

    /**
     * Second level constructor.
     */
    public SecondLevel() {
        super();
        this.setLevelName("Second Level");
        Rectangle rectangle = new Rectangle(new Point(200, 580), 400, 30);
        Block paddleBlock = new Block(rectangle, new Color(100, 1, 209));
        this.paddle = new Paddle(paddleBlock, null, rectangle.getWidth());
        createBlocks();
        createBalls();
    }

    /**
     * The function creates the second level blocks.
     */
    private void createBlocks() {
        for (int i = 0; i < BLOCKS_NUM; i++) {
            Rectangle rectangle = new Rectangle(new Point((i * BLOCK_WIDTH), BLOCK_HEIGHT + 300), BLOCK_WIDTH,
                    BLOCK_HEIGHT);
            Block block = new Block(rectangle);
            block.setColor(generateColor());
            this.blocks().add(block);
        }
    }

    /**
     * The function creates the second level blocks.
     */
    private void createBalls() {
        for (int i = 0; i < BALLS_NUM; i++) {
            Ball ball = new Ball(new Point(400, 570), 7, generateColor());
            ball.setVelocity(Velocity.fromAngleAndSpeed(10 * i - 50, 5));
            this.getBallsList().add(ball);
        }
    }

    @Override
    public Sprite getBackground() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        Circle c1 = new Circle(new Point(400, 600), 700, new Color(227, 227, 255), true);
        Circle c2 = new Circle(new Point(400, 600), 650, new Color(255, 200, 200), true);
        Circle c3 = new Circle(new Point(400, 600), 600, Color.GRAY, true);
        Circle c4 = new Circle(new Point(400, 600), 550, new Color(200, 200, 219), true);
        Circle c5 = new Circle(new Point(400, 600), 500, new Color(255, 225, 160), true);
        Circle c6 = new Circle(new Point(400, 600), 450, new Color(227, 227, 255), true);
        Circle c7 = new Circle(new Point(400, 600), 400, new Color(223, 242, 253), true);
        Circle c8 = new Circle(new Point(400, 600), 350, new Color(230, 255, 242), true);
        Circle c9 = new Circle(new Point(400, 600), 300, new Color(252, 250, 222), true);
        Circle c10 = new Circle(new Point(400, 600), 250, new Color(255, 238, 226), true);
        Circle c11 = new Circle(new Point(400, 600), 200, new Color(255, 219, 219), true);

        sprites.add(c1);
        sprites.add(c2);
        sprites.add(c3);
        sprites.add(c4);
        sprites.add(c5);
        sprites.add(c6);
        sprites.add(c7);
        sprites.add(c8);
        sprites.add(c9);
        sprites.add(c10);
        sprites.add(c11);

        return new Background(new Color(255, 219, 219), sprites);
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
        int r = rand.nextInt(COLOR_RANGE);
        int g = rand.nextInt(COLOR_RANGE);
        int b = rand.nextInt(COLOR_RANGE);
        return new Color(r, g, b);
    }
}