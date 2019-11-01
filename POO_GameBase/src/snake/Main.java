package snake;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Main extends JFrame {

	
	public Main() {
		int largura = 600, altura = 730;
		setTitle("Snake 2D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new JPanelSnake(largura, altura));
		add(JPanelSnake.SCORE, BorderLayout.SOUTH);
				
		setSize(largura, altura);
		setLocationRelativeTo(null);
				
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
