/**
 * @author Yuval Dahari
 * 209125939
 */

package geometric;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a geometric.Rectangle.
 */

public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Line rightEdge;
    private Line leftEdge;
    private Line upEdge;
    private Line downEdge;

    // Create a new rectangle with location and width/height.

    /**
     * The function creates new geometric.Rectangle.
     *
     * @param rectangle (geometric.Rectangle)
     */
    public Rectangle(Rectangle rectangle) {
        this.upperLeft = rectangle.getUpperLeft();
        this.width = rectangle.getWidth();
        this.height = rectangle.getHeight();
    }

    /**
     * The function creates new geometric.Rectangle.
     *
     * @param upperLeft (geometric.Point)
     * @param width     (double)
     * @param height    (double)
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.rightEdge = new Line(new Point(upperLeft.getX() + width, upperLeft.getY()),
                new Point(upperLeft.getX() + width, upperLeft.getY() + height));
        this.leftEdge = new Line(new Point(upperLeft.getX(), upperLeft.getY()),
                new Point(upperLeft.getX(), upperLeft.getY() + height));
        this.upEdge = new Line(new Point(upperLeft.getX(), upperLeft.getY()),
                new Point(upperLeft.getX() + width, upperLeft.getY()));
        this.downEdge = new Line(new Point(upperLeft.getX(), upperLeft.getY() + height),
                new Point(upperLeft.getX() + width, upperLeft.getY() + height));
    }

    /**
     * The function puts intersection points with the specified line inside a list.
     *
     * @param line (geometric.Line)
     * @return List<> - a list of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<>();
        Point intersectionPoint = line.intersectionWith(this.rightEdge);
        intersectionPointsAdd(intersectionPoints, intersectionPoint);
        intersectionPoint = line.intersectionWith(this.leftEdge);
        intersectionPointsAdd(intersectionPoints, intersectionPoint);
        intersectionPoint = line.intersectionWith(this.upEdge);
        intersectionPointsAdd(intersectionPoints, intersectionPoint);
        intersectionPoint = line.intersectionWith(this.downEdge);
        intersectionPointsAdd(intersectionPoints, intersectionPoint);
        return intersectionPoints;
    }

    /**
     * The function add point to the list if is not null.
     *
     * @param points (List<>)
     * @param point  (geometric.Point)
     */
    public void intersectionPointsAdd(List<Point> points, Point point) {
        if (point != null) {
            points.add(point);
        }
    }

    /**
     * The function returns the width of the rectangle.
     *
     * @return double - the width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * The function returns the height of the rectangle.
     *
     * @return double - the height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * The function returns the right edge of the rectangle.
     *
     * @return double - the right edge of the rectangle.
     */
    public Line getRightEdge() {
        return rightEdge;
    }

    /**
     * The function returns the left edge of the rectangle.
     *
     * @return double - the left edge of the rectangle.
     */
    public Line getLeftEdge() {
        return leftEdge;
    }

    /**
     * The function returns the up edge of the rectangle.
     *
     * @return double - the up edge of the rectangle.
     */
    public Line getUpEdge() {
        return upEdge;
    }

    /**
     * The function returns the down edge of the rectangle.
     *
     * @return double - the up edge of the rectangle.
     */
    public Line getDownEdge() {
        return downEdge;
    }
// Returns the upper-left point of the rectangle.

    /**
     * The function returns the upper-left point of the rectangle.
     *
     * @return geometric.Point - the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * The function draws a rectangle.
     *
     * @param surface (DrawSurface)
     */
    public void drawRectangle(DrawSurface surface) {
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }
}
