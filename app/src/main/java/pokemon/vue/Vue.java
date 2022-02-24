package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pokemon.controleur.Controleur;
import pokemon.modele.terrain.*;
import pokemon.modele.terrain.Case.TypeCase;

import java.awt.*;
import java.util.LinkedList;


public class Vue extends JFrame{
	private JPanel panelTerrain=new JPanel();
	private JPanel panelInfos=new JPanel();
	private JPanel panelJoueurs=new JPanel();
	private JPanel panelBoutons=new JPanel();
	private JLabel labelJoueur=new JLabel();
	private Controleur controleur;
	public Terrain plateau;
	public LinkedList<Tile> listTile=new LinkedList<>();
	JButton buttonCommencer=new JButton("Jouer");
	
	public Vue(Controleur c) {
		controleur=c;
		plateau=controleur.terrain;
		//Dimension dimensionEcran=Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle("Pokemon");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Accueil panelAccueil=new Accueil(buttonCommencer);
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
			panelJoueurs.add(labelJoueur);

			contentPane.add(panelInfos);
			contentPane.add(panelTerrain);	

			panelTerrain.setLayout(new GridLayout(plateau.tab.length,plateau.tab[0].length,1,1));
			int k=0;
			for(int i=0; i<plateau.tab.length; i++){
				for(int j=0;j<plateau.tab[i].length;j++){
					TypeCase caseTmp = plateau.tab[i][j].getType();
					String path = "";
					String pathSelect = "";
					switch(caseTmp){
						case Grass:
							path="src/main/resources/grass_texture.png";
							pathSelect="src/main/resources/grass_texture_select.png";
							break;
						case Rock:
							path="src/main/resources/rock_texture.png";
							pathSelect="src/main/resources/rock_texture_select.png";
							break;
						case Lava:
							path="src/main/resources/lava_texture.png";
							pathSelect="src/main/resources/lava_texture_select.png";
							break;
						case Water:
							path="src/main/resources/water_texture.png";
							pathSelect="src/main/resources/water_texture_select.png";
							break;
						case Roof:
							path="src/main/resources/roof_texture.png";
							pathSelect="src/main/resources/roof_texture_select.png";
							break;
					}
					Tile tile=new Tile(path,pathSelect,i,j,k,plateau,controleur);
					k++;
					panelTerrain.add(tile);
					listTile.add(tile);
				}
			}
			revalidate();
			controleur.jouerTour();
		});

	}

	public void miseAjour(){
		for(Tile t : listTile)
			t.miseAJour();
	}

	public void miseAJourInformations() {
		labelJoueur.setText("Tour du joueur : " + controleur.joueurActuel.getNom() );
	}
}
