package pokemon.controleur;

import java.util.LinkedList;

import pokemon.modele.jeux.Jeux;
import pokemon.modele.jeux.Joueur;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;
import pokemon.modele.terrain.Pair;
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
    private LinkedList<Pair> listCasesPossibles;

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
        vue.deselectTiles(listCasesPossibles);
        vue.miseAjour();
        jeux.joueurTour();
    }
    public void miseAJourInformations() {
        vue.miseAJourInformations();
    }

    public void setJoueurActuel(Joueur j){
        joueurActuel=j;
    }

    public void selectionnerCase(Case c) {
        //taille*i+j correspond à la position de la tile dans la liste des tile dans la vue, exemple : tab[0][3]->listTile.get(6*0+3)
        vue.arrayTile[c.getPosI()][c.getPosJ()].select();
    }
    
    public void jouerTour() {
        jeux.joueurTour();
    }
    public void selectionnerCasePossibles(int x, int y) {
        listCasesPossibles=terrain.BFS(x, y);
        vue.selectTiles(listCasesPossibles);
    }


    /**
     * renvoie le chemin de d'image de la Tile de coordonnées (x,y)
     * @param x coordonnée x
     * @param y coordonnée y
     * @return chemin de l'image de la Tile
     */
    public String getCheminImageTile(int x, int y){
        return terrain.getPathImageTile(x,y);
    }

    /**
     * renvoie le chemin de l'image selection la Tile de coordonnées (x,y)
     * @param x coordonnée x
     * @param y coordonnée y
     * @return chemin de l'image selection de la Tile
     */
    public String getPathImageSelectTile(int x, int y){
        return terrain.getPathImageSelectTile(x, y);
    }
  
}
