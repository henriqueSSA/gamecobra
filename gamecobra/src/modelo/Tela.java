package modelo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import objetos.Cobra;
import objetos.Fruta;

public class Tela extends JPanel implements ActionListener{
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 750;
	public static final int SCALE = 50;
	public static final int unidades = WIDTH * HEIGHT / (SCALE * SCALE);
	public static final int SPEED = 200;
	public boolean statusJogo = false;
	public boolean[] key_states = new boolean[256];
	Timer t;
	Fruta fruta = new Fruta();
	Cobra cobra = new Cobra();
	
	public Tela() {
		setPreferredSize(new Dimension(Tela.WIDTH,Tela.HEIGHT));
		setFocusable(true);
		addKeyListener(new KeyboardAdapter());
		startJogo();
	}
	
	public void startJogo() {
		setBackground(Color.WHITE);
		t = new Timer(Tela.SPEED,this);
		t.start();
		fruta.setRandom();
		statusJogo = true;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if(statusJogo) {
			g.setColor(Color.RED);
			g.fillOval(fruta.frutaX, fruta.frutaY, Tela.SCALE, Tela.SCALE);
			if(cobra.length == 2) {
				g.setColor(Color.GREEN);
				g.fillRect(cobra.cobraX[0], cobra.cobraY[0], Tela.SCALE, Tela.SCALE);
				g.setColor(new Color(45,180,0));
				g.fillRect(cobra.cobraX[1], cobra.cobraY[1], Tela.SCALE, Tela.SCALE);
			}else {
				for(int i=0;i<cobra.length;i++) {
					g.setColor(Color.GREEN);
					g.fillRect(cobra.cobraX[0], cobra.cobraY[0], Tela.SCALE, Tela.SCALE);
					g.setColor(new Color(45,180,0));
					g.fillRect(cobra.cobraX[i], cobra.cobraY[i], Tela.SCALE, Tela.SCALE);
				}
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(statusJogo) {
			cobra.andar();
			comerFruta();
			if(key_states[KeyEvent.VK_UP]) {
				cobra.direcao = 'C';
			}else if(key_states[KeyEvent.VK_DOWN]) {
				cobra.direcao = 'B';
			}else if(key_states[KeyEvent.VK_LEFT]) {
				cobra.direcao = 'E';
			}else if(key_states[KeyEvent.VK_RIGHT]) {
				cobra.direcao = 'D';
			}
		}
		
		repaint();
		
	}
	
	public void comerFruta() {
		if((cobra.cobraX[0] == fruta.frutaX) && (cobra.cobraY[0] == fruta.frutaY)) {
			fruta.setRandom();
			cobra.length++;
		}
	}
	
	private class KeyboardAdapter extends KeyAdapter{
		
		@Override
		public void keyReleased(KeyEvent e) {
			key_states[e.getKeyCode()] = false;
		}
		@Override
		public void keyPressed(KeyEvent e) {
			key_states[e.getKeyCode()] = true;
		}
	}
	
}
