/**
 * @author Yuval Dahari
 * 209125939
 */

package common;

/**
 * Class to represent an objects' counter.
 */

public class Counter {
    private int count;

    /**
     * The function creates a new common.Counter.
     *
     * @param count (int)
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * The function increase the count member by number.
     *
     * @param number (int)
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * The function increase the count member by one.
     */
    public void increase() {
        this.count++;
    }

    /**
     * The function decrease the count member by number.
     *
     * @param number (int)
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * The function decrease the count member by one.
     */
    public void decrease() {
        this.count--;
    }

    /**
     * The function returns the count member.
     *
     * @return int - the count member.
     */
    public int getValue() {
        return this.count;
    }
}