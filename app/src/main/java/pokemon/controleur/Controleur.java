package pokemon.controleur;

import pokemon.modele.Case;
import pokemon.modele.Jeux;
import pokemon.modele.Joueur;
import pokemon.modele.Pokemon;
import pokemon.modele.Terrain;
import pokemon.vue.Vue;

public class Controleur {
    public boolean deplacerPokemon;
    public int anciennePosI;
    public int anciennePosY;
    public Terrain terrain;
    public Vue vue;
    public Joueur joueurActuel;
    public Jeux jeux;

    public Controleur(Terrain p, Joueur jActuel, Jeux jeux){
        terrain=p;
        joueurActuel=jActuel;
        this.jeux=jeux;
    }
    public void setVue(Vue vue){
        this.vue=vue;
    }


    public void deplacerPokemon(int x, int y) {
        Pokemon p=terrain.list.get(terrain.tab[anciennePosI][anciennePosY]);
        terrain.list.put(terrain.tab[anciennePosI][anciennePosY], null);
        terrain.list.put(terrain.tab[x][y], p);
        deplacerPokemon=false;
        vue.miseAjour();
    }
    public void miseAJourInformations() {
        vue.miseAJourInformations();
    }

    public void setJoueurActuel(Joueur j){
        joueurActuel=j;
    }

    public void selectionnerCase(Case c) {
        vue.listTile.get(6*c.getPosI()+c.getPosJ()).select();
    }
    public void jouerTour() {
        jeux.joueurTour();
    }
}
