package objetos;

import modelo.Tela;

public class Cobra {
	public int cobraX[] = new int[Tela.WIDTH * Tela.HEIGHT];
	public int cobraY[]	= new int[Tela.WIDTH * Tela.HEIGHT];
	public int length = 2;
	
	
	public Cobra() {
		cobraX[0]=500;
		cobraY[0]=45;
		cobraX[1] = 450;
		cobraY[1] = 45;
	}

}
