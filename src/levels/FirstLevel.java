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
import geometric.Line;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Class which defines the first level.
 */

public class FirstLevel extends BasicLevel {
    private Paddle paddle;

    public static final int WIDTH = 800;

    /**
     * First level constructor.
     */
    public FirstLevel() {
        super();
        this.setLevelName("First Level");
        Rectangle rectangle = new Rectangle(new Point(WIDTH / 2 - 60, 580), 120, 30);
        Block paddleBlock = new Block(rectangle, new Color(97, 125, 232));
        this.paddle = new Paddle(paddleBlock, null, rectangle.getWidth());
        Ball ball = new Ball(new Point(400, 575), 7, Color.ORANGE);
        ball.setVelocity(new Velocity(0, 5));
        this.getBallsList().add(ball);
        Block block = new Block(new Rectangle(new Point(WIDTH / 2 - 40, 122), 80, 80));
        block.setColor(Color.LIGHT_GRAY);
        this.blocks().add(block);
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

    @Override
    public Sprite getBackground() {
        ArrayList<Sprite> sprites = new ArrayList<>();
        Circle c1 = new Circle(new Point(400, 162), 60, Color.WHITE, false);
        Circle c2 = new Circle(new Point(400, 162), 90, Color.WHITE, false);
        Circle c3 = new Circle(new Point(400, 162), 120, Color.WHITE, false);
        Line l1 = new Line(new Point(400, 182), new Point(400, 302), Color.WHITE);
        Line l2 = new Line(new Point(420, 162), new Point(540, 162), Color.WHITE);
        Line l3 = new Line(new Point(380, 162), new Point(260, 163), Color.WHITE);
        Line l4 = new Line(new Point(400, 142), new Point(400, 22), Color.WHITE);
        sprites.add(c1);
        sprites.add(c2);
        sprites.add(c3);
        sprites.add(l1);
        sprites.add(l2);
        sprites.add(l3);
        sprites.add(l4);
        return new Background(new Color(25, 13, 55), sprites);
    }
}