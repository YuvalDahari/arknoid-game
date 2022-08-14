/**
 * @author Yuval Dahari
 * 209125939
 */

package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * Class which manage all special screens.
 */

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * The function creates new KeyPressStoppableAnimation.
     *
     * @param keyboard  (KeyboardSensor)
     * @param key       (String)
     * @param animation (Animation)
     */
    public KeyPressStoppableAnimation(KeyboardSensor keyboard, String key, Animation animation) {
        this.keyboard = keyboard;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
