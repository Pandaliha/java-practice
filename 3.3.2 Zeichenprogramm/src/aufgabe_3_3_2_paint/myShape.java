package aufgabe_3_3_2_paint;

import javafx.scene.paint.Color;

/**
 *  @author Saliha Hessan
 */
public interface myShape extends myNode {

    void draw(double xStart, double yStart, double xPos, double yPos);


    void setBorderColor(Color color);

    void setBorderWidth(double width);

    void setFillColor(Color color);
}
