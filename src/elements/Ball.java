/**
 * @author Yuval Dahari
 * 209125939
 */

package elements;

import biuoop.DrawSurface;
import common.CollisionInfo;
import common.Velocity;
import game.GameLevel;
import game.GameEnvironment;
import geometric.Line;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Sprite;

import java.awt.Color;
import java.util.Random;

/**
 * Class to represent the elements.Ball.
 */

public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment = new GameEnvironment();
    static final Velocity DEFAULT_VELOCITY = new Velocity(1, 1);

    /**
     * The function creates new ball.
     *
     * @param center (geometric.Point)
     * @param radius (int)
     * @param color  (java.awt.Color)
     */
    public Ball(Point center, int radius, java.awt.Color color) {
        this.center = center;
        this.r = radius;
        this.color = color;
        this.v = DEFAULT_VELOCITY;
    }

    /**
     * The function returns the value of x of the center point.
     *
     * @return int - the x index of the center point.
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * The function returns the value of y of the center point.
     *
     * @return int - the y index of the center point.
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * The function returns the radius value of the ball.
     *
     * @return int - the radius of ball.
     */
    public int getSize() {
        return r;
    }

    /**
     * The function sets new radius value.
     *
     * @param r (int)
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * The function returns the gameEnvironment value of the ball.
     *
     * @return game.GameEnvironment - the gameEnvironment value of the ball.
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * The function sets new gameEnvironment value.
     *
     * @param gameEnvironment (game.GameEnvironment)
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * The function returns the center point of the ball.
     *
     * @return geometric.Point - the center of the ball.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * The function sets new center value.
     *
     * @param center (geometric.Point)
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * The function returns the color of the ball.
     *
     * @return java.awt.Color - the color of the ball.
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * The function returns the velocity of the ball.
     *
     * @return common.Velocity - the velocity of the ball.
     */
    public Velocity getVelocity() {
        return v;
    }

    /**
     * The function sets new velocity value.
     *
     * @param v (common.Velocity)
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }

    /**
     * The function sets new velocity value.
     *
     * @param dx (double)
     * @param dy (double)
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * The function adjust the center point to frame value by the velocity.
     */
    public void moveOneStep() {
        Point end = this.v.applyToPoint(new Point(this.center.getX(), this.center.getY()));
        Line trajectory = new Line(this.center, end);
        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo != null) {
            this.v = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.v);
            //paddle inside fixer
            paddleFixer(collisionInfo.collisionObject().getCollisionRectangle());
            end = this.v.applyToPoint(this.center);
            trajectory = new Line(this.center, end);
            collisionInfo = gameEnvironment.getClosestCollision(trajectory);
            if (collisionInfo != null) {
                this.v = collisionInfo.collisionObject().hit(this, this.center, this.v);
            }
            return;
        }
        this.center = this.v.applyToPoint(this.center);
    }

    /**
     * The function releases the ball while it gets inside.
     *
     * @param collisionRectangle (geometric.Rectangle)
     */
    private void paddleFixer(Rectangle collisionRectangle) {
        Point upperLeft = collisionRectangle.getUpperLeft();
        Point upperRight = collisionRectangle.getRightEdge().start();
        Point lowerLeft = collisionRectangle.getDownEdge().start();
        while (upperLeft.getY() <= center.getY() && center.getY() <= lowerLeft.getY()
                && upperLeft.getX() <= center.getX() && center.getX() <= upperRight.getX()) {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        this.center.drawPoint(surface, r);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * The function randoms a color.
     *
     * @return java.awt.Color - random color
     */
    public static java.awt.Color getRandomColor() {
        java.awt.Color[] colors = {Color.GREEN, Color.BLUE, Color.RED, Color.MAGENTA};
        int rand = new Random().nextInt(colors.length);
        return colors[rand];
    }

    /**
     * The function removes ball from the game.
     *
     * @param gameLevel (game.Game)
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}
