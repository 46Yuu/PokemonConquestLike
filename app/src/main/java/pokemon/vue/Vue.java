package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pokemon.controleur.Controleur;
import pokemon.modele.terrain.*;
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
	public Tile[][] arrayTile;
	JButton buttonCommencer=new JButton("Jouer");
	
	public Vue(Controleur c) {
		controleur=c;
		plateau=controleur.terrain;
		arrayTile=new Tile[plateau.tab.length][plateau.tab[0].length];
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
			for(int i=0; i<plateau.tab.length; i++){
				for(int j=0;j<plateau.tab[i].length;j++){
					String path = controleur.getCheminImageTile(i, j);
					String pathSelect = controleur.getPathImageSelectTile(i, j);
					Tile tile=new Tile(path,pathSelect,i,j,plateau,controleur);
					panelTerrain.add(tile);
					arrayTile[i][j]=tile;
				}
			}
			revalidate();
			controleur.jouerTour();
		});

	}

	public void miseAjour(){
		for(int i=0; i<arrayTile.length; i++){
			for(int j=0; j<arrayTile[0].length; j++){	
				arrayTile[i][j].miseAJour();
			}	
		}
	}

	public void miseAJourInformations() {
		labelJoueur.setText("Tour du joueur : " + controleur.joueurActuel.getNom() );
	} 

	public void selectTiles(LinkedList<Pair> listPaires){
		for(Pair p : listPaires){
			arrayTile[p.getFirst()][p.getSecond()].setSelect(true);
			arrayTile[p.getFirst()][p.getSecond()].repaint();
		}
	}

	public void deselectTiles(LinkedList<Pair> listPaires){
		for(Pair p : listPaires){
			arrayTile[p.getFirst()][p.getSecond()].setSelect(false);
			arrayTile[p.getFirst()][p.getSecond()].repaint();
		}
	}
}
