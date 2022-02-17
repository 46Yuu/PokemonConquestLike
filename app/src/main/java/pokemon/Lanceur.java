package pokemon;

import pokemon.controleur.Controleur;
import pokemon.modele.Evoli;
import pokemon.modele.Jeux;
import pokemon.modele.Joueur;
import pokemon.modele.Pikachu;
import pokemon.modele.Terrain;
import pokemon.vue.Vue;
import java.awt.*;



public class Lanceur {
    public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			Joueur joueur1=new Joueur("joueur 1");
			joueur1.ajouterPokemon(new Evoli(10, 10, "normal"));
			joueur1.ajouterPokemon(new Evoli(10, 10, "normal"));
			Joueur joueur2=new Joueur("joueur 2");
			joueur2.ajouterPokemon(new Pikachu(10, 10, "normal"));
			joueur2.ajouterPokemon(new Pikachu(10, 10, "normal"));
			Jeux jeux= new Jeux(joueur1, joueur2);
			Terrain terrain=new Terrain(6,6,jeux);
			Controleur c=new Controleur(terrain, joueur1,jeux);
			jeux.setControleur(c);
			joueur1.setControleur(c);
			joueur2.setControleur(c);
			Vue vue = new Vue(c);
			c.setVue(vue);
			vue.pack();
			vue.setVisible (true);
		});
	}
}
