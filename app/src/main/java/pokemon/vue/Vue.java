package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;


public class Vue extends JFrame{

	private Tile[][] terrain;
	private JPanel panelTerrain=new JPanel();
	private JPanel panelInfos=new JPanel();
	private JPanel panelJoueurs=new JPanel();
	private JPanel panelBoutons=new JPanel();
	JButton buttonCommencer=new JButton("Jouer");
	
	public Vue() {
		//Dimension dimensionEcran=Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle("Pokemon");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Accueil panelAccueil=new Accueil();
		setContentPane(panelAccueil);
		
		buttonCommencer.addActionListener( event -> {
			new nouvelInterface().execute();
		});
	}

	public class nouvelInterface<T, V> extends SwingWorker<T,V>{
		public T doInBackground(){
			setContentPane(new JPanel());
			getContentPane().repaint();
			setLayout(new GridLayout(0,2));
			panelTerrain.setBackground(Color.black);
			panelInfos.setBackground(Color.green);
			panelInfos.setLayout(new GridLayout(2,0));
			panelJoueurs.setBackground(Color.red);
			panelBoutons.setBackground(Color.GRAY);
			panelInfos.add(panelJoueurs);
			panelInfos.add(panelBoutons);

			add(panelInfos);
			add(panelTerrain);	
			return null;
		}

	}
	

	public class Tile extends JPanel{

		private BufferedImage image;
		
	
		public Tile(int x, int y , int z){
			setBounds(x, y, z,z);
			try{
				image = ImageIO.read(new File("src/main/resources/grass_texture.png"));
			}catch(IOException e){
				System.out.println("File not found!");
			}setLayout(new BorderLayout());
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(image.getWidth(this),image.getHeight(this));
		}
		
	}

	public class Accueil extends JPanel{
		private BufferedImage imageAcceuil;

		public Accueil(){
			try{
				imageAcceuil = ImageIO.read(new File("src/main/resources/banniere-conquest.png"));
			}catch(IOException e){
				System.out.println("File not found!");
			}setLayout(new BorderLayout());
			this.setPreferredSize(new Dimension(imageAcceuil.getWidth(),imageAcceuil.getHeight()));
			setLayout(null);
			JPanel panelButton=new JPanel();
			panelButton.setBounds(imageAcceuil.getWidth()/2-50,imageAcceuil.getHeight()/2,100,30);
			panelButton.setLayout(null);
			buttonCommencer.setBounds(0,0,100,30);
			panelButton.add(buttonCommencer);
			add(panelButton);	
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imageAcceuil, 0, 0, null);
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(imageAcceuil.getWidth(this),imageAcceuil.getHeight(this));
		}
	}
}
