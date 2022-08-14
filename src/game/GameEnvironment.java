/**
 * @author Yuval Dahari
 * 209125939
 */

package game;

import common.CollisionInfo;
import geometric.Line;
import interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent the game.GameEnvironment.
 */

public class GameEnvironment {
    private List<Collidable> collidableList;

    /**
     * The function creates new game.GameEnvironment.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<>();
    }

    /**
     * The function adds the given collidable to the environment.
     *
     * @param c (interfaces.Collidable)
     */
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }

    /**
     * The function assume an object moving from line.start() to line.end(), and return the information of the
     * closest hit point if there is one.
     *
     * @param trajectory (geometric.Line)
     * @return CollidableInfo - if this object will not collide with any of the collidables in this collection,
     * return null. Else, return the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        return this.collidableCheck(trajectory);
    }

    /**
     * The function assume an object moving from line.start() to line.end(), and return the information of the
     * closest hit point if there is one.
     *
     * @param line (geometric.Line)
     * @return common.CollisionInfo - the information about the closest collision that is going to occur if there
     * is one.
     */
    public CollisionInfo collidableCheck(Line line) {
        if (this.collidableList.isEmpty()) {
            return null;
        }
        CollisionInfo closest = null;
        for (Collidable collidable : this.collidableList) {
            CollisionInfo object = new CollisionInfo(collidable,
                    line.closestIntersectionToStartOfLine(collidable.getCollisionRectangle()));
            if (object.collisionPoint() != null) {
                if (closest == null) {
                    closest = object;
                } else if (line.start().distance(object.collisionPoint())
                        < line.start().distance(closest.collisionPoint())) {
                    closest = object;
                }
            }
        }
        return closest;
    }

    /**
     * The function return ths CollidableList.
     *
     * @return List<> - the CollidableList.
     */
    public List<Collidable> getCollidableList() {
        return this.collidableList;
    }
}
