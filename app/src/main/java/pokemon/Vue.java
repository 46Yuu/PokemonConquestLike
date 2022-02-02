package pokemon;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vue extends JFrame{

	private Tile[][] terrain;
	private JPanel conteneur;
	
	public Vue() {
		int x = 50;
		int y = 50;
		this.terrain = new Tile[11][11];
		for(int i =0;i<terrain.length;i++) {
			for(int j=0;j<terrain[i].length;j++) {
				terrain[i][j] = new Tile(x,y,60);
				x=x+60;
			}
			x=50;
			y=y+60;		
		}
		
		this.setTitle("Terrain");
		setSize(800, 800);
		
		conteneur = new JPanel();
		conteneur.setLayout(null);
		for(int i =0;i<terrain.length;i++) {
			for(int j=0;j<terrain[i].length;j++) {
				conteneur.add(terrain[i][j]);
			}
        }
		this.add(conteneur);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Vue test = new Vue();
		test.setVisible (true);
	}
}
