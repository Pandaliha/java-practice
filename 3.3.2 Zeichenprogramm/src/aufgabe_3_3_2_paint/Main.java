package aufgabe_3_3_2_paint;

import javafx.application.Application;

/**
 * @author Saliha Hessan
 */
public class Main {
    public static void main (String args[]) {
        DrawPane canvas = new DrawPane(800, 500);
        canvas.setStyle("-fx-background-color: lightgrey;");

        DrawingListener listener = new DrawingListenerImplementation(canvas);

        MainWindow.setDrawingListener(listener);
        MainWindow.setMainPanel(canvas);
        MainWindow.setHorizontalToolBar(false);
        Application.launch(MainWindow.class, args);
    }
}
