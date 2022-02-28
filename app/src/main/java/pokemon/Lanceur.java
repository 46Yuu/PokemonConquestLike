package pokemon;

import pokemon.controleur.Controleur;
import pokemon.modele.jeux.Jeux;
import pokemon.modele.jeux.Joueur;
import pokemon.modele.pokemon.Evoli;
import pokemon.modele.pokemon.Pikachu;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;
import pokemon.modele.terrain.Terrain;
import pokemon.vue.Vue;
import java.awt.*;
import java.util.LinkedList;



public class Lanceur {
    public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			LinkedList<Pokemon> pokemonsJ1=new LinkedList<>();
			LinkedList<Pokemon> pokemonsJ2=new LinkedList<>();
			pokemonsJ1.add(new Evoli(10, 10, "Eau"));
			pokemonsJ1.add(new Evoli(10, 10, "Eau"));
			pokemonsJ2.add(new Pikachu(10, 10, "Electrique"));
			pokemonsJ2.add(new Pikachu(10, 10, "Electrique"));
			Terrain terrain=new Terrain(10,8);
			Jeux jeux= new Jeux(pokemonsJ1,pokemonsJ2,terrain);
			Controleur c=new Controleur(terrain,jeux);
			jeux.setControleur(c);
			Vue vue = new Vue(c);
			c.setVue(vue);
			vue.pack();
			vue.setVisible (true);
			
		});
	}
}
