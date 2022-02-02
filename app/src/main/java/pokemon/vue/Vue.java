package pokemon.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


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
	
	



	public class Tile extends JPanel{

		private Image image;
		private Image imgR;
	
		public Tile(int x, int y , int z){
			setBounds(x, y, z,z);
			try{
				image = ImageIO.read(new File("src/main/resources/grass_texture.png"));
				imgR = image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
			}catch(IOException e){
				System.out.println("File not found!");
			}setLayout(new BorderLayout());
			//JLabel picLabel = new JLabel(new ImageIcon(Img.getScaledInstance(this.getWidth(), this.getHeight(), Img.SCALE_SMOOTH)));
			//this.add(picLabel);
			//Color couleur = Color.blue;
			//this.setBackground(couleur);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imgR, 0, 0, null);
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(image.getWidth(this),image.getHeight(this));
		}
		
	}
}
