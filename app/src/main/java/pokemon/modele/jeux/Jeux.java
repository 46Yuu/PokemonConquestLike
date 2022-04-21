package pokemon.modele.jeux;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import pokemon.controleur.Controleur;
import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;
import pokemon.modele.terrain.Pair;
import pokemon.modele.terrain.Terrain;

public class Jeux {

    private Controleur controleur;
    private Terrain terrain;
    /**
     * associe à chaque pokémon du joueur 1 la case où il se trouve
     */
    private HashMap<Pokemon,Case> pokemonCaseJoueur1=new HashMap<>();
    /**
     * associe à chaque pokémon du joueur 2 la case où il se trouve
     */
    private HashMap<Pokemon,Case> pokemonCaseJoueur2=new HashMap<>();

    /**
     * liste des pokémons du joueur 1
     */
    private HashSet<Pokemon> pokemonsDeplaces=new HashSet<>();
    /**
     * tour du joueur 1, si true
     * tour du joueur 2, sinon
     */
    private boolean joueur1=true;
    private Pokemon pokemonActuel;

    HashSet<Pair> casesASelectionner=new HashSet<>();
    /**
     * l'attaque que le joueur a choisie pour attaquer avec le pokémon actuel
     */
    private Attaque attaqueChoisie;
    private String nomAttaque;
    private HashSet<Pair> listCasesAAttaquer=new HashSet<>();
    
    public Jeux(HashMap<Pokemon,Case> pokemonsJoueur1, HashMap<Pokemon,Case> pokemonsJoueur2, Terrain terrain){
        this.pokemonCaseJoueur1=pokemonsJoueur1;
        this.pokemonCaseJoueur2=pokemonsJoueur2;
        this.terrain=terrain;

    }

    public void setControleur(Controleur controleur){
        this.controleur=controleur;
    }

    /**
     * met les pokémons des joueurs 1 et 2 dans le terrain
     */
    public void poserPokemons() {
        int x=0, y=0;
        for(Pokemon p : pokemonCaseJoueur1.keySet()){
            if(y>=terrain.getWidth()){
                x+=2;
                y=0;
            }
            pokemonCaseJoueur1.put(p, terrain.getCase(x,y));
            terrain.getCase(x,y).setPokemon(p);
            controleur.placerPokemon(p,x,y);
            y+=4;
        }

        x=terrain.getHeight()-1;
        y=0;
        for(Pokemon p : pokemonCaseJoueur2.keySet()){
            if(y>=terrain.getWidth()){
                x-=2;
                y=0;
            }
            pokemonCaseJoueur2.put(p, terrain.getCase(x,y));
            terrain.getCase(x,y).setPokemon(p);
            controleur.placerPokemon(p,x,y);
            y+=4;
        }     
    }

    /**
     * sélectionne les pokémons qui peuvent être déplacer
     *  pour joueur 1 si c'est le tour de joueur1, pour joueur2 sinon
     */
    public void selectPokemon() {
        casesASelectionner.clear();
        if(joueur1 && pokemonsDeplaces.size()==pokemonCaseJoueur1.keySet().size()){
            pokemonsDeplaces.clear();
            joueur1=false;
            //controleur.waitThreadJ1();
            controleur.miseAJourInformations("Joueur 2");
        }
        else if(!joueur1 && pokemonsDeplaces.size()==pokemonCaseJoueur2.keySet().size()){
            pokemonsDeplaces.clear();
            joueur1=true;
            //controleur.waitThreadJ2();
            controleur.miseAJourInformations("Joueur 1");
        }
        
        if(joueur1){
            for(Pokemon p : pokemonCaseJoueur1.keySet()){
                if( !(pokemonsDeplaces.contains(p)) )
                    casesASelectionner.add(new Pair(pokemonCaseJoueur1.get(p).getPosI(),pokemonCaseJoueur1.get(p).getPosJ(),0)); 
            }
        }
        else{
            for(Pokemon p : pokemonCaseJoueur2.keySet()){
                if( !(pokemonsDeplaces.contains(p)) )
                casesASelectionner.add(new Pair(pokemonCaseJoueur2.get(p).getPosI(),pokemonCaseJoueur2.get(p).getPosJ(),0)); 
            }
        }
        controleur.selectTiles(casesASelectionner, joueur1);
    }

    /**
     * déplace le pokémon qui doit être déplacé dans la case x,y
     * @param x coordonnée x de la case d'arrivée
     * @param y coordonnée y de la case d'arrivée
     */
    public void deplacerPokemon(int x, int y){
        controleur.deselectionnerCasesPossibles();
        Case caseDepart;
        if(joueur1){
            //on enlève le pokémon de la case de départ
            caseDepart=pokemonCaseJoueur1.get(pokemonActuel);
            caseDepart.setPokemon(null);
            //on met à jour la case du pokémon dans la HashMap<Pokemon,Case>
            pokemonCaseJoueur1.put(pokemonActuel,terrain.getCase(x,y));
            //on ajoute le pokémon à la case d'arrivée 
            terrain.setPokemon(x, y, pokemonActuel);
        }
        else{
            //on enlève le pokémon de la case de départ
            caseDepart=pokemonCaseJoueur2.get(pokemonActuel);
            caseDepart.setPokemon(null);
            //on met à jour la case du pokémon dans la HashMap<Pokemon,Case>
            pokemonCaseJoueur2.put(pokemonActuel,terrain.getCase(x,y)); 
             //on ajoute le pokémon à la case d'arrivée 
             terrain.setPokemon(x, y, pokemonActuel);     
        }
        pokemonsDeplaces.add(pokemonActuel);
        //mettre à jour la vue
        controleur.deplacerPokemonDansVue(new Pair(caseDepart.getPosI(),caseDepart.getPosJ(),0), new Pair(x,y,0), pokemonActuel.getCheminImage());
        //sélectionner le pokémon suivant à déplacer  
        controleur.afficherBoutons(joueur1);
    }

    /**
     * retourne un ensemble de paires qui désignent les coordonnées des cases
     * accessibles au pokémon se trouvant sur la case de coordonnées x,y
     * @param x position x du pokémon à déplacer 
     * @param y position y du pokémon à déplacer
     * @return ensemble de paires qui désignent les coordonnées des cases
     * accessibles au pokémon se trouvant sur la case de coordonnées x,y
     */
    public HashSet<Pair> BFS(int x, int y) {
        return terrain.BFS(x, y, pokemonCaseJoueur1);
    }

    /**
     * retourne le pokémon que le joueur déplace 
     * @return le pokémon que le joueur déplace
     */
    public Pokemon getPokemonActuel() {
        return pokemonActuel;
    }

    /**
     * déselectionne les cases des pokémons qui peuvent êtres déplacés  
     * et met à jour pokemonActuel
     * @param x position x de la case du pokémon choisi
     * @param y position y de la case du pokémon choisi
     */
    public void deselectionnerAutresCases(int x, int y) {
        pokemonActuel=terrain.getCase(x,y).getPokemon();
        controleur.deselectTiles(casesASelectionner, joueur1);
    }  
    
    public HashSet<Pair> casesAAttaquer(String attaque){
        int x=0,y=0;
        if(joueur1){
            x=pokemonCaseJoueur1.get(pokemonActuel).getPosI();
            y=pokemonCaseJoueur1.get(pokemonActuel).getPosJ();
        }  
        else{
            x=pokemonCaseJoueur2.get(pokemonActuel).getPosI();
            y=pokemonCaseJoueur2.get(pokemonActuel).getPosJ();
        } 
        nomAttaque = attaque;
        attaqueChoisie=pokemonActuel.getListeAttaque().get(attaque);
        listCasesAAttaquer=terrain.casesAAttaquer(x,y, pokemonActuel.getListeAttaque().get(attaque),joueur1,pokemonCaseJoueur1);
        return listCasesAAttaquer;
    }

    /**
     * renvoie les coordonnées de la case où se trouve le pokémon actuel
     * @return les coordonnées de la case où se trouve le pokémon actuel
     */
    public Pair getCoordonneesPokemonActuel() {
        if(joueur1)
            return new Pair(pokemonCaseJoueur1.get(pokemonActuel).getPosI(),pokemonCaseJoueur1.get(pokemonActuel).getPosJ(),0);
        return new Pair(pokemonCaseJoueur2.get(pokemonActuel).getPosI(),pokemonCaseJoueur2.get(pokemonActuel).getPosJ(),0);
    }

    /**
     * le pokémon actuel attque le pokémon qui se trouve sur la case (x,y)
     * met à jour les informations du pokémon attaqué dans vue
     * déselectionne le tile où se trouve le pokémon actuel
     * enlève le pokémon s'il est KO après être attaqué et vérifie si la partie est terminée 
     * @param x coordonnée x du pokémon attaqué
     * @param y coordonnée y du pokémon attaqué
     */
    public void attaquer(int x, int y) {
        attaqueChoisie.Attack(pokemonActuel, terrain.getPokemon(x, y));
        controleur.miseAJourInfosPokemons(terrain.getPokemon(x, y),joueur1);
        controleur.decolorerCasesAAttaquer(listCasesAAttaquer);
        controleur.enleverAttaqueInfos(nomAttaque,joueur1);
        controleur.deselectTile(getCoordonneesPokemonActuel());
        if(pokemonKo(x, y)){
            enleverKo(x,y);
            finDePartie();
        }
    }

    public void testEffet(){
        if(pokemonActuel.getEffet()!=null){
            pokemonActuel.testEffet();
            if(pokemonActuel.getEffet()=="Brule"){
                controleur.miseAJourInfosPokemons(pokemonActuel, !joueur1);
                controleur.hit();
            }
        }
    }

    /**
     * renvoie la map qui associe à chaque pokémon du joueur 1, la case où il se trouve
     * @return la map qui associe à chaque pokémon du joueur 1, la case où il se trouve
     */
    public Map<Pokemon, Case> getPokemonCaseJoueur1() {
        return pokemonCaseJoueur1;
    }

    /**
     * renvoie la map qui associe à chaque pokémon du joueur 2, la case où il se trouve
     * @return la map qui associe à chaque pokémon du joueur 2, la case où il se trouve
     */
    public Map<Pokemon, Case> getPokemonCaseJoueur2() {
        return pokemonCaseJoueur2;
    }

    /**
     * enlève le pokémon de la case de coordonnées (x,y) et de la liste des 
     * pokémons du joueur auquel le pokémon appartient et dans le tile correspondant
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     */
    public void enleverKo(int x,int y){
        controleur.cibleInvisible(x, y);
        Case caseDepart;
        if(joueur1){
            caseDepart=pokemonCaseJoueur2.get(terrain.getPokemon(x, y));
            pokemonCaseJoueur2.remove(terrain.getPokemon(x, y)); 
            caseDepart.setPokemon(null);
        }
        else {
            caseDepart=pokemonCaseJoueur1.get(terrain.getPokemon(x, y));
            pokemonCaseJoueur1.remove(terrain.getPokemon(x, y)); 
            caseDepart.setPokemon(null);
        }
        controleur.enleverPokemon(x, y);
    }

    /**
     * vérifie si le pokémon qui se trouve dans la case de coordonnées (x,y) est KO
     * @param x coordonnée x de la case
     * @param y cpordonnée y de la case
     * @return true si le pokémon qui se trouve sur la case (x,y) est Ko; false sinon
     */
    public boolean pokemonKo(int x,int y){
        return terrain.getPokemon(x, y).getPdv()<=0;
    }

    /**
     * si l'un des joueurs n'a plus de pokémons, affiche winner sur la fenêtre du joueur
     * qui a encore des pokémons, et loser sur la fenêtre du joueur perdant, ainsi que le 
     * bouton recommencer
     */
    public void finDePartie(){
        if(joueur1){
            if(pokemonCaseJoueur2.size() ==0){
                controleur.partieFinie(true);
            }
        }
        else{
            if(pokemonCaseJoueur1.size() ==0){
                controleur.partieFinie(false);
            }
        }
    }

    /**
     * renvoie la liste de coordonnées des cases qui peuvent être attaquées
     * @return la liste de coordonnées des cases qui peuvent être attaquées
     */
    public HashSet<Pair> getListCasesAAttaquer() {
        return listCasesAAttaquer;
    }

    /**
     * renvoie le joueur actuel
     * @return joueur actuel, true pour joueur 1; false pour joueur 2
     */
    public boolean getJoueurActuel() {
        return joueur1;
    }

    /**
     * renvoie true si le pokémon p appartient à joueur 1; false s'il appartient à joueur 2
     * @param p pokémon
     * @return true si le pokémon p appartient à joueur 1; false s'il appartient à joueur 2
     */
    public boolean appartienAJoueur1(Pokemon p) {
        return pokemonCaseJoueur1.keySet().contains(p);
    }

    /**
     * annule le déplacement du pokémon p
     * @param x coordonnée x de la case où le pokémon a été avant son déplacement
     * @param y coordonnée y de la case où le pokémon a été avant son déplacement
     */
    public void annulerDeplacement(int x, int y){
        Case caseDepart;
        if(joueur1){
            //on enlève le pokémon de la case de départ
            caseDepart=pokemonCaseJoueur1.get(pokemonActuel);
            caseDepart.setPokemon(null);
            //on met à jour la case du pokémon dans la HashMap<Pokemon,Case>
            pokemonCaseJoueur1.put(pokemonActuel,terrain.getCase(x,y));
            //on ajoute le pokémon à la case d'arrivée 
            terrain.setPokemon(x, y, pokemonActuel);
        }
        else{
            //on enlève le pokémon de la case de départ
            caseDepart=pokemonCaseJoueur2.get(pokemonActuel);
            caseDepart.setPokemon(null);
            //on met à jour la case du pokémon dans la HashMap<Pokemon,Case>
            pokemonCaseJoueur2.put(pokemonActuel,terrain.getCase(x,y)); 
             //on ajoute le pokémon à la case d'arrivée 
             terrain.setPokemon(x, y, pokemonActuel);     
        }
        pokemonsDeplaces.remove(pokemonActuel);
        //mettre à jour la vue
        controleur.deplacerPokemonDansVue(new Pair(caseDepart.getPosI(),caseDepart.getPosJ(),0), new Pair(x,y,0), pokemonActuel.getCheminImage());
        //sélectionner le pokémon suivant à déplacer  
        selectPokemon();
    }
}