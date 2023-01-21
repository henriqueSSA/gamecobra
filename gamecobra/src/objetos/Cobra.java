package objetos;

import modelo.Tela;

public class Cobra{
	public int cobraX[] = new int[Tela.unidades];
	public int cobraY[] = new int[Tela.unidades];
	public int length =2;
	public char direcao = 'D';
	
	
	public void andar() {
		for(int i=this.length;i>0;i--) {
			this.cobraX[i] = this.cobraX[i-1];
			this.cobraY[i] = this.cobraY[i-1];
		}
		
		switch(this.direcao) {
		case 'C':
			this.cobraY[0] = this.cobraY[0] - Tela.SCALE;
			break;
		case 'B':
			this.cobraY[0] = this.cobraY[0] + Tela.SCALE;
			break;
		case 'E':
			this.cobraX[0] = this.cobraX[0] - Tela.SCALE;
			break;
		case 'D':
			this.cobraX[0] = this.cobraX[0] + Tela.SCALE;
			break;
		default:
			break;
			
		}
	}
	
	
	
	
	
	
}