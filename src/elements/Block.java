/**
 * @author Yuval Dahari
 * 209125939
 */

package elements;

import biuoop.DrawSurface;
import common.Velocity;
import game.GameLevel;
import geometric.Point;
import geometric.Rectangle;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class to represent the elements.Block.
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners;


    /**
     * The function creates new block.
     *
     * @param point        (geometric.Point)
     * @param width        (double)
     * @param height       (double)
     * @param hitListeners (List<>)
     */
    public Block(Point point, double width, double height, List<HitListener> hitListeners) {
        this.hitListeners = hitListeners;
        this.rectangle = new Rectangle(point, width, height);
        this.hitListeners = new ArrayList<>();
    }

    /**
     * The function creates new block.
     *
     * @param rectangle (geometric.Rectangle)
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * The function creates new block.
     *
     * @param rectangle (geometric.Rectangle)
     * @param color     (Color)
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * The function return the color of the block.
     *
     * @return Color - the color of the block.
     */
    public Color getColor() {
        return color;
    }

    /**
     * The function return the rectangle member of the block.
     *
     * @return Rectangle - the rectangle member of the block.
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        if (this.getCollisionRectangle().getDownEdge().isOnTheLine(collisionPoint)) {
            newVelocity.setDy(-currentVelocity.getDy());
        }
        if (this.getCollisionRectangle().getUpEdge().isOnTheLine(collisionPoint)) {
            newVelocity.setDy(-currentVelocity.getDy());
        }
        if (this.getCollisionRectangle().getLeftEdge().isOnTheLine(collisionPoint)) {
            newVelocity.setDx(-currentVelocity.getDx());
        }
        if (this.getCollisionRectangle().getRightEdge().isOnTheLine(collisionPoint)) {
            newVelocity.setDx(-currentVelocity.getDx());
        }
        this.notifyHit(hitter);
        return newVelocity;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        if (this.color == null) {
            this.color = getRandomColor();
        }
        surface.setColor(color);
        this.rectangle.drawRectangle(surface);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
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
     * The function removes block from the game.
     *
     * @param gameLevel (game.Game)
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * The function makes a copy of the hitListeners before iterating over them,
     * and notify all listeners about a hit event.
     *
     * @param hitter (elements.Ball)
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * The function sets new color.
     *
     * @param color (Color)
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
