package modelo;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	public Main() {
		add(new Tela());
		setTitle("Snake Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	
	  public static void main(String[] args) {
	        new Main();
	    }
	 
}