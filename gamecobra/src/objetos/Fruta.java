package objetos;

import java.util.Random;

import modelo.Tela;

public class Fruta{
	public int frutaX;
	public int frutaY;
	Random random;
	
	
	public void setRandom() {
		this.frutaX = new Random().nextInt(Tela.WIDTH / Tela.SCALE)* Tela.SCALE;
		this.frutaY = new Random().nextInt(Tela.HEIGHT / Tela.SCALE)* Tela.SCALE;
	}
	
}
