/**
 * @author Yuval Dahari
 * 209125939
 */

package elements;

import biuoop.DrawSurface;
import game.GameLevel;
import geometric.Point;
import interfaces.Sprite;

import java.awt.Color;

/**
 * Class to represent the elements.Circle.
 */

public class Circle implements Sprite {

    private Point center;
    private int radius;
    private Color color;
    private boolean isFill;

    /**
     * The function creates a new Circle.
     *
     * @param center Point
     * @param radius int
     * @param color  Color
     * @param isFill boolean
     */
    public Circle(Point center, int radius, Color color, boolean isFill) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.isFill = isFill;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        if (isFill) {
            d.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
        } else {
            d.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);

        }
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
    }
}