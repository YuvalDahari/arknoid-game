/**
 * @author Yuval Dahari
 * 209125939
 */

package common;

import geometric.Point;

/**
 * Class to represent a common.Velocity.
 */

public class Velocity {
    private double dx;
    private double dy;

    /**
     * The function creates new velocity.
     *
     * @param dx (double)
     * @param dy (double)
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * The function returns the value of dx.
     *
     * @return double - the dx value.
     */
    public double getDx() {
        return dx;
    }

    /**
     * The function returns the value of dy.
     *
     * @return double - the dy value.
     */
    public double getDy() {
        return dy;
    }

    /**
     * The function sets new dx value.
     *
     * @param dx (double)
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * The function sets new dy value.
     *
     * @param dy (double)
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * The function takes a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p (geometric.Point)
     * @return geometric.Point - a new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * The function calculate the speed according to the velocity values.
     *
     * @return double - the velocity speed.
     */
    public double speedCalculator() {
        return Math.sqrt((this.dx * this.dx) + (this.dy * this.dy));
    }

    /**
     * The function convert angel and speed values to velocity.
     *
     * @param angle (double)
     * @param speed (double)
     * @return common.Velocity - new data
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = speed * -1 * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
}