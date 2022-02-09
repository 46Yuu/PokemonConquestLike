package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;


public class Vue extends JFrame{
	private JPanel panelTerrain=new JPanel();
	private JPanel panelInfos=new JPanel();
	private JPanel panelJoueurs=new JPanel();
	private JPanel panelBoutons=new JPanel();
	JButton buttonCommencer=new JButton("Jouer");
	enum Case{
		Grass("Grass"),Rock("Rock"),Lava("Lava"),Water("Water"),Roof("Roof");
		private final String type;
		private Case(String type){
			this.type = type;
		}
	}
	private Case[][] terrain = {
		{Case.Rock, Case.Rock , Case.Rock,Case.Rock, Case.Rock , Case.Rock},
		{Case.Rock, Case.Grass , Case.Grass,Case.Grass, Case.Grass , Case.Rock},
		{Case.Roof, Case.Roof , Case.Grass,Case.Grass, Case.Lava , Case.Lava},
		{Case.Roof, Case.Water , Case.Grass,Case.Grass, Case.Lava , Case.Lava},
		{Case.Roof, Case.Water , Case.Water,Case.Grass, Case.Grass , Case.Rock},
		{Case.Roof, Case.Water , Case.Water,Case.Rock, Case.Rock , Case.Rock},
	};

	public Vue() {
		Dimension dimensionEcran=Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle("Pokemon");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Accueil panelAccueil=new Accueil();
		setContentPane(panelAccueil);
		
		buttonCommencer.addActionListener( event -> {
			JPanel contentPane=new JPanel();
			setContentPane(contentPane);
			
			repaint();
		
			contentPane.setLayout(new GridLayout(0,2));
			panelTerrain.setBackground(Color.black);
			panelInfos.setBackground(Color.green);
			panelInfos.setLayout(new GridLayout(2,0));
			panelJoueurs.setBackground(Color.red);
			panelBoutons.setBackground(Color.GRAY);
			panelInfos.add(panelJoueurs);
			panelInfos.add(panelBoutons);

			contentPane.add(panelInfos);
			contentPane.add(panelTerrain);	

			panelTerrain.setLayout(new GridLayout(terrain.length,terrain[0].length));

			for(int i=0; i<terrain.length; i++){
				for(int j=0;j<terrain[i].length;j++){
					Case caseTmp = terrain[i][j];
					String path = "";
					switch(caseTmp){
						case Grass:
							path="src/main/resources/grass_texture.png";
							break;
						case Rock:
							path="src/main/resources/rock_texture.png";
							break;
						case Lava:
							path="src/main/resources/lava_texture.png";
							break;
						case Water:
							path="src/main/resources/water_texture.png";
							break;
						case Roof:
							path="src/main/resources/roof_texture.png";
							break;
					}
					panelTerrain.add(new Tile(path,i,j));
				}
			}
			
			setSize(dimensionEcran);
		});
	}

	public static class Tile extends JPanel{
		private BufferedImage image;
		private int x;
		private int y;

		public Tile(String path,int x, int y){
			try{
				image = ImageIO.read(new File(path));
			}catch(IOException e){
				System.out.println("File not found!");
			}setLayout(new BorderLayout());
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
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
			buttonCommencer.setBackground(Color.gray);
			panelButton.add(buttonCommencer);
			add(panelButton);	
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imageAcceuil, 0, 0, this);
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(imageAcceuil.getWidth(this),imageAcceuil.getHeight(this));
		}
	}
}
