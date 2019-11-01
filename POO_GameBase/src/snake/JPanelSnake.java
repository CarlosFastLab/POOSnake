package snake;

import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.JPanelDraw;
import drawables.Point;
import snake.drawables.Comida1;
//nova linha
import snake.drawables.Comida2;
import snake.drawables.Comida3;
//import drawables.SpaceCraft;
import snake.drawables.Snake;

@SuppressWarnings("serial")
public class JPanelSnake extends JPanelDraw {
	private Snake cobra;
	private Comida2 comida2;
	private Comida1 comida1;
	private Comida3 comida3;
	static String teste = "Teste";
	public static final Pontuacao SCORE = new Pontuacao();
	boolean rodando = true;

	public JPanelSnake(int largura, int altura) {
		super(largura, altura);
	}

	@Override
	protected void inicializar() {
		cobra = new Snake(tela.halfWidth(), tela.halfHeight());
		int[] xy = getRandomCoord();
		comida2 = new Comida2 (xy[0], xy[1]);
		comida1 = new Comida1 (xy[0], xy[1]);
		comida3 = new Comida3(xy[0], xy[1]);

	}

	@Override
	public void loop() {
		if(rodando) {
		this.sleeping(50);
		if (comida3.equals(cobra.getHead())) {
			cobra.addToTail(new Point(comida3.X, comida3.Y));
			int[] xy = getRandomCoord();
			comida3.moveTO(xy[0], xy[1]);
			SCORE.addPontos(3);
			
		}if (comida2.equals(cobra.getHead())) {
			cobra.addToTail(new Point(comida2.X, comida2.Y));
			int[] xy = getRandomCoord();
			comida2.moveTO(xy[1], xy[1]);
			SCORE.addPontos(10);
			
		} if (comida1.equals(cobra.getHead())) {
			cobra.addToTail(new Point(comida1.X, comida1.Y));
			int[] xy = getRandomCoord();
			comida1.moveTO(xy[0], xy[1]);
			SCORE.decPontos(2);
		} if (cobra.isComendoTail()) {
			SCORE.decPontos(1);
		}	
		if (cobra.moveInversoX()) {
			SCORE.decPontos(1);
		}
		
		if (cobra.moveInversoY()) {
			SCORE.decPontos(1);
		}
		
		cobra.move();

		}
	}

	@Override
	protected void renderizar() {
		this.tela.draw(cobra);
		this.tela.draw(comida3);
		this.tela.draw(comida1);
		this.tela.draw(comida2);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		final JFrame parent = new JFrame();
		if (k == KeyEvent.VK_ESCAPE) {
			rodando = false;
			JOptionPane.showMessageDialog(parent,
                    "Seu score foi de "+SCORE.getPontos());
			System.exit(0);
		}

		cobra.eventoKey(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private int[] getRandomCoord() {
		Random r = new Random();
		int[] array = new int[2];
		array[0] = r.nextInt() % ((int) cobra.MAX_X - Point.SIZE);
		array[1] = r.nextInt() % ((int) cobra.MAX_Y - Point.SIZE);

		return array;
	}
}
