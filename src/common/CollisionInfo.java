/**
 * @author Yuval Dahari
 * 209125939
 */

package common;

import geometric.Point;
import interfaces.Collidable;

/**
 * Class to represent the common.CollisionInfo.
 */

public class CollisionInfo {
    private Collidable collisionObject;
    private Point collisionPoint;

    /**
     * The function creates new collisionInfo.
     *
     * @param collisionObject (interfaces.Collidable)
     * @param collisionPoint  (geometric.Point)
     */
    public CollisionInfo(Collidable collisionObject, Point collisionPoint) {
        this.collisionObject = collisionObject;
        this.collisionPoint = collisionPoint;
    }

    /**
     * @return geometric.Point - the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return interfaces.Collidable - the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }

}
