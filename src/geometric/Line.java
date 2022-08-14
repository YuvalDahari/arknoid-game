/**
 * @author Yuval Dahari
 * 209125939
 */

package geometric;

import biuoop.DrawSurface;
import game.GameLevel;
import interfaces.Sprite;

import java.awt.Color;
import java.util.List;

/**
 * Class to represent a geometric.Line.
 */

public class Line implements Sprite {
    private final Point start;
    private final Point end;
    private static final double COMPARISON_THRESHOLD = 0.00000000001;
    private Color color;

    /**
     * The function creates new line.
     * *
     *
     * @param start (geometric.Point)
     * @param end   (geometric.Point)
     * @param color (Color)
     */
    public Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    /**
     * The function creates new line by two points.
     *
     * @param start (geometric.Point)
     * @param end   (geometric.Point)
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The function creates new line by four dots.
     *
     * @param x1 (double)
     * @param y1 (double)
     * @param x2 (double)
     * @param y2 (double)
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);

    }

    /**
     * The function create null line.
     */
    public Line() {
        this.start = null;
        this.end = null;
    }

    /**
     * The function returns the length of a line.
     *
     * @return double - length.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * The function returns the middle point of a line.
     *
     * @return geometric.Point - the middle point.
     */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * * The function return the starting points of the line.
     *
     * @return geometric.Point - the starting point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * The function return the ending points of the line.
     *
     * @return geometric.Point - the ending point.
     */
    public Point end() {
        return this.end;
    }

    /**
     * The function checks if there is an intersection point.
     *
     * @param y (double)
     * @return boolean - true if there is an intersection point, otherwise return false.
     */
    private boolean infinityCheck(double y) {
        //this
        double yMax = Math.max(this.start.getY(), this.end.getY());
        double yMin = Math.min(this.start.getY(), this.end.getY());

        return ((y >= yMin - COMPARISON_THRESHOLD) && (y <= yMax + COMPARISON_THRESHOLD));
    }

    /**
     * The function finds the launching point, if there is one.
     *
     * @param other (geometric.Line)
     * @return geometric.Point - launching point if there is one, otherwise return null.
     */
    private Point infinityLaunchingPointCheck(Line other) {
        //this
        double yMaxThis = Math.max(this.start.getY(), this.end.getY());
        double yMinThis = Math.min(this.start.getY(), this.end.getY());
        //other
        double yMaxOther = Math.max(other.start.getY(), other.end.getY());
        double yMinOther = Math.min(other.start.getY(), other.end.getY());
        if (yMaxThis - COMPARISON_THRESHOLD > yMaxOther) {
            if (Math.abs(yMinThis - yMaxOther) <= COMPARISON_THRESHOLD) {
                return new Point(this.start.getX(), yMinThis);
            }
        }
        if (yMaxOther - COMPARISON_THRESHOLD > yMaxThis) {
            if (Math.abs(yMinOther - yMaxThis) <= COMPARISON_THRESHOLD) {
                return new Point(this.start.getX(), yMinOther);
            }
        }
        return null;
    }

    /**
     * The function checks if there is an intersection point.
     *
     * @param other (geometric.Line)
     * @return boolean - true if there is an intersection, otherwise return false.
     */
    private boolean zeroCheck(Line other) {
        double x = (this.start.getY() - other.lineEquationIntercept()) / other.lineEquationSlope();
        double xMax = Math.max(this.start.getX(), this.end.getX());
        double xMin = Math.min(this.start.getX(), this.end.getX());
        return !(x > xMax + COMPARISON_THRESHOLD) && !(x < xMin - COMPARISON_THRESHOLD);
    }

    /**
     * The function finds the launching point, if there is one.
     *
     * @param other (geometric.Line)
     * @return geometric.Point - launching point if there is one, otherwise return null.
     */
    private Point zeroLaunchingPointCheck(Line other) {
        //this
        double xMaxThis = Math.max(this.start.getX(), this.end.getX());
        double xMinThis = Math.min(this.start.getX(), this.end.getX());
        //other
        double xMaxOther = Math.max(other.start.getX(), other.end.getX());
        double xMinOther = Math.min(other.start.getX(), other.end.getX());
        if (xMaxThis - COMPARISON_THRESHOLD > xMaxOther) {
            if (Math.abs(xMinThis - xMaxOther) <= COMPARISON_THRESHOLD) {
                return new Point(xMinThis, this.start.getY());
            }
        }
        if (xMaxOther - COMPARISON_THRESHOLD > xMaxThis) {
            if (Math.abs(xMinOther - xMaxThis) <= COMPARISON_THRESHOLD) {
                return new Point(xMinOther, this.start.getY());
            }
        }
        return null;
    }


    /**
     * The function finds the launching point, if there is one.
     *
     * @param other (geometric.Line)
     * @return geometric.Point - launching point if there is one, otherwise return null.
     */
    private Point launchingPoint(Line other) {
        //this
        double yMaxThis = Math.max(this.start.getY(), this.end.getY());
        double yMinThis = Math.min(this.start.getY(), this.end.getY());
        double xMaxThis = Math.max(this.start.getX(), this.end.getX());
        double xMinThis = Math.min(this.start.getX(), this.end.getX());
        //other
        double yMaxOther = Math.max(other.start.getY(), other.end.getY());
        double yMinOther = Math.min(other.start.getY(), other.end.getY());
        double xMaxOther = Math.max(other.start.getX(), other.end.getX());
        double xMinOther = Math.min(other.start.getX(), other.end.getX());
        if (yMaxThis - COMPARISON_THRESHOLD > yMaxOther) {
            if (Math.abs(yMinThis - yMaxOther) <= COMPARISON_THRESHOLD) {
                return new Point(this.start.getX(), yMinThis);
            }
        }
        if (yMaxOther - COMPARISON_THRESHOLD > yMaxThis) {
            if (Math.abs(yMinOther - yMaxThis) <= COMPARISON_THRESHOLD) {
                return new Point(this.start.getX(), yMinOther);
            }
        }
        if (xMaxThis - COMPARISON_THRESHOLD > xMaxOther) {
            if (Math.abs(xMinThis - xMaxOther) <= COMPARISON_THRESHOLD) {
                return new Point(xMinThis, this.start.getY());
            }
        }
        if (xMaxOther - COMPARISON_THRESHOLD > xMaxThis) {
            if (Math.abs(xMinOther - xMaxThis) <= COMPARISON_THRESHOLD) {
                return new Point(xMinOther, this.start.getY());
            }
        }
        return null;
    }

    /**
     * The function checks if the lines are converged.
     *
     * @param other (geometric.Line)
     * @return boolean - true if the lines are converged, otherwise false.
     */
    private boolean isConverge(Line other) {
        double m1 = lineEquationSlope();
        double b1 = lineEquationIntercept();
        double m2 = other.lineEquationSlope();
        double b2 = other.lineEquationIntercept();
        if ((Math.abs(m1 - m2) > COMPARISON_THRESHOLD) || (Math.abs(b1 - b2) > COMPARISON_THRESHOLD)) {
            return false;
        }
        //this
        double yMaxThis = Math.max(this.start.getY(), this.end.getY());
        double yMinThis = Math.min(this.start.getY(), this.end.getY());
        double xMaxThis = Math.max(this.start.getX(), this.end.getX());
        double xMinThis = Math.min(this.start.getX(), this.end.getX());
        //other
        double yMaxOther = Math.max(other.start.getY(), other.end.getY());
        double yMinOther = Math.min(other.start.getY(), other.end.getY());
        double xMaxOther = Math.max(other.start.getX(), other.end.getX());
        double xMinOther = Math.min(other.start.getX(), other.end.getX());
        if (yMaxThis - COMPARISON_THRESHOLD > yMaxOther) {
            if (yMinThis - COMPARISON_THRESHOLD > yMaxOther) {
                return false;
            }
        }
        if (yMaxOther - COMPARISON_THRESHOLD > yMaxThis) {
            if (yMinOther - COMPARISON_THRESHOLD > yMaxThis) {
                return false;
            }
        }
        if (xMaxThis - COMPARISON_THRESHOLD > xMaxOther) {
            if (xMinThis - COMPARISON_THRESHOLD > xMaxOther) {
                return false;
            }
        }
        if (xMaxOther - COMPARISON_THRESHOLD > xMaxThis) {
            return !(xMinOther - COMPARISON_THRESHOLD > xMaxThis);
        }
        return true;
    }

    /**
     * The function checks if another line intersecting with the line.
     *
     * @param other (geometric.Line)
     * @return boolean - if there is intersecting point returns true, otherwise return false.
     */
    public boolean isIntersecting(Line other) {
        return (intersectionWith(other) != null || this.equals(other) || this.isConverge(other));
    }

    /**
     * The function checks what is the intersection point.
     *
     * @param other (geometric.Line)
     * @return geometric.Point - the intersection point.
     */
    public Point intersectionWith(Line other) {
        double m1 = lineEquationSlope();
        double b1 = lineEquationIntercept();
        double m2 = other.lineEquationSlope();
        double b2 = other.lineEquationIntercept();
        Point specialCasesPoint;
        //special cases
        if (this.equals(other)) {
            return null;
        }
        //infinity slope checks
        if (Double.isInfinite(m1) && Double.isInfinite(m2)) {
            if (Math.abs(this.start.getX() - other.start.getX()) > COMPARISON_THRESHOLD) {
                return null;
            }
            return infinityLaunchingPointCheck(other);
        }
        if (Double.isInfinite(m1)) {
            if (this.infinityCheck(m2 * this.start.getX() + b2)) {
                specialCasesPoint = new Point(this.start.getX(), m2 * this.start.getX() + b2);
                if (this.isOnTheLine(specialCasesPoint) && other.isOnTheLine(specialCasesPoint)) {
                    return specialCasesPoint;
                }
            }
            return null;
        }
        if (Double.isInfinite(m2)) {
            if (other.infinityCheck(m1 * other.start.getX() + b1)) {
                specialCasesPoint = new Point(other.start.getX(), m1 * other.start.getX() + b1);
                if (this.isOnTheLine(specialCasesPoint) && other.isOnTheLine(specialCasesPoint)) {
                    return specialCasesPoint;
                }
            }
            return null;
        }
        //zero slope checks
        if (m1 == 0 && m2 == 0) {
            if (Math.abs(this.start.getY() - other.start.getY()) > COMPARISON_THRESHOLD) {
                return null;
            }
            return zeroLaunchingPointCheck(other);
        }
        if (m1 == 0) {
            if (zeroCheck(other)) {
                specialCasesPoint = new Point((this.start.getY() - b2) / m2, this.start.getY());
                if (this.isOnTheLine(specialCasesPoint) && other.isOnTheLine(specialCasesPoint)) {
                    return specialCasesPoint;
                }
            }
            return null;
        }
        if (m2 == 0) {
            if (zeroCheck(this)) {
                specialCasesPoint = new Point((other.start.getY() - b1) / m1, other.start.getY());
                if (this.isOnTheLine(specialCasesPoint) && other.isOnTheLine(specialCasesPoint)) {
                    return specialCasesPoint;
                }
            }
            return null;
        }
        //same slope check
        if (Math.abs(m1 - m2) < COMPARISON_THRESHOLD) {
            if (Math.abs(b1 - b2) > COMPARISON_THRESHOLD) {
                return null;
            }
            return this.launchingPoint(other);
        }
        //regular case
        double x = (b2 - b1) / (m1 - m2);
        double y = m1 * ((b2 - b1) / (m1 - m2)) + b1;
        Point point = new Point(x, y);
        //Checking if the point is on the lines.
        if (this.isOnTheLine(point) && other.isOnTheLine(point)) {
            return point;
        }
        return null;
    }

    /**
     * The function checks if two lines are equals.
     *
     * @param other (geometric.Line)
     * @return boolean - if equals returns true, otherwise return false.
     */
    public boolean equals(Line other) {
        return ((this.start.equals(other.start) && this.end.equals(other.end))
                || (this.start.equals(other.end) && this.end.equals(other.start)));
    }

    /**
     * The function calculates the slope in the line equation by two dots.
     *
     * @return double - the slope in the equation.
     */
    public double lineEquationSlope() {
        double y = this.start.getY() - this.end.getY();
        double x = this.start.getX() - this.end.getX();
        return y / x;
    }

    /**
     * The function calculates the intercept in the line equation by dot and slope.
     *
     * @return double - the intercept in the equation.
     */
    public double lineEquationIntercept() {
        return this.start.getY() - (lineEquationSlope() * this.start.getX());
    }

    /**
     * The function check if a points is in the line.
     *
     * @param point (Points)
     * @return boolean - if on the line returns true, otherwise return false.
     */
    public boolean isOnTheLine(Point point) {
        double xMax = Math.max(this.start.getX(), this.end.getX());
        double yMax = Math.max(this.start.getY(), this.end.getY());
        double xMin = Math.min(this.start.getX(), this.end.getX());
        double yMin = Math.min(this.start.getY(), this.end.getY());
        double x = point.getX();
        double y = point.getY();
        if (x < xMin - COMPARISON_THRESHOLD) {
            return false;
        }
        if (y < yMin - COMPARISON_THRESHOLD) {
            return false;
        }
        if (x > xMax + COMPARISON_THRESHOLD) {
            return false;
        }
        return !(y > yMax + COMPARISON_THRESHOLD);
    }

    /**
     * The function draws a line.
     *
     * @param d (DrawSurface)
     */
    public void drawLine(DrawSurface d) {
        d.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
    }

    /**
     * The function checks what the closest point to intersection.
     *
     * @param rect (geometric.Rectangle)
     * @return geometric.Point - the closest point to intersection.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        if (intersectionPoints.isEmpty()) {
            return null;
        }
        Point closestPoint = null;
        for (int i = 0; i < intersectionPoints.size(); i++) {
            Point point = intersectionPoints.get(i);
            if (intersectionPoints != null) {
                if (closestPoint == null) {
                    closestPoint = point;
                } else if (this.start.distance(point) < this.start.distance(closestPoint)) {
                    closestPoint = point;
                }
            }
        }
        return closestPoint;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine((int) this.start().getX(), (int) this.start().getY(), (int) this.end().getX(),
                (int) this.start().getY());
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel gameLevel) {

    }
}