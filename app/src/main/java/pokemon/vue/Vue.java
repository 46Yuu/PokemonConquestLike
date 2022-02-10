package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import pokemon.controleur.Controleur;
import pokemon.modele.Terrain;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;


public class Vue extends JFrame{
	private JPanel panelTerrain=new JPanel();
	private JPanel panelInfos=new JPanel();
	private JPanel panelJoueurs=new JPanel();
	private JPanel panelBoutons=new JPanel();
	private Controleur controleur;
	public Terrain plateau;
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

	public Vue(Controleur c) {
		controleur=c;
		plateau=controleur.terrain;
		//Dimension dimensionEcran=Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle("Pokemon");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Accueil panelAccueil=new Accueil();
		setContentPane(panelAccueil);
		
		buttonCommencer.addActionListener( event -> {
			JPanel contentPane=new JPanel();
			setContentPane(contentPane);

		
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

			panelTerrain.setLayout(new GridLayout(terrain.length,terrain[0].length,1,1));

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
			
			revalidate();
		});
	}

	public class Tile extends JPanel{
		private BufferedImage image;
		private BufferedImage imagePokemon;
		private int x;
		private int y;
		private boolean pokemonPresent;

		public Tile(String path,int x, int y){
			try{
				image = ImageIO.read(new File(path));
				if(plateau.list.get(plateau.tab[x][y])!=null){
					pokemonPresent=true;
					imagePokemon = ImageIO.read(new File((plateau.list.get(plateau.tab[x][y]).getCheminImage())));
				}
			}catch(IOException e){
				System.out.println("File not found!");
			}setLayout(new BorderLayout());
			
			addMouseListener(new MouseDeplace());
		}

		private class MouseDeplace implements MouseInputListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				if(pokemonPresent){
					controleur.deplacerPokemon=true;
					controleur.anciennePosI=x;
					controleur.anciennePosY=y;
				}
				if(controleur.deplacerPokemon){
					controleur.deplacerPokemon(x,y);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		}

		public void setPokemonPresent(boolean val){
			pokemonPresent=val;
			repaint();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int height=getSize().height;
			int width=getSize().width;
			g.drawImage(image, 0, 0,width,height, this);
			if(pokemonPresent)//s'il y a un pokemon sur cette case, on le dessine 
				g.drawImage(imagePokemon, 0, 0,width,height, this);
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
