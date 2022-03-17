package pokemon;

import pokemon.controleur.Controleur;
import pokemon.modele.jeux.Jeux;
import pokemon.modele.pokemon.Evoli;
import pokemon.modele.pokemon.Pikachu;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;
import pokemon.modele.terrain.Terrain;
import pokemon.vue.Vue;
import java.awt.*;
import java.util.HashMap;

public class Lanceur {
    public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			HashMap<Pokemon,Case> pokemonsJ1=new HashMap<>();
			HashMap<Pokemon,Case> pokemonsJ2=new HashMap<>();
			pokemonsJ1.put(new Evoli(10, 2, "Eau"),null);
			pokemonsJ1.put(new Evoli(10, 2, "Eau"),null);
			pokemonsJ2.put(new Pikachu(10, 2, "Electrique"),null);
			pokemonsJ2.put(new Pikachu(10, 2, "Electrique"),null);
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
