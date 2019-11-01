package snake;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pontuacao extends JPanel{
	private JLabel pontuacao = new JLabel();
	private String rotulo = "Pontuação: ";
	private int pontos = 0;
	
	public Pontuacao() {
		this.add(pontuacao);
		rotula();
		this.setBackground(Color.GREEN);
		
		
	}
	
	public void addPontos(int value) {
		pontos += value;
		rotula();
	}
	
	public void rotula() {
		pontuacao.setText(rotulo + pontos);
	}
	
	public void decPontos(int value) {
		pontos -= value;
		rotula();
	}
}
