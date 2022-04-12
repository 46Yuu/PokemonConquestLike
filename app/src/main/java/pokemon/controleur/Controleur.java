package pokemon.controleur;
import java.util.*;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.jeux.Jeux;
import pokemon.modele.pokemon.Abo;
import pokemon.modele.pokemon.Abra;
import pokemon.modele.pokemon.Absol;
import pokemon.modele.pokemon.Bulbizarre;
import pokemon.modele.pokemon.Carapuce;
import pokemon.modele.pokemon.Chenipan;
import pokemon.modele.pokemon.Evoli;
import pokemon.modele.pokemon.Minidraco;
import pokemon.modele.pokemon.Nodulithe;
import pokemon.modele.pokemon.Oniglali;
import pokemon.modele.pokemon.Pikachu;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.pokemon.Riolu;
import pokemon.modele.pokemon.Salameche;
import pokemon.modele.pokemon.Smogo;
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

    public Controleur(Vue vue){
        this.vue=vue;
        HashMap<Pokemon,Case> pokemonsJ1=new HashMap<>();
        HashMap<Pokemon,Case> pokemonsJ2=new HashMap<>();

        LinkedList<Pokemon> listePokemons=new LinkedList<>();

        listePokemons.add(new Salameche(10, 2, "Feu"));
        listePokemons.add(new Evoli(10, 2, "Normal"));
        listePokemons.add(new Abo(10, 2, "Poison"));
        listePokemons.add(new Abra(10, 2, "Psy"));
        listePokemons.add(new Absol(10, 2, "Tenebres"));
        listePokemons.add(new Bulbizarre(10, 2, "Plante"));
        listePokemons.add(new Carapuce(10, 2, "Eau"));
        listePokemons.add(new Chenipan(10, 2, "Insecte"));
        listePokemons.add(new Minidraco(10, 2, "Dragon"));
        listePokemons.add(new Nodulithe(10, 2, "Roche"));
        listePokemons.add(new Oniglali(10, 2, "Glace"));
        listePokemons.add(new Riolu(10, 2, "Combat"));
        listePokemons.add(new Smogo(10, 2, "Poison"));
        listePokemons.add(new Pikachu(10, 2, "Electrique"));
        
        Random rand=new Random();
		pokemonsJ1.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
        pokemonsJ1.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
        pokemonsJ1.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
        pokemonsJ1.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
        pokemonsJ1.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
        pokemonsJ1.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
        pokemonsJ1.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
        pokemonsJ1.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
		pokemonsJ2.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
        pokemonsJ2.put(listePokemons.get(rand.nextInt(listePokemons.size())),null);
        
		terrain=new Terrain(10,8);
		jeux= new Jeux(pokemonsJ1,pokemonsJ2,terrain);
		jeux.setControleur(this);
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

    public void miseAJourInfosPokemons(Pokemon p, boolean joueur1){
        vue.miseAJourInfosPokemons(p, joueur1);
    }
    
    /**
     * sélectionne dans la vue toutes les cases possibles auquelles le pokémon
     * se trouvant sur la tile x,y peut y aller 
     * @param x coordonnée x de la tile
     * @param y coordonnée y de la tile
     */
    public void selectionnerCasePossibles(int x, int y) {
        listCasesPossibles=jeux.BFS(x, y);
        vue.selectTiles(listCasesPossibles,jeux.getJoueurActuel());
    }

    /**
     * désélectionne les cases qu'on a sélectionnées pour le déplacement du pokémon
     */
    public void deselectionnerCasesPossibles(){
        vue.deselectTiles(listCasesPossibles, jeux.getJoueurActuel());
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
     * renvoie le chemin de l'image attaque de la Tile de coordonnées (x,y)
     * @param x coordonnée x
     * @param y coordonnée y
     * @return chemin de l'image attaque de la Tile
     */
    public String getPathImageAttaqueTile(int x, int y) {
        return terrain.getPathImageAttaqueTile(x,y);
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

    public void afficherBoutons(boolean joueur1){
        vue.showBoutons(joueur1);
    }

    //public void attaque(String nom,){
    //    Pokemon p = jeux.getPokemonActuel();
    //}

    public void selectTiles(HashSet<Pair> tiles, boolean joueur1){
        vue.selectTiles(tiles, joueur1);
    }
    public void deselectTiles(HashSet<Pair> tiles, boolean joueur1){
        vue.deselectTiles(tiles, joueur1);
    }
    public void deselectTile(Pair coordonnees) {
        vue.deselectTile(coordonnees.getFirst(), coordonnees.getSecond());
    }

    public void deselectionnerAutresCases(int x, int y) {
        jeux.deselectionnerAutresCases(x,y);
    }

    public void colorerCasesAAttaquer(String attaque){
        HashSet<Pair> casesAAttaquer=jeux.casesAAttaquer(attaque);
        vue.colorerCasesAAttaquer(casesAAttaquer);
    }

    public void decolorerCasesAAttaquer(HashSet<Pair> listCasesAAttaquer) {
        vue.decolorerCasesAAttaquer(listCasesAAttaquer);
        listCasesAAttaquer.clear();
    }

    public void decolorerCasesAAttaquer(){
        vue.decolorerCasesAAttaquer(jeux.getListCasesAAttaquer());
    }

    public Pair getCoordonneesPokemonActuel(){
        return jeux.getCoordonneesPokemonActuel();
    }

    public void attaquer(int x, int y) {
        jeux.attaquer(x,y);
    }

    public void partieFinie(boolean joueurGagnant){
        vue.afficherFinPartie(joueurGagnant);
    }    
    public Pokemon getPokeDansCase(int x,int y){
        return terrain.getPokemon(x, y);
    }

    public boolean getJoueurActuel(){
        return jeux.getJoueurActuel();
    }
/*
    public void waitThreadJ1() {
        vue.waitThreadJ1();
    }

    public void waitThreadJ2() {
        vue.waitThreadJ2();
    }
*/
    public void cibleVisible(int x, int y) {
        Pokemon p=getPokeDansCase(x, y);
        vue.cibleVisible(p, jeux.getJoueurActuel(), jeux.appartienAJoueur1(p));
    }

    public void cibleInvisible(int x, int y) {
        Pokemon p=getPokeDansCase(x, y);
        vue.cibleInvisible(p, jeux.getJoueurActuel(), jeux.appartienAJoueur1(p));
    }

    public void setVisibleBoutonRetour(boolean b) {
        vue.setVisibleBoutonRetour(b, jeux.getJoueurActuel());
    }

    public void setVisibleBoutonFin(boolean b) {
        vue.setVisibleBoutonFin(b, jeux.getJoueurActuel());
    }

    public void enleverAttaqueInfos(String attaque, boolean joueur1){
        vue.enleverAttaqueInfos(attaque,joueur1);
    }
}

