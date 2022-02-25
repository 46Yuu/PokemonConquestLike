package pokemon;

import pokemon.controleur.Controleur;
import pokemon.modele.jeux.Jeux;
import pokemon.modele.jeux.Joueur;
import pokemon.modele.pokemon.Evoli;
import pokemon.modele.pokemon.Pikachu;
import pokemon.modele.terrain.Terrain;
import pokemon.vue.Vue;
import java.awt.*;



public class Lanceur {
    public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			Joueur joueur1=new Joueur("joueur 1");
			joueur1.ajouterPokemon(new Evoli(10, 10, "Eau"));
			joueur1.ajouterPokemon(new Evoli(10, 10, "Eau"));
			Joueur joueur2=new Joueur("joueur 2");
			joueur2.ajouterPokemon(new Pikachu(10, 10, "Electrique"));
			joueur2.ajouterPokemon(new Pikachu(10, 10, "Electrique"));
			Jeux jeux= new Jeux(joueur1, joueur2);
			Terrain terrain=new Terrain(7,7,jeux);
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
