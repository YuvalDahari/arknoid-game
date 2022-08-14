/**
 * @author Yuval Dahari
 * 209125939
 */

package common;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent the common.SpriteCollection.
 */

public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * The function creates new common.SpriteCollection.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * The function returns the sprite list.
     *
     * @return List<> - the sprite list.
     */
    public List<Sprite> getSpriteList() {
        return spriteList;
    }

    /**
     * The function adds new sprite to sprites' list.
     *
     * @param s (interfaces.Sprite)
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * The function calls timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<>(this.spriteList);
        for (Sprite sprite : sprites) {
            sprite.timePassed();
        }
    }

    /**
     * The function calls drawOn(d) on all sprites.
     *
     * @param d (DrawSurface)
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : spriteList) {
            sprite.drawOn(d);
        }
    }
}