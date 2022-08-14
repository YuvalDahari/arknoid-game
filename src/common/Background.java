/**
 * @author Yuval Dahari
 * 209125939
 */

package common;

import biuoop.DrawSurface;
import game.GameLevel;
import interfaces.Sprite;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Class which represent all the backgrounds items.
 */

public class Background implements Sprite {

    private Color color;
    private ArrayList<Sprite> sprites;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    /**
     * The function creates new Background.
     *
     * @param color   (Color)
     * @param sprites (ArrayList<>)
     */
    public Background(Color color, ArrayList<Sprite> sprites) {
        this.color = color;
        this.sprites = sprites;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
        for (Sprite s : this.sprites) {
            s.drawOn(d);
        }
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void addToGame(GameLevel gameLevel) {
    }
}