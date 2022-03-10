package pokemon.controleur;
import java.util.*;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.jeux.Jeux;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;
import pokemon.modele.terrain.Pair;
import pokemon.modele.terrain.Terrain;
import pokemon.vue.Vue;

public class Controleur {
    public boolean deplacerPokemon;
    public Terrain terrain;
    public Vue vue;
    public Jeux jeux;
    /**
     * dernières cases sélectionnées 
     */
    private HashSet<Pair> listCasesPossibles;

    public Controleur(Terrain p, Jeux jeux){
        terrain=p;
        this.jeux=jeux;
    }

    public void setVue(Vue vue){
        this.vue=vue;
    }

    /**
     * pose les pokémons des deux joueur sur le terrain
     * et sélectionne le premier pokémon à déplacer du joueur 1
     */
    public void commencer() {
        vue.miseAJourInformations("Joueur 1");
        jeux.poserPokemons();
        jeux.selectPokemon();
    }

    /**
     * affiche le joueur 
     * @param joueur
     */
    public void miseAJourInformations(String joueur) {
        vue.miseAJourInformations(joueur);
    }
    
    /**
     * sélectionne dans la vue toutes les cases possibles auquelles le pokémon
     * se trouvant sur la tile x,y peut y aller 
     * @param x coordonnée x de la tile
     * @param y coordonnée y de la tile
     */
    public void selectionnerCasePossibles(int x, int y) {
        listCasesPossibles=jeux.BFS(x, y);
        vue.selectTiles(listCasesPossibles);
    }

    /**
     * désélectionne les cases qu'on a sélectionnées pour le déplacement du pokémon
     */
    public void deselectionnerCasesPossibles(){
        vue.deselectTiles(listCasesPossibles);
    }

    /**
     * renvoie le chemin de d'image de la Tile de coordonnées (x,y)
     * @param x coordonnée x
     * @param y coordonnée y
     * @return chemin de l'image de la Tile
     */
    public String getPathImageTile(int x, int y){
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

    /**
     * renvoie la hauteur du plateau
     * @return la hauteur du plateau
     */
    public int getWidth() {
        return terrain.getWidth();
    }

    /**
     * renvoie la largeur du plateau
     * @return la largeur du plateau
     */
    public int getHeight() {
        return terrain.getHeight();
    }
    
    /**
     * met le pokémon p dans la tile x,y de vue
     * @param p le pokémon à placer
     * @param x coordonnée x de la tile
     * @param y coordonnée y de la tile 
     */
    public void placerPokemon(Pokemon p, int x, int y) {
        vue.placerPokemon(x, y, p.getCheminImage());
    }
  
    /**
     * déplace le pokémon qui doit être dans la case x,y dans model
     * @param x coordonnée x de la case d'arrivée 
     * @param y coordonnée y de la case d'arrivée 
     */
    public void deplacerPokemon(int x, int y) {
        jeux.deplacerPokemon(x,y);
    }

    /**
     * déplace le pokémon se trouvant sur le tile de coordonnées tile1 vers le tile de 
     * coordonnées tile2 dans vue 
     * @param tile1 coordonnées de la tile de départ
     * @param tile2 coordonnées de la tile d'arrivée
     * @param pathImagePokemon le chemin d'accès à l'image du pokémon à déplacer
     */
    public void deplacerPokemonDansVue(Pair tile1, Pair tile2, String pathImagePokemon){
        vue.deplacerPokemon(tile1, tile2, pathImagePokemon);
    }

    public Jeux getJeux(){
        return this.jeux;
    }

    public Map<String,Attaque> getListeAttaquesPokemon(){
        Pokemon p = jeux.getPokemonActuel();
        return p.getListeAttaque();
    }

    public void afficherBoutons(){
        this.vue.showBoutons();
    }

    //public void attaque(String nom,){
    //    Pokemon p = jeux.getPokemonActuel();
    //}

    public void selectTiles(HashSet<Pair> tiles){
        vue.selectTiles(tiles);
    }
    public void deselectTiles(HashSet<Pair> tiles){
        vue.deselectTiles(tiles);
    }

    public void deselectionnerAutresCases(int x, int y) {
        jeux.deselectionnerAutresCases(x,y);
    }
}
