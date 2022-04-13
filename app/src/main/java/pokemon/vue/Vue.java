package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JFrame;

import pokemon.controleur.Controleur;
import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.*;
import pokemon.modele.terrain.*;

import java.util.HashSet;

public class Vue extends JFrame{
	
	private Controleur controleur;
	private JButton buttonCommencer=new JButton("Jouer");
	private JButton buttonRecommencerJ1=new JButton("Recommencer");
	private JButton buttonRecommencerJ2=new JButton("Recommencer");
	private EcranJeux ecranJeuxJ1;
	private EcranJeux ecranJeuxJ2;
	private Thread threadJ1;
	private Thread threadJ2;
	public Vue() {
		controleur=new Controleur(this);
		this.setTitle("Pokemon");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Accueil panelAccueil=new Accueil(buttonCommencer);
		setContentPane(panelAccueil);
		
		buttonCommencer.addActionListener( event -> {
			threadJ1=new Thread(){
				public void run(){
					ecranJeuxJ1=new EcranJeux(controleur, buttonRecommencerJ1, "Joueur 1");
					ecranJeuxJ1.pack();
					ecranJeuxJ1.setVisible(true);
					ecranJeuxJ1.repaint();
				}
			};
			threadJ2=new Thread(){
				public void run(){
					ecranJeuxJ2=new EcranJeux(controleur, buttonRecommencerJ2, "Joueur 2");
					ecranJeuxJ2.pack();
					ecranJeuxJ2.setVisible(true);
					ecranJeuxJ2.repaint();
				}
			};
			threadJ1.run();
			threadJ2.run();
			setVisible(false);
			controleur.commencer();
		});	
		addActionListenerButtonRecommencer(buttonRecommencerJ1);
		addActionListenerButtonRecommencer(buttonRecommencerJ2);	
	}

	public void addActionListenerButtonRecommencer(JButton buttonRecommencer){
		buttonRecommencer.addActionListener( event-> {
			Controleur controleur=new Controleur(this);
			controleur.setVue(this);
			ecranJeuxJ1.initialiser(controleur);
			ecranJeuxJ2.initialiser(controleur);
			controleur.commencer();
		});
	}

    public void afficherFinPartie(boolean joueurGagnant) {
		ecranJeuxJ1.afficherFinPartie(joueurGagnant);
		ecranJeuxJ2.afficherFinPartie(!joueurGagnant);
    }

    public void decolorerCasesAAttaquer(HashSet<Pair> listCasesAAttaquer) {
		ecranJeuxJ1.decolorerCasesAAttaquer(listCasesAAttaquer);
		ecranJeuxJ2.decolorerCasesAAttaquer(listCasesAAttaquer);
	}

    public void colorerCasesAAttaquer(HashSet<Pair> casesAAttaquer) {
		ecranJeuxJ1.colorerCasesAAttaquer(casesAAttaquer);
		ecranJeuxJ2.colorerCasesAAttaquer(casesAAttaquer);
    }

    public void deselectTile(int first, int second) {
		ecranJeuxJ1.deselectTile(first,second);
		ecranJeuxJ2.deselectTile(first,second);
    }

    public void deselectTiles(HashSet<Pair> tiles, boolean jouuer1) {
		if(jouuer1)
			ecranJeuxJ1.deselectTiles(tiles);
		else
			ecranJeuxJ2.deselectTiles(tiles);
    }

    public void selectTiles(HashSet<Pair> tiles, boolean joueur1) {
		if(joueur1)
			ecranJeuxJ1.selectTiles(tiles);
		else
			ecranJeuxJ2.selectTiles(tiles);
    }

    public void showBoutons(boolean joueur1) {
		if(joueur1)
			ecranJeuxJ1.showBoutons();
		else
			ecranJeuxJ2.showBoutons();
    }

    public void deplacerPokemon(Pair tile1, Pair tile2, String pathImagePokemon) {
		ecranJeuxJ1.deplacerPokemon(tile1, tile2, pathImagePokemon);
		ecranJeuxJ2.deplacerPokemon(tile1, tile2, pathImagePokemon);
    }

    public void placerPokemon(int x, int y, String cheminImage) {
		ecranJeuxJ1.placerPokemon(x, y, cheminImage);
		ecranJeuxJ2.placerPokemon(x, y, cheminImage);
    }

    public void miseAJourInfosPokemons(Pokemon p, boolean joueur1) {
		ecranJeuxJ1.miseAJourInfosPokemons(p, joueur1);
		ecranJeuxJ2.miseAJourInfosPokemons(p, joueur1);
    }

    public void miseAJourInformations(String string) {
		ecranJeuxJ1.miseAJourInformations(string);
		ecranJeuxJ2.miseAJourInformations(string);
    }

    public void enleverPokemon(int x, int y) {
		ecranJeuxJ1.enleverPokemon(x, y);
		ecranJeuxJ2.enleverPokemon(x, y);
    }

	public PanelBoutons getPanelBoutons(boolean joueur1) {
		if(joueur1)
			return ecranJeuxJ1.getPanelBoutons();
		return ecranJeuxJ2.getPanelBoutons();
	}

	public void cibleVisible(Pokemon pokeDansCase, boolean joueur1, boolean pokAJoueur1) {
		if(joueur1)
			ecranJeuxJ1.cibleVisible(pokeDansCase, joueur1==pokAJoueur1);
		else
			ecranJeuxJ2.cibleVisible(pokeDansCase, joueur1==pokAJoueur1);
	}

    public void cibleInvisible(Pokemon pokeDansCase, boolean joueur1, boolean pokAJoueur1) {
		if(joueur1)
			ecranJeuxJ1.cibleInvisible(pokeDansCase, joueur1==pokAJoueur1);
		else
			ecranJeuxJ2.cibleInvisible(pokeDansCase, joueur1==pokAJoueur1);
    }
	/*
	public void waitThreadJ1(){
		try{
			ecranJeuxJ1.wait();
			ecranJeuxJ2.notify();
		}catch(InterruptedException e){
			System.out.println("probleme thread");
		}
	}

	public void waitThreadJ2(){
		try{
			ecranJeuxJ2.wait();
			ecranJeuxJ1.notify();
		}catch(InterruptedException e){
			System.out.println("probleme thread");
		}
	}
	*/

	public void setVisibleBoutonRetour(boolean b, boolean joueur1) {
		getPanelBoutons(joueur1).getBoutonRetour().setVisible(b);
	}

	public void setVisibleBoutonFin(boolean b, boolean joueur1) {
		getPanelBoutons(joueur1).getBoutonFin().setVisible(b);
	}

	public void enleverAttaqueInfos(String attaque,boolean joueur1) {
		if(joueur1)
			ecranJeuxJ1.enleverAttaqueInfos(attaque);
		else
			ecranJeuxJ2.enleverAttaqueInfos(attaque);
    }

	public int getXPrec(boolean joueur1){
		if(joueur1)
			return ecranJeuxJ1.getXPrec();
		else
			return ecranJeuxJ2.getXPrec();
	}

	public int getYPrec(boolean joueur1){
		if(joueur1)
			return ecranJeuxJ1.getYPrec();
		else
			return ecranJeuxJ2.getYPrec();
	}

	public void setXPrec(int x,boolean joueur1){
		if(joueur1)
			ecranJeuxJ1.setXPrec(x);
		else
			ecranJeuxJ2.setXPrec(x);
	}

	public void setYPrec(int y,boolean joueur1){
		if(joueur1)
			ecranJeuxJ1.setYPrec(y);
		else
			ecranJeuxJ2.setYPrec(y);
	}
}
