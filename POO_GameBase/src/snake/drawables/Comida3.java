package snake.drawables;

import java.awt.Color;
import java.awt.Graphics2D;

import drawables.Point;

public class Comida3 extends Point{
	private Color cor = Color.WHITE;
	
	public Comida3(double x, double y) {
		super(x, y);
	}
	public void draw(Graphics2D g2d) {
		g2d.setColor(cor);
		super.draw(g2d);
	}
}
