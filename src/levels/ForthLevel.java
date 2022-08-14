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
 * Class which defines the forth level.
 */

public class ForthLevel extends BasicLevel {
    private static final int BALL_NUM = 4;
    public static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int COLOR_RANGE = 255;
    public static final int BLOCK_WIDTH = 62;
    public static final int BLOCK_HEIGHT = 30;
    public static final Color LIGHT_GRAY = new Color(242, 242, 242);
    public static final Color NIGHT_SKY = new Color(0, 51, 153);
    public static final Color MOON = new Color(242, 242, 242);
    public static final Color STAR = new Color(250, 250, 250);

    private Paddle paddle;

    /**
     * Forth level constructor.
     */
    public ForthLevel() {
        super();
        this.setLevelName("Forth Level");
        Rectangle rectangle = new Rectangle(new Point(320, 580), 200, 30);
        Block paddleBlock = new Block(rectangle, Color.DARK_GRAY);
        this.paddle = new Paddle(paddleBlock, null, rectangle.getWidth());
        createBalls();
        createBlocks();
    }

    /**
     * The function creates the forth level balls.
     */
    private void createBalls() {
        for (int i = 0; i < BALL_NUM; i++) {
            Ball b1 = new Ball(new Point(420, 572), 7, generateColor());
            b1.setVelocity(Velocity.fromAngleAndSpeed(40, 6));
            this.getBallsList().add(b1);
            Ball b2 = new Ball(new Point(420, 572), 7, generateColor());
            b2.setVelocity(Velocity.fromAngleAndSpeed(0, 6));
            this.getBallsList().add(b2);
            Ball b3 = new Ball(new Point(420, 572), 7, generateColor());
            b3.setVelocity(Velocity.fromAngleAndSpeed(-40, 6));
            this.getBallsList().add(b3);
        }
    }

    /**
     * The function creates the second level blocks.
     */
    private void createBlocks() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 13; j++) {
                Rectangle rectangle = new Rectangle(new Point(j * BLOCK_WIDTH, i * BLOCK_HEIGHT + 200),
                        BLOCK_WIDTH, BLOCK_HEIGHT);
                Block block = new Block(rectangle);
                if (i == 0) {
                    block.setColor(new Color(227, 227, 255));
                }
                if (i == 1) {
                    block.setColor(new Color(230, 255, 242));
                }
                if (i == 2) {
                    block.setColor(new Color(250, 240, 200));
                }
                if (i == 3) {
                    block.setColor(new Color(255, 238, 226));
                }
                if (i == 4) {
                    block.setColor(new Color(252, 250, 222));
                }
                if (i == 5) {
                    block.setColor(new Color(255, 219, 219));
                }
                this.blocks().add(block);
            }
        }
    }

    @Override
    public Sprite getBackground() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        Circle c1 = new Circle(new Point(100, 80), 24, LIGHT_GRAY, true);
        Circle c2 = new Circle(new Point(120, 100), 29, LIGHT_GRAY, true);
        Circle c3 = new Circle(new Point(140, 60), 29, STAR, true);
        Circle c4 = new Circle(new Point(160, 100), 26, LIGHT_GRAY, true);
        Circle c5 = new Circle(new Point(180, 80), 28, LIGHT_GRAY, true);
        Circle c6 = new Circle(new Point(180, 80), 29, LIGHT_GRAY, true);
        Circle c7 = new Circle(new Point(200, 100), 30, STAR, true);
        Circle c8 = new Circle(new Point(220, 60), 25, LIGHT_GRAY, true);
        Circle c9 = new Circle(new Point(240, 100), 26, LIGHT_GRAY, true);
        Circle c10 = new Circle(new Point(260, 80), 29, STAR, true);
        Circle c11 = new Circle(new Point(270, 80), 20, LIGHT_GRAY, true);
        Circle c12 = new Circle(new Point(290, 100), 25, LIGHT_GRAY, true);
        Circle c13 = new Circle(new Point(310, 60), 26, LIGHT_GRAY, true);
        Circle c14 = new Circle(new Point(330, 100), 28, STAR, true);
        Circle c15 = new Circle(new Point(350, 80), 29, LIGHT_GRAY, true);
        Circle c16 = new Circle(new Point(600, 110), 50, MOON, true);
        Circle c17 = new Circle(new Point(630, 110), 50, NIGHT_SKY, true);
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
        sprites.add(c12);
        sprites.add(c13);
        sprites.add(c14);
        sprites.add(c15);
        sprites.add(c16);
        sprites.add(c17);

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            sprites.add(new Circle(new Point(random.nextInt(WIDTH), random.nextInt(HEIGHT)), 1, STAR, true));
        }
        return new Background(NIGHT_SKY, sprites);
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
        return new Color(r, g, 0);
    }
}