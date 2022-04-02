package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;

import pokemon.controleur.Controleur;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.*;
import java.util.HashSet;

public class Vue extends JFrame{
	
	private Controleur controleur;
	private JButton buttonCommencer=new JButton("Jouer");
	private EcranJeux ecranJeux;
	public Vue(Controleur c) {
		controleur=c;
		
		this.setTitle("Pokemon");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Accueil panelAccueil=new Accueil(buttonCommencer);
		setContentPane(panelAccueil);
		
		buttonCommencer.addActionListener( event -> {
			ecranJeux=new EcranJeux(controleur);
			setContentPane(ecranJeux);
			revalidate();
			controleur.commencer();
		});	
	}

    public void afficherFinPartie(String joueurGagnant) {
		ecranJeux.afficherFinPartie(joueurGagnant);
    }

    public void decolorerCasesAAttaquer(HashSet<Pair> listCasesAAttaquer) {
		ecranJeux.decolorerCasesAAttaquer(listCasesAAttaquer);
    }

    public void colorerCasesAAttaquer(HashSet<Pair> casesAAttaquer) {
		ecranJeux.colorerCasesAAttaquer(casesAAttaquer);
    }

    public void deselectTile(int first, int second) {
		ecranJeux.deselectTile(first,second);
    }

    public void deselectTiles(HashSet<Pair> tiles) {
		ecranJeux.deselectTiles(tiles);
    }

    public void selectTiles(HashSet<Pair> tiles) {
		ecranJeux.selectTiles(tiles);
    }

    public void showBoutons() {
		ecranJeux.showBoutons();
    }

    public void deplacerPokemon(Pair tile1, Pair tile2, String pathImagePokemon) {
		ecranJeux.deplacerPokemon(tile1, tile2, pathImagePokemon);
    }

    public void placerPokemon(int x, int y, String cheminImage) {
		ecranJeux.placerPokemon(x, y, cheminImage);
    }

    public void miseAJourInfosPokemons(Pokemon p, boolean joueur1) {
		ecranJeux.miseAJourInfosPokemons(p, joueur1);
    }

    public void miseAJourInformations(String string) {
		ecranJeux.miseAJourInformations(string);
    }

    public void enleverPokemon(int x, int y) {
		ecranJeux.enleverPokemon(x, y);
    }

	public PanelBoutons getPanelBoutons() {
		return ecranJeux.getPanelBoutons();
	}

	public void cibleVisible(Pokemon pokeDansCase) {
		ecranJeux.cibleVisible(pokeDansCase);
	}

    public void cibleInvisible(Pokemon pokeDansCase) {
		ecranJeux.cibleInvisible(pokeDansCase);
    }

	
}
