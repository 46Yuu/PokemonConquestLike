package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pokemon.controleur.Controleur;
import pokemon.modele.attaque.Attaque;
import pokemon.modele.terrain.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Map;

public class Vue extends JFrame{
	private JPanel panelTerrain=new JPanel();
	private JPanel panelInfos=new JPanel();
	private JPanel panelJoueurs=new JPanel();
	//private JPanel panelBoutons=new JPanel();
	private JLabel labelJoueur=new JLabel();
	PanelBoutons panelBoutons=new PanelBoutons();
	private Controleur controleur;
	public Tile[][] arrayTile;
	public JButton buttonCommencer=new JButton("Jouer");
	
	public Vue(Controleur c) {
		controleur=c;
		arrayTile=new Tile[controleur.getHeight()][controleur.getWidth()];
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
			
			
			panelInfos.add(panelJoueurs);
			panelInfos.add(panelBoutons);
			panelJoueurs.add(labelJoueur);
			contentPane.add(panelInfos);
			contentPane.add(panelTerrain);

			panelTerrain.setLayout(new GridLayout(controleur.getHeight(),controleur.getWidth(),1,1));
			for(int i=0; i<controleur.getHeight(); i++){
				for(int j=0;j<controleur.getWidth();j++){
					String path = controleur.getPathImageTile(i, j);
					String pathSelect = controleur.getPathImageSelectTile(i, j);
					Tile tile=new Tile(path,pathSelect,i,j,controleur);
					panelTerrain.add(tile);
					arrayTile[i][j]=tile;
				}
			}
			revalidate();
			controleur.commencer();
		});

		panelBoutons.getBoutonAttaque().addActionListener(event ->{
			Map<String,Attaque> listAttaques=controleur.getListeAttaquesPokemon();
			int y = 0;
			panelBoutons.getBoutonAttaque().setVisible(false);
			panelBoutons.getBoutonFin().setVisible(false);
			
			panelBoutons.addListeBouton("Eclair");
			JButton tmp = panelBoutons.getBoutonDeListe("Eclair");
			panelBoutons.add(tmp);
			panelBoutons.setBoundsBouton(tmp,0,y);
			y=y+30;
			panelBoutons.addListeBouton("Vive-Attaque");
			JButton tmp2 = panelBoutons.getBoutonDeListe("Vive-Attaque");
			panelBoutons.add(tmp2);
			panelBoutons.setBoundsBouton(tmp2,0,y);
			y=y+30;

			

		});
		
		panelBoutons.getBoutonFin().addActionListener(event ->{
			panelBoutons.getBoutonFin().setVisible(false);
			panelBoutons.getBoutonAttaque().setVisible(false);
			controleur.getJeux().selectPokemon();
		});
	}

	/**
	 * affiche le joueur à qui c'est le tour sur le panel informations
	 * @param joueur "joueur 1" ou "joueur 2"
	 */
	public void miseAJourInformations(String joueur) {
		labelJoueur.setText("Tour du joueur : " + joueur );
	}

	/**
	 * sélectionne tous les tiles dont les coordonnées se trouvent dans la liste listPaires
	 * @param listPaires liste des coordonnées des tiles à sélectionner
	 */
	public void selectTiles(LinkedList<Pair> listPaires){
		for(Pair p : listPaires){
			selectTile(p.getFirst(),p.getSecond());
		}
	}

	/**
	 * désélectionne tous les tiles dont les coordonnées se trouvent dans la liste listPaires
	 * @param listPaires liste des coordonnées des tiles à désélectionner
	 */
	public void deselectTiles(LinkedList<Pair> listPaires){
		for(Pair p : listPaires){
			deselectTile(p.getFirst(),p.getSecond());
		}
	}

	/**
	 * sélectionne le tile de coordonnées (x,y)
	 * @param x coordonnée x sur le plateau
	 * @param y coordonnée y sur le plateau
	 */
	public void selectTile(int x, int y){
		arrayTile[x][y].select();
	}

	/**
	 * désélectionne le tile de coordonnées (x,y)
	 * @param x coordonnée x sur le plateau
	 * @param y coordonnée y sur le plateau
	 */
	public void deselectTile(int x, int y){
		arrayTile[x][y].deselect();
	}

	/**
	 * déplace le pokémon du tile qui a comme coordonnées tile1 vers le tile qui a comme coordonnées tile2
	 * @param tile1 une pair contenant les coordonnées du tile où se trouve le Pokémon à déplacer
	 * @param tile2 une pair contenant les coordonnées du tile où le Pokémon sera déplacé
	 * @param cheminImagePokemon le chemin de l'image du Pokémon
	 */
	public void deplacerPokemon(Pair tile1, Pair tile2, String pathImagePokemon){
		enleverPokemon(tile1.getFirst(),tile1.getSecond());
		placerPokemon(tile2.getFirst(),tile2.getSecond(),pathImagePokemon);
	}

	/**
	 * dessine le Pokémon sur le tile de coordonnées (x,y)
	 * @param x coordonnée x du tile dans le plateau
	 * @param y coordonnée y du tile dans le plateau
	 * @param cheminImagePokemon chemin de l'image du Pokémon
	 */
	public void placerPokemon(int x, int y, String pathImagePokemon){
		arrayTile[x][y].setPokemonPresent(true, pathImagePokemon);
	}

	/**
	 * enlève le Pokémon du le tile de coordonnées (x,y)
	 * @param x coordonnée x du tile dans le plateau
	 * @param y coordonnée y du tile dans le plateau
	 */
	public void enleverPokemon(int x, int y){
		arrayTile[x][y].setPokemonPresent(false, "");
	}

	public void showBoutons(){
		this.panelBoutons.getBoutonFin().setVisible(true);
		this.panelBoutons.getBoutonAttaque().setVisible(true);
	}
}
