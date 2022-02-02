package pokemon;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

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