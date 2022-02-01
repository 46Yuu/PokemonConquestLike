import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Tile extends JPanel{
	private BufferedImage Img;
	private Image imgR;
	public Tile(int x, int y , int z){
		setBounds(x, y, z,z);
		File chemin = new File("../rock_texture.png");
		try {
			Img = ImageIO.read(chemin);
		}
		catch (IOException ex) {
			System.out.println("File not found.");
		}
		setLayout(new BorderLayout());
		imgR = Img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		//JLabel picLabel = new JLabel(new ImageIcon(Img.getScaledInstance(this.getWidth(), this.getHeight(), Img.SCALE_SMOOTH)));
		//this.add(picLabel);
		Color couleur = Color.blue;
		this.setBackground(couleur);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imgR, 0, 0, null);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Img.getWidth(this),Img.getHeight(this));
	}
	
}