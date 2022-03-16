package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pokemon.controleur.Controleur;
import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.*;
import java.awt.*;
import java.util.HashSet;
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
	private JButton buttonCommencer=new JButton("Jouer");
	
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
			panelJoueurs.setLayout(null);
			
			
			panelInfos.add(panelJoueurs);
			panelInfos.add(panelBoutons);
			panelJoueurs.add(labelJoueur);
			labelJoueur.setBounds(0,0,300,15);
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
			Map<String,Attaque> listeAttaques=controleur.getListeAttaquesPokemon();
			int y = 0;
			panelBoutons.getBoutonAttaque().setVisible(false);
			panelBoutons.getBoutonFin().setVisible(false);
			panelBoutons.getBoutonRetour().setVisible(true);
			for(String nom : listeAttaques.keySet()){
				panelBoutons.addListeBouton(nom);
				JButton tmp = panelBoutons.getBoutonDeListe(nom);
				addActionListenerBouton(nom,tmp);
				panelBoutons.add(tmp);
				panelBoutons.setBoundsBouton(tmp,0,y);
				y=y+30;
				tmp.setVisible(true);
			}

		});
		
		panelBoutons.getBoutonFin().addActionListener(event ->{
			panelBoutons.getBoutonFin().setVisible(false);
			panelBoutons.getBoutonAttaque().setVisible(false);
			controleur.getJeux().selectPokemon();
		});

		Map<Pokemon,Case> pokemonsJ1 = controleur.jeux.getPokemonCaseJoueur1();
		int yj1=45;
		JLabel j1=new JLabel("Pokemons de Joueur 1:");
		j1.setBounds(0,30,300,15);
		panelJoueurs.add(j1);
		for(Pokemon p: pokemonsJ1.keySet()){
			JLabel tmp=new JLabel(p.getNom()+" ("+p.getType()+") "+"| Pdv: "+p.getPdv()+"| Atk: "+p.getAtk());
			panelJoueurs.add(tmp);
			tmp.setBounds(0,yj1,300,15);
			yj1+=15;
		}

		Map<Pokemon,Case> pokemonsJ2 = controleur.jeux.getPokemonCaseJoueur2();
		int yj2=115;
		JLabel j2=new JLabel("Pokemons du Jouer 2:");
		j2.setBounds(0,100,300,15);
		panelJoueurs.add(j2);
		for(Pokemon p: pokemonsJ2.keySet()){
			JLabel tmp=new JLabel(p.getNom()+" ("+p.getType()+") "+"| Pdv: "+p.getPdv()+" | Atk: "+p.getAtk());
			panelJoueurs.add(tmp);
			tmp.setBounds(0,yj2,300,15);
			yj2+=15;
		}
	}

	public void addActionListenerBouton(String nom,JButton b){
		b.addActionListener(event ->{
			//fonction de choix du pokemon a attaquer.
			panelBoutons.getBoutonRetour().setVisible(false);
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
	public void selectTiles(HashSet<Pair> listPaires){
		for(Pair p : listPaires){
			selectTile(p.getFirst(),p.getSecond());
		}
	}

	/**
	 * désélectionne tous les tiles dont les coordonnées se trouvent dans la liste listPaires
	 * @param listPaires liste des coordonnées des tiles à désélectionner
	 */
	public void deselectTiles(HashSet<Pair> listPaires){
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
