package pokemon.modele.jeux;

import java.util.HashMap;
import java.util.LinkedList;

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
    private LinkedList<Pokemon> pokemonsJoueur1;
    /**
     * liste des pokémons du joueur 2
     */
    private LinkedList<Pokemon> pokemonsJoueur2;
    /**
     * position du pokémon qui doit être déplacé dans la liste
     *  du joueur 1, si c'est le tour du joueur 1
     *  du joueur 2, sinon
     */
    private int posPokemonInList=-1;
    /**
     * tour du joueur 1, si true
     * tour du joueur 2, sinon
     */
    private boolean joueur1=true;
    
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
            controleur.placerPokemon(p,x,y);
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
            controleur.placerPokemon(p,x,y);
            y+=4;
        }     
    }

    /**
     * sélectionne le pokémon qui doit être déplacé
     */
    public void selectPokemon() {
        if(joueur1 && posPokemonInList==pokemonsJoueur1.size()-1){
            joueur1=false;
            posPokemonInList=-1;
            controleur.miseAJourInformations("Joueur 2");
        }
        else if(!joueur1 && posPokemonInList==pokemonsJoueur2.size()-1){
            joueur1=true;
            posPokemonInList=-1;
            controleur.miseAJourInformations("Joueur 1");
        }
        posPokemonInList++;
        if(joueur1){
            controleur.selectionnerCase(pokemonCaseJoueur1.get(pokemonsJoueur1.get(posPokemonInList)));
        }
        else{
            controleur.selectionnerCase(pokemonCaseJoueur2.get(pokemonsJoueur2.get(posPokemonInList)));
        }
    }

    /**
     * déplace le pokémon qui doit être déplacé dans ma case x,y
     * @param x coordonnée x de la case d'arrivée
     * @param y coordonnée y de la case d'arrivée
     */
    public void deplacerPokemon(int x, int y){
        controleur.deselectionnerCasesPossibles();
        int xDepart,yDepart;//coordonnées du pokémon à déplacer 
        Pokemon p ;
        if(joueur1){
            xDepart=pokemonCaseJoueur1.get(pokemonsJoueur1.get(posPokemonInList)).getPosI();
            yDepart=pokemonCaseJoueur1.get(pokemonsJoueur1.get(posPokemonInList)).getPosJ();
            p= pokemonsJoueur1.get(posPokemonInList);
            //on met à jour la case du pokémon dans la HashMap<Pokemon,Case>
            pokemonCaseJoueur1.put(p,terrain.getCase(x,y));
            //on enlève le pokémon de la case de départ
            terrain.setPokemon(xDepart, yDepart, null);
            //on ajoute le pokémon à la case d'arrivée 
            terrain.setPokemon(x, y, p);
        }
        else{
            xDepart=pokemonCaseJoueur2.get(pokemonsJoueur2.get(posPokemonInList)).getPosI();
            yDepart=pokemonCaseJoueur2.get(pokemonsJoueur2.get(posPokemonInList)).getPosJ();
            p = pokemonsJoueur2.get(posPokemonInList);
            //on met à jour la case du pokémon dans la HashMap<Pokemon,Case>
            pokemonCaseJoueur2.put(p,terrain.getCase(x,y));
            //on enlève le pokémon de la case de départ
            terrain.setPokemon(xDepart, yDepart, null);
            //on ajoute le pokémon à la case d'arrivée 
            terrain.setPokemon(x, y, p);
        }
        //mettre à jour la vue
        controleur.deplacerPokemonDansVue(new Pair(xDepart,yDepart,0), new Pair(x,y,0), p.getCheminImage());
        //sélectionner le pokémon suivant à déplacer  
        controleur.afficherBoutons();
    }    
}
