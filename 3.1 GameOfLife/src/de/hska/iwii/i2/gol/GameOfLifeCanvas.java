package de.hska.iwii.i2.gol;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;


public class GameOfLifeCanvas extends Canvas {
	
	private Stop[] stops = new Stop[] {new Stop(0.0, GameOfLifeApplication.DARK_CELL_COLOR), new Stop(1.0, GameOfLifeApplication.BRIGHT_CELL_COLOR)};
	

	private boolean[][] currentStartGeneration;

	private GameOfLifeLogic gol;
	public GameOfLifeCanvas(GameOfLifeLogic gol, double width, double height) {
		super(width, height);
		this.gol = gol;
		paint();
	}

	public void paint() {
		GraphicsContext gc = getGraphicsContext2D();

		gc.setFill(GameOfLifeApplication.BACKGROUND_COLOR);
		gc.fillRect(0.0,  0.0, getWidth(), getHeight());

		if (currentStartGeneration != null) {
			int cellWidth  = (int) (getWidth()  / currentStartGeneration.length);
			int cellHeight = (int) (getHeight() / currentStartGeneration[ 0 ].length);

			cellWidth = Math.min(cellWidth, cellHeight);
			cellHeight = cellWidth;

			gc.setStroke(Color.BLACK);
			gc.setLineWidth(1.0);

			for (int x = 0; x < currentStartGeneration.length + 1; x++) {
				gc.strokeLine(x * cellWidth, 0, x * cellWidth, currentStartGeneration[ 0 ].length * cellHeight);
			}
			for (int y = 0; y < currentStartGeneration[ 0 ].length + 1; y++) {
				gc.strokeLine(0, y * cellHeight, currentStartGeneration.length * cellWidth, y * cellHeight);
			}

			for (int x = 0; x < currentStartGeneration.length; x++) {
				for (int y = 0; y < currentStartGeneration[ 0 ].length; y++) {
					gc.setFill(new LinearGradient(0.0, 0.0, 1.0, 1.0, true, CycleMethod.NO_CYCLE, stops));
					if (gol.isCellAlive(x, y)) {
						gc.fillOval(1 + x * cellWidth, 1 + y * cellHeight, cellWidth - 2, cellHeight - 2);
					}
				}
			}
		}
	}
	
	public void setStartGeneration(boolean[][] startGeneration) {
		this.currentStartGeneration = startGeneration;
	}

	@Override
	public boolean isResizable() {
		return true;
	}

	@Override
	public void resize(double width, double height) {
		super.resize(width, height);
		setWidth(width);
		setHeight(height);
		paint();
	}

	@Override
	public double maxHeight(double arg0) {
		return Double.MAX_VALUE;
	}

	@Override
	public double maxWidth(double arg0) {
		return Double.MAX_VALUE;
	}


	@Override
	public double minHeight(double arg0) {
		return 100;
	}

	@Override
	public double minWidth(double arg0) {
		return 100;
	}
}

