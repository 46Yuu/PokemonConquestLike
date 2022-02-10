package pokemon;

import pokemon.controleur.Controleur;
import pokemon.modele.Terrain;
import pokemon.vue.Vue;
import java.awt.*;



public class Lanceur {
    public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			Controleur c=new Controleur(new Terrain(6,6));
			Vue vue = new Vue(c);
			c.setVue(vue);
			vue.pack();
			vue.setVisible (true);
		});
	}
}
