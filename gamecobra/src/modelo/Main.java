package modelo;

import javax.swing.JFrame;



public class Main extends JFrame{
	
	public Main() {
		setTitle("Snake Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Tela());
		setSize(Tela.WIDTH,Tela.HEIGHT);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Main().setVisible(true);

	}

}
