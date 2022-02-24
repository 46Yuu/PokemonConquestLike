package pokemon.controleur;

import pokemon.modele.jeux.Jeux;
import pokemon.modele.jeux.Joueur;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;
import pokemon.modele.terrain.Terrain;
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
        Pokemon p=terrain.tab[anciennePosI][anciennePosY].getPokemon();
        joueurActuel.setTerrainPourPokemon(p,terrain.tab[x][y]);
        jeux.incrementerInfoTour();
        terrain.tab[anciennePosI][anciennePosY].setPokemon(null);
        terrain.tab[x][y].setPokemon(p);
        deplacerPokemon=false;
        deselectionnerCase();
        vue.miseAjour();
    }
    public void miseAJourInformations() {
        vue.miseAJourInformations();
    }

    public void setJoueurActuel(Joueur j){
        joueurActuel=j;
    }

    public void selectionnerCase(Case c) {
        //taille*i+j correspond à la position de la tile dans la liste des tile dans la vue, exemple : tab[0][3]->listTile.get(6*0+3)
        vue.listTile.get(6*c.getPosI()+c.getPosJ()).select();
    }
    public void deselectionnerCase() {
        //taille*i+j correspond à la position de la tile dans la liste des tile dans la vue, exemple : tab[0][3]->listTile.get(6*0+3)
        vue.listTile.get(6*anciennePosI+anciennePosY).deselect();
        jeux.joueurTour();
    }
    public void jouerTour() {
        jeux.joueurTour();
    }
  
}
