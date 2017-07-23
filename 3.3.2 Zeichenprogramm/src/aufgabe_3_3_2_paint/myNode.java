package aufgabe_3_3_2_paint;

/**
 *  @author Scharab Hessan
 */
public interface myNode extends Cloneable {
    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    myNode clone() throws CloneNotSupportedException;

    /**
     * Node bewegen.
     * @param xPos
     * @param yPos
     */
    void move(double xPos, double yPos);


    void bringToFront();
    void bringToBack();
    void setAlpha(double value);
}
