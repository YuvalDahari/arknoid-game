/**
 * @author Yuval Dahari
 * 209125939
 */

package interfaces;

import common.Velocity;
import elements.Ball;
import geometric.Point;
import geometric.Rectangle;

/**
 * Interface to represent an interfaces.Collidable objects.
 */

public interface Collidable {
    /**
     * @return geometric.Rectangle - the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param hitter          (elements.Ball)
     * @param collisionPoint  (geometric.Point)
     * @param currentVelocity (common.Velocity)
     * @return Velocity - the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}