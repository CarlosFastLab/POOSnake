package snake.drawables;

import java.awt.Graphics2D;
import java.awt.Color;

import drawables.Point;

public class Comida2 extends Point {
	private Color cor = Color.GREEN;
	public Comida2(double x, double y) {
		super(x, y);
	}
	public void draw (Graphics2D g2d) {
		g2d.setColor(cor);
		super.draw(g2d);
	}
}
