package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;

import javax.swing.JPanel;

import objetos.Cobra;
import objetos.Fruta;





public class Tela extends JPanel implements Runnable{
	public static final int SCALE =50;
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 750;
	public static final int SPEED = 150;
	public boolean statusJogo = false;
	private boolean[] key_states = new boolean[256];
	public Cobra cobra = new Cobra();
	public Fruta fruta = new Fruta(55,60);
	public char direcao = 'E';
	
	public Tela() {
		setDoubleBuffered(true);
		setFocusable(true);
		load();
		new Thread(this).start();
	}

	
	@Override
	public void run() {
		double btime, dtime = 0;
		btime = System.currentTimeMillis();
		while(true) {
			update(dtime/1000);
			repaint();
			try {
				Thread.sleep(1);
			}catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			dtime = (System.currentTimeMillis() - btime);
			btime = System.currentTimeMillis();
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	private void load() {
		setBackground(Color.WHITE);
		statusJogo = true;
		
	}

	private void update(double d) {
		
		
	}
	
	private void draw(Graphics g) {
		if(statusJogo) {
			g.setColor(Color.RED);
			g.fillOval(fruta.posX, fruta.posY, Tela.SCALE, Tela.SCALE);
			g.setColor(Color.green);
			g.fillRect(cobra.cobraX[0], cobra.cobraY[0], Tela.SCALE, Tela.SCALE);
			g.setColor(new Color(45,100,0));
			g.fillRect(cobra.cobraX[1], cobra.cobraY[1], Tela.SCALE, Tela.SCALE);
		}
	}
	
	
	
}
