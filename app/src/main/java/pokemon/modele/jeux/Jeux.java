package pokemon.modele.jeux;

import java.util.HashMap;
import java.util.HashSet;

import pokemon.controleur.Controleur;
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
            controleur.miseAJourInformations("Joueur 2");
        }
        else if(!joueur1 && pokemonsDeplaces.size()==pokemonCaseJoueur2.keySet().size()){
            pokemonsDeplaces.clear();
            joueur1=true;
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
        controleur.selectTiles(casesASelectionner);
    }

    /**
     * déplace le pokémon qui doit être déplacé dans ma case x,y
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
        controleur.afficherBoutons();
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
        controleur.deselectTiles(casesASelectionner);
    }    
}
