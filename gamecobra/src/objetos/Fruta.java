package objetos;

import modelo.Tela;

public class Fruta {
	public int posX;
	public int posY;
	
	
	public Fruta(int startX, int startY) {
		this.posX = startX;
		this.posY = startY;
	}
	
	public void setRandom() {
		this.posX = (int) (Math.random() * Tela.WIDTH);
		this.posY = (int) (Math.random() * Tela.HEIGHT);
				
	}
}
