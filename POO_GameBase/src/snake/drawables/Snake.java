package snake.drawables;

import java.awt.Color;

import snake.JPanelSnake;
import snake.Pontuacao;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import core.BaseLimitedDrawable;
import drawables.Point;

public class Snake extends BaseLimitedDrawable {
	private final Color HEAD_COLOR = Color.GREEN;

	private final Point HEAD = new Point(0, 0);
	private final List<Point> TAIL = new ArrayList<>();
	public static final Pontuacao SCORE = JPanelSnake.SCORE;

	private int fluxoX = -Point.SIZE;
	private int fluxoY = 0;
	public Snake(double xMax, double yMax) {
		super(xMax, yMax);
				
		for (int i = 1; i<=6; i++) {
			TAIL.add(new Point(Point.SIZE*i, 0));
		}
	}
	public Point getHead() { return HEAD; }
	public void addToTail(Point p) { TAIL.add(p); }
	
	@Override
	public void draw(Graphics2D g2d) {
		
		final Color TAIL_COLOR = Color.CYAN;
		
		Color corT = g2d.getColor();
		g2d.setColor(TAIL_COLOR);
		TAIL.forEach(p -> {p.draw(g2d);});
		g2d.setColor(corT);

		Color cor = g2d.getColor();
		g2d.setColor(HEAD_COLOR);
		HEAD.draw(g2d);
		g2d.setColor(cor);
	
	}
	

	public void eventoKey(KeyEvent e) {
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_UP) this.up();
		else if (k == KeyEvent.VK_DOWN) this.down();
		else if (k == KeyEvent.VK_LEFT) this.left();
		else if (k == KeyEvent.VK_RIGHT) this.right();

	}

	public void move() {
		
		for (int i = TAIL.size()-1; i>=1; i--) {
			Point ultimo = TAIL.get(i);
			Point penultimo = TAIL.get(i-1);
			ultimo.moveTO(penultimo.X, penultimo.Y);		
		}
		
		TAIL.get(0).moveTO(HEAD.X, HEAD.Y);
		
		HEAD.moveIncremental(fluxoX, fluxoY);
	}
	
	public void moveInversoX() {
				
		if(Math.abs(HEAD.X)>this.MAX_X) {
			HEAD.X = -HEAD.X;
			SCORE.decPontos(1);
			
		}
	}
	
	public void moveInversoY() {
		if(Math.abs(HEAD.Y)>this.MAX_Y) {
			HEAD.Y = -HEAD.Y;
			SCORE.decPontos(1);
		}
		

	}

	private void right() {
		if (fluxoX == 0) {
			fluxoX = Point.SIZE;
			fluxoY = 0;
		}
	}
	private void left() {
		if (fluxoX == 0) {
			fluxoX = -Point.SIZE;
			fluxoY = 0;
		}
	}
	private void down() {
		if (fluxoY == 0) {
			fluxoY = -Point.SIZE;
			fluxoX = 0;
		}
	}
	private void up() {
		if (fluxoY == 0) {
			fluxoY = Point.SIZE;
			fluxoX = 0;
		}
	}

}


