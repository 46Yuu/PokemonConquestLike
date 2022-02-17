package pokemon.modele;

import java.util.HashMap;
import java.util.LinkedList;

import pokemon.controleur.Controleur;

public class Joueur {
    String nom;
    /**
     * liste contenant les pokémons du joueur
     * dans l'ordre qu'ils doivent être déplacés
     */
    LinkedList< Pokemon> listPokemons;
    /**
     * pour chaque pokemon du joueur, associe une case
     */
    HashMap<Pokemon,Case> mapPokemonCase;

    Controleur controleur;
    
    public Joueur(String nom){
        this.nom=nom;
        listPokemons=new LinkedList<>();
        mapPokemonCase=new HashMap<>();
    }

    /**
     * @return nom du joueur
     */
    public String getNom(){
        return nom;
    }

    /**
     * Ajoute le pokemon k à la fin de la liste des Pokémons du joueur 
     * @param k un pokémon
     */
    public void ajouterPokemon(Pokemon k){
        listPokemons.addLast(k);
    }
    
     /**
     * Ajoute le pokemon k à la position pos de la liste des Pokémons du joueur 
     * @param k un pokémon
     * @param pos la position où placer le pokémon
     */
    public void ajouterPokemon(Pokemon k, int pos){
        listPokemons.add(pos,k);
    }

    /**  
     * @return le nombre de pokémons que possède le joueur
     */
    public int getNbPokemons() {
        return listPokemons.size();
    }

    public LinkedList<Pokemon> getListPokemon(){
        return listPokemons;
    }

    public void deplacer(int posPokemonActuel) {
        controleur.selectionnerCase(mapPokemonCase.get(listPokemons.get(posPokemonActuel)));
    }

    public void ajoutPokemonCase(Pokemon k, Case c){
        mapPokemonCase.put(k,c);
    }

    public void setControleur(Controleur c) {
        this.controleur=c;
    }

    public void setTerrainPourPokemon(Pokemon p,Case c) {
        mapPokemonCase.put(p,c);
    }
}
