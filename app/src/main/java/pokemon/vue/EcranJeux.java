package pokemon.vue;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pokemon.controleur.Controleur;
import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Pair;

public class EcranJeux extends JFrame{
    private JPanel panelTerrain=new JPanel();
	private JPanel panelInfos=new JPanel();
	private PanelJoueurs panelJoueurs;
	private JLabel labelJoueur=new JLabel();
	PanelBoutons panelBoutons;
	private Controleur controleur;
	public Tile[][] arrayTile;
	private JButton buttonRecommencer;
    
    public EcranJeux(Controleur c, JButton buttonRecommencer, String joueur){ 
		//avoir la dimension de l'écran   
		Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		int height = bounds.height;
		int width  = bounds.width;
		setPreferredSize(new Dimension(width/2,6*height/7));
		setSize(new Dimension(width/2,6*height/7));
		//placer les JFrames sur l'écran
		if(joueur=="Joueur 1")
			setLocation(0,0);
		else
			setLocation((int)(width/2+bounds.getX()), 0);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(joueur);   
        controleur=c; 
        panelBoutons=new PanelBoutons(controleur, buttonRecommencer);
		arrayTile=new Tile[controleur.getHeight()][controleur.getWidth()];
		setLayout(new GridLayout(0,2));
		panelTerrain.setBackground(Color.black);
		panelInfos.setBackground(Color.green);
		panelInfos.setLayout(new GridLayout(2,0));
		panelJoueurs=new PanelJoueurs(controleur);
		panelJoueurs.setBackground(Color.DARK_GRAY);
		panelJoueurs.setLayout(null);
		panelInfos.add(panelJoueurs);
		panelInfos.add(panelBoutons);
		panelJoueurs.add(labelJoueur);
		labelJoueur.setBounds(0,0,300,15);
		labelJoueur.setForeground(Color.white);
		add(panelInfos);
		add(panelTerrain);
		panelTerrain.setLayout(new GridLayout(controleur.getHeight(),controleur.getWidth(),1,1));
		for(int i=0; i<controleur.getHeight(); i++){
			for(int j=0;j<controleur.getWidth();j++){
				String path = controleur.getPathImageTile(i, j);
				String pathSelect = controleur.getPathImageSelectTile(i, j);
				String pathAttaque = controleur.getPathImageAttaqueTile(i, j);
				Tile tile=new Tile(path,pathSelect,pathAttaque,i,j,controleur);
				panelTerrain.add(tile);
				arrayTile[i][j]=tile;
			}
		}

        panelBoutons.getBoutonAttaque().addActionListener(event ->{
			Map<String,Attaque> listeAttaques=controleur.getListeAttaquesPokemon();
			panelBoutons.getBoutonAttaque().setVisible(false);
			panelBoutons.getBoutonFin().setVisible(false);
			panelBoutons.getBoutonRetour().setVisible(true);
			panelBoutons.getListeBoutonAttaque().clear();
			for(String nom : listeAttaques.keySet()){
				panelBoutons.addListeBouton(nom);
				JButton tmp = panelBoutons.getBoutonDeListe(nom);
				tmp.addActionListener(e ->{
					controleur.colorerCasesAAttaquer(nom);
				});
				addActionListenerBouton(nom,tmp);
				panelBoutons.add(tmp);
				tmp.setVisible(true);
			}
			panelBoutons.repaint();
		});
		
		panelBoutons.getBoutonFin().addActionListener(event ->{
			int x=controleur.getCoordonneesPokemonActuel().getFirst();
			int y=controleur.getCoordonneesPokemonActuel().getSecond();
			deselectTile(x, y);
			enleverFleche(x, y);
			panelBoutons.getBoutonFin().setVisible(false);
			panelBoutons.getBoutonAttaque().setVisible(false);
			controleur.getJeux().selectPokemon();
		});
		
		this.buttonRecommencer=buttonRecommencer;
	}

	public void initialiser(Controleur c) {
		controleur=c;
		panelInfos.removeAll();
		panelTerrain.removeAll();
		panelJoueurs.removeAll();
		panelBoutons.removeAll();
        panelBoutons=new PanelBoutons(controleur, buttonRecommencer);
		arrayTile=new Tile[controleur.getHeight()][controleur.getWidth()];
		
		panelJoueurs=new PanelJoueurs(controleur);
		panelJoueurs.setBackground(Color.DARK_GRAY);
		panelJoueurs.setLayout(null);
			
		panelInfos.add(panelJoueurs);
		panelInfos.add(panelBoutons);
		panelJoueurs.add(labelJoueur);
		labelJoueur.setBounds(0,0,300,15);
		labelJoueur.setForeground(Color.white);

		panelTerrain.setLayout(new GridLayout(controleur.getHeight(),controleur.getWidth(),1,1));
		for(int i=0; i<controleur.getHeight(); i++){
			for(int j=0;j<controleur.getWidth();j++){
				String path = controleur.getPathImageTile(i, j);
				String pathSelect = controleur.getPathImageSelectTile(i, j);
				String pathAttaque = controleur.getPathImageAttaqueTile(i, j);
				Tile tile=new Tile(path,pathSelect,pathAttaque,i,j,controleur);
				panelTerrain.add(tile);
				arrayTile[i][j]=tile;
			}
		}

        panelBoutons.getBoutonAttaque().addActionListener(event ->{
			Map<String,Attaque> listeAttaques=controleur.getListeAttaquesPokemon();
			panelBoutons.getBoutonAttaque().setVisible(false);
			panelBoutons.getBoutonFin().setVisible(false);
			panelBoutons.getBoutonRetour().setVisible(true);
			panelBoutons.getListeBoutonAttaque().clear();
			for(String nom : listeAttaques.keySet()){
				panelBoutons.addListeBouton(nom);
				JButton tmp = panelBoutons.getBoutonDeListe(nom);
				tmp.addActionListener(e ->{
					controleur.colorerCasesAAttaquer(nom);
				});
				addActionListenerBouton(nom,tmp);
				panelBoutons.add(tmp);
				tmp.setVisible(true);
			}
			panelBoutons.repaint();
		});
		
		panelBoutons.getBoutonFin().addActionListener(event ->{
			int x=controleur.getCoordonneesPokemonActuel().getFirst();
			int y=controleur.getCoordonneesPokemonActuel().getSecond();
			deselectTile(x, y);
			enleverFleche(x, y);
			panelBoutons.getBoutonFin().setVisible(false);
			panelBoutons.getBoutonAttaque().setVisible(false);
			controleur.getJeux().selectPokemon();
		});
		revalidate();
	}

    private void enleverFleche(int x, int y) {
		arrayTile[x][y].enleverFleche();
	}

	public void addActionListenerBouton(String nom,JButton b){
		b.addMouseListener(new java.awt.event.MouseAdapter() {
			boolean clicked = false;
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				controleur.colorerCasesAAttaquer(nom);
			}
		
			public void mouseExited(java.awt.event.MouseEvent evt) {
				if(!clicked){
					controleur.decolorerCasesAAttaquer();
				}
			}
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//fonction de choix du pokemon a attaquer.
				for(String key : panelBoutons.getListeBoutonAttaque().keySet()){
					panelBoutons.getBoutonDeListe(key).setVisible(false);
				}
				clicked = true;
				//panelBoutons.getBoutonRetour().setVisible(false);
				controleur.colorerCasesAAttaquer(nom);
			}
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
	 * mets à jour l'affichage des stats du pokemon p dans le panelJoueur 
	 * @param p Pokemon
	 */
	public void miseAJourInfosPokemons(Pokemon p, boolean joueur1){
		StatsPokemon tmp=panelJoueurs.getStatsPokemons(joueur1).get(p);
		tmp.setPdv(p.getPdv());
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

	public void colorerCasesAAttaquer(HashSet<Pair> casesAAttaquer){
		for(Pair p : casesAAttaquer)
			coloreCaseAAttaquer(p.getFirst(), p.getSecond());
	}
	public void decolorerCasesAAttaquer(HashSet<Pair> casesAAttaquer){
		for(Pair p : casesAAttaquer)
			decolorerCaseAAttaquer(p.getFirst(), p.getSecond());
	}
	public void coloreCaseAAttaquer(int x, int y){
		arrayTile[x][y].colorerCaseAAttaquer();
	}
	public void decolorerCaseAAttaquer(int x, int y){
		arrayTile[x][y].decolorerCaseAAttaquer();
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

	/**
	 * affiche le jouuer gagnant à la place du panel des boutons
	 * @param JoueurGagnat joueur 1 ou joueur 2
	 */
	public void afficherFinPartie(boolean joueurGagnant){
		panelBoutons.removeAll();
        int height=panelBoutons.getSize().height;
        int width=panelBoutons.getSize().width;
        try{
			if(joueurGagnant==true)
				panelBoutons.afficherFinPartie(ImageIO.read(new File("src/main/resources/winner.png")));
			else
				panelBoutons.afficherFinPartie(ImageIO.read(new File("src/main/resources/loser.png")));
		}catch(IOException e){
			System.out.println("impossible d'ouvrir l'image de fin de partie");
		}
		panelBoutons.add(buttonRecommencer);
		buttonRecommencer.setBounds(0,height/6,width,height/6);
        panelBoutons.setBackground(Color.white);
	}
	
	public void cibleVisible(Pokemon p){
		if(panelJoueurs.getStatsPokemons(true).containsKey(p))
			panelJoueurs.getStatsPokemons(true).get(p).cibleVisible(true);
		else if(panelJoueurs.getStatsPokemons(false).containsKey(p))
			panelJoueurs.getStatsPokemons(false).get(p).cibleVisible(true);

	}

	public void cibleInvisible(Pokemon p){
		if(panelJoueurs.getStatsPokemons(true).containsKey(p))
			panelJoueurs.getStatsPokemons(true).get(p).cibleVisible(false);
		else if(panelJoueurs.getStatsPokemons(false).containsKey(p))
			panelJoueurs.getStatsPokemons(false).get(p).cibleVisible(false);
	}


    public PanelBoutons getPanelBoutons() {
        return panelBoutons;
    }


	
}
