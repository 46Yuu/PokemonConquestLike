package pokemon.modele;

import java.util.HashMap;

import pokemon.controleur.Controleur;

public class Jeux {
    /**
     * le joueur 1
     */
    private Joueur j1;
    /**
     * le joueur 2
     */
    private Joueur j2;
    /**
     * Le joueur dont c'est le tour
     */
    private Joueur joueurActuel;
    /**
     * Le pokémo qui doit être déplacé  
     */ 
    private int posPokemonActuel;
    /**
     * Le nombre de pokémons que possède le joueur
     */
    private int nbPokemonsJoueur;

    private Controleur controleur;

    public Jeux(Joueur j1, Joueur j2){
        this.j1=j1;
        joueurActuel=j1;
        this.j2=j2;
    }

    public void setControleur(Controleur controleur){
        this.controleur=controleur;
    }

    /**
     * met à joueur le joueur actuel et le nombre de pokémons que possède le joueur
     * met la position du pokémon actuel à zéro
     * @param j le nouveau joueur dont c'est le tour
     */
    public void setJoueurActuel(Joueur j){
        joueurActuel=j;
        nbPokemonsJoueur=j.getNbPokemons();
        posPokemonActuel=0;
    }

    /**
     * @return le joueur actuel
     */
    public Joueur getJoueurActuel(){
        return joueurActuel;
    }

    /**
     *met à joueur la position du pokémon à déplacer  
     *@param pos position du pokémon à déplacer
     */ 
    public void setPosPokemonActuel(int pos){
        posPokemonActuel=pos;
    }

    /**
     * @return la position du pokémon qui doit être déplacé
     */
    public int getPosPokemonActuel(){
        return posPokemonActuel;
    }


    /**
     * demande au joueur actuel de déplacer le pokémon actuel
     * met à jour la position du pokémon actuel
     * et celle du joueur actuel, si le joueur à déplacé tous ses pokémons
     */
    public void joueurTour(){
        controleur.miseAJourInformations();
        joueurActuel.deplacer(posPokemonActuel);
        posPokemonActuel++;
        if(posPokemonActuel>=nbPokemonsJoueur){//le joueur à déplacé tous ses pokémons
            if(joueurActuel==j1)//on passe à j2
                setJoueurActuel(j2);
            else//on passe à j1
                setJoueurActuel(j1);
        }
    }

    /**
     * met les pokémons des joueurs 1 et 2 dans le terrain
     * @param tab tableau de case (le terrain)
     * @param list hashmap (case->pokémon)
     */
    public void poserPokemons(Case[][] tab, HashMap<Case, Pokemon> list) {
        int i=-2, j=-2;
        for(Pokemon k : j1.getListPokemon()){
            if(j>=tab[0].length){
                j=-2;
                i+=2;
            }
            list.put(tab[i+2][j+2], k);
            j+=2;
        }   
        i=tab.length-3;
        j=-2;
        for(Pokemon k : j2.getListPokemon()){
            if(j>=tab[0].length){
                j=-2;
                i-=2;
            }
            list.put(tab[i+2][j+2], k);
            j+=2;
        }        
    }
}
