package pokemon;

import pokemon.controleur.Controleur;
import pokemon.modele.Terrain;
import pokemon.vue.Vue;
import java.awt.*;



public class Lanceur {
    public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			Vue vue = new Vue(new Controleur(new Terrain(6,6)));
			vue.pack();
			vue.setVisible (true);
		});
	}
}
