/**
 * @author Yuval Dahari
 * 209125939
 */

package elements;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import common.Velocity;
import game.GameLevel;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Collidable;
import interfaces.Sprite;

/**
 * Class to represent the elements.Paddle.
 */

public class Paddle implements Sprite, Collidable {
    private Block block;
    private double width;
    private double section;
    private int rightEdge;
    private final int leftEdge = 0;
    private KeyboardSensor keyboard;
    private static final int NUMBER_OF_SECTIONS = 5;
    private static final int MOVE = 5;

    /**
     * The function creates new elements.Paddle.
     *
     * @param block     (elements.Block)
     * @param keyboard  (biuoop.KeyboardSensor)
     * @param width     (double)
     */
    public Paddle(Block block, biuoop.KeyboardSensor keyboard, double width) {
        this.block = block;
        this.keyboard = keyboard;
        this.width = width;
        this.section = width / NUMBER_OF_SECTIONS;
        this.rightEdge = (int) (800 - this.width);
    }

    /**
     * The function moves the paddle to the left.
     */
    public void moveLeft() {
        Point point = new Point(block.getCollisionRectangle().getUpperLeft().getX() - MOVE,
                block.getCollisionRectangle().getUpperLeft().getY());
        if (point.getX() < leftEdge) {
            point.setX(leftEdge);
        }
        Rectangle rectangle = new Rectangle(point, block.getCollisionRectangle().getWidth(),
                block.getCollisionRectangle().getHeight());
        this.block = new Block(rectangle, this.block.getColor());
    }

    /**
     * The function moves the paddle to the right.
     */
    public void moveRight() {
        Point point = new Point(block.getCollisionRectangle().getUpperLeft().getX() + MOVE,
                block.getCollisionRectangle().getUpperLeft().getY());
        if (point.getX() > rightEdge) {
            point.setX(rightEdge);
        }
        Rectangle rectangle = new Rectangle(point, block.getCollisionRectangle().getWidth(),
                block.getCollisionRectangle().getHeight());
        this.block = new Block(rectangle, this.block.getColor());
    }

    /**
     * The function returns the paddle's speed.
     *
     * @return int - paddle's speed.
     */
    public int speed() {
        return MOVE;
    }

    /**
     * The function returns the paddle's width.
     *
     * @return double - paddle's width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * The function returns the paddle's block.
     *
     * @return Block - paddle's block.
     */
    public Block getBlock() {
        return block;
    }

    /**
     * The function sets ney keyboard sensor.
     * @param keyboard (KeyboardSensor)
     */
    public void setKeyboard(KeyboardSensor keyboard) {
    }

    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.block.drawOn(d);
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //values of the collision point
        double xCP = collisionPoint.getX();
        //values of the upper left point of the rectangle
        double xRec = this.block.getCollisionRectangle().getUpperLeft().getX();

        if (xCP >= xRec && xCP < xRec + this.section) {
            return Velocity.fromAngleAndSpeed(300, currentVelocity.speedCalculator());
        }
        if (xCP >= (xRec + this.section) && xCP < (xRec + (this.section * 2))) {
            return Velocity.fromAngleAndSpeed(330, currentVelocity.speedCalculator());
        }
        if (xCP >= (xRec + (this.section * 2)) && xCP < (xRec + (this.section * 3))) {
            return Velocity.fromAngleAndSpeed(0, currentVelocity.speedCalculator());
        }
        if (xCP >= (xRec + (this.section * 3)) && xCP < (xRec + (this.section * 4))) {
            return Velocity.fromAngleAndSpeed(30, currentVelocity.speedCalculator());
        }
        if (xCP >= (xRec + (this.section * 4)) && xCP <= (xRec + this.width)) {
            return Velocity.fromAngleAndSpeed(60, currentVelocity.speedCalculator());
        }
        return this.block.hit(hitter, collisionPoint, currentVelocity);
    }

}