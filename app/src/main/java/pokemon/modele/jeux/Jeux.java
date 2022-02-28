package pokemon.modele.jeux;

import java.util.HashMap;
import java.util.LinkedList;

import pokemon.controleur.Controleur;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;
import pokemon.modele.terrain.Pair;
import pokemon.modele.terrain.Terrain;

public class Jeux {
 
    private HashMap<Pokemon,Case> pokemonCaseJoueur1=new HashMap<>();
    private HashMap<Pokemon,Case> pokemonCaseJoueur2=new HashMap<>();
    private LinkedList<Pokemon> pokemonsJoueur1;
    private LinkedList<Pokemon> pokemonsJoueur2;
    private int posPokemonInList=-1;
    private Terrain terrain;
    
    private boolean joueur1=true;//si false, tour du joueur2
    private Controleur controleur;

    public Jeux(LinkedList<Pokemon> pokemonsJoueur1, LinkedList<Pokemon> pokemonsJoueur2, Terrain terrain){
        this.pokemonsJoueur1=pokemonsJoueur1;
        this.pokemonsJoueur2=pokemonsJoueur2;
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
        for(Pokemon p : pokemonsJoueur1){
            if(y>=terrain.getWidth()){
                x+=2;
                y=0;
            }
            pokemonCaseJoueur1.put(p, terrain.getCase(x,y));
            terrain.getCase(x,y).setPokemon(p);
            controleur.poserPokemon(p,x,y);
            y+=4;
        }

        x=terrain.getHeight()-1;
        y=0;
        for(Pokemon p : pokemonsJoueur2){
            if(y>=terrain.getWidth()){
                x-=2;
                y=0;
            }
            pokemonCaseJoueur2.put(p, terrain.getCase(x,y));
            terrain.getCase(x,y).setPokemon(p);
            controleur.poserPokemon(p,x,y);
            y+=4;
        }
        
    }

    
    /**
     *met à joueur la position du pokémon à déplacer  
     *@param pos position du pokémon à déplacer
     */ 
    public void setPosPokemonActuel(int pos){
        
    }

    /**
     * @return la position du pokémon qui doit être déplacé
     */
    public int getPosPokemonActuel(){
        return 0;
    }


    /**
     * demande au joueur actuel de déplacer le pokémon actuel
     */
    public void joueurTour(){
        controleur.miseAJourInformations();
        
        
    }

    /**
     * met à jour la position du pokémon actuel
     * et celle du joueur actuel, si le joueur à déplacé tous ses pokémons
     */
    public void incrementerInfoTour(){
        
    }

    public void selectPokemon() {
        if(joueur1 && posPokemonInList==pokemonsJoueur1.size()-1){
            joueur1=false;
            posPokemonInList=-1;
        }
        else if(!joueur1 && posPokemonInList==pokemonsJoueur2.size()-1){
            joueur1=true;
            posPokemonInList=-1;
        }
        posPokemonInList++;
        if(joueur1){
            controleur.selectionnerCase(pokemonCaseJoueur1.get(pokemonsJoueur1.get(posPokemonInList)));
        }
        else{
            controleur.selectionnerCase(pokemonCaseJoueur2.get(pokemonsJoueur2.get(posPokemonInList)));
        }
    }

    public void deplacerPokemon(int x, int y){
        controleur.deselectionnerCasesPossibles();
        int xDepart,yDepart;
        Pokemon p ;
        if(joueur1){
            xDepart=pokemonCaseJoueur1.get(pokemonsJoueur1.get(posPokemonInList)).getPosI();
            yDepart=pokemonCaseJoueur1.get(pokemonsJoueur1.get(posPokemonInList)).getPosJ();
            p= pokemonsJoueur1.get(posPokemonInList);
            pokemonCaseJoueur1.put(p,terrain.getCase(x,y));
            terrain.setPokemon(xDepart, yDepart, null);
            terrain.setPokemon(x, y, p);
        }
        else{
            xDepart=pokemonCaseJoueur2.get(pokemonsJoueur2.get(posPokemonInList)).getPosI();
            yDepart=pokemonCaseJoueur2.get(pokemonsJoueur2.get(posPokemonInList)).getPosJ();
            p = pokemonsJoueur2.get(posPokemonInList);
            pokemonCaseJoueur2.put(p,terrain.getCase(x,y));
            terrain.setPokemon(xDepart, yDepart, null);
            terrain.setPokemon(x, y, p);
        }
        controleur.deplacerPokemonPourVue(new Pair(xDepart,yDepart,0), new Pair(x,y,0), p.getCheminImage());
        selectPokemon();    
    }

    
}
