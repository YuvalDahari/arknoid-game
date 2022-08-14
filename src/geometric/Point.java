/**
 * @author Yuval Dahari
 * 209125939
 */

package geometric;

import biuoop.DrawSurface;

/**
 * Class to represent a geometric.Point.
 */

public class Point {
    private double x;
    private double y;
    private static final double COMPARISON_THRESHOLD = 0.00000000001;

    /**
     * The function creates a new point by two values.
     *
     * @param x (double)
     * @param y (double)
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The function calculate the distance between two points.
     *
     * @param other (geometric.Point)
     * @return double - the distance of this point to the other point.
     */
    public double distance(Point other) {
        double num1 = (this.getX() - other.getX()) * (this.getX() - other.getX());
        double num2 = (this.getY() - other.getY()) * (this.getY() - other.getY());
        return Math.sqrt(num1 + num2);
    }

    /**
     * The function checks if two points are equal.
     *
     * @param other (geometric.Point)
     * @return boolean - true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return (Math.abs(this.x - other.getX()) < COMPARISON_THRESHOLD
                && Math.abs(this.y - other.getY()) < COMPARISON_THRESHOLD)
                || (Math.abs(this.x - other.getY()) < COMPARISON_THRESHOLD
                && Math.abs(this.y - other.getX()) < COMPARISON_THRESHOLD);
    }

    /**
     * The function returns the value of x.
     *
     * @return double - the x index of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * The function sets new x value.
     *
     * @param x (double)
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * The function returns the value of y.
     *
     * @return double - the y index of the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * The function sets new y value.
     *
     * @param y (double)
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * The function draws a circle by radius value.
     *
     * @param d      (DrawSurface)
     * @param radius (int)
     */

    public void drawPoint(DrawSurface d, int radius) {
        d.fillCircle((int) this.x, (int) this.y, radius);
    }
}
