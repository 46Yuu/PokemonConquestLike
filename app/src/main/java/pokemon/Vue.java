import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Vue extends JFrame{
	private Tile[][] terrain;
	private JPanel conteneur;
	public Vue() {
		int x = 50;
		int y = 50;
		this.terrain = new Tile[3][3];
		for(int i =0;i<terrain.length;i++) {
			for(int j=0;j<terrain[i].length;j++) {
				terrain[i][j] = new Tile(x,y,60);
				x=x+61;
			}
			x=50;
			y=y+61;		
		}
		
		this.setTitle("Terrain");
		setSize(1000, 1000);
		
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
