/**
 * @author Yuval Dahari
 * 209125939
 */

package interfaces;

/**
 * Interface to represent an interfaces.HitNotifier objects.
 */


public interface HitNotifier {

    /**
     * The function adds new listener to hit event.
     *
     * @param hl (interfaces.HitListener)
     */
    void addHitListener(HitListener hl);

    /**
     * The function removes listener from the list of listeners to hit events.
     *
     * @param hl (interfaces.HitListener)
     */
    void removeHitListener(HitListener hl);
}