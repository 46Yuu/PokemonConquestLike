package pokemon.controleur;

import pokemon.modele.Terrain;

public class Controleur {
    public boolean deplacerPokemon;
    public int anciennePosI;
    public int anciennePosY;
    public Terrain terrain;

    public Controleur(Terrain p){
        terrain=p;
    }


    public void deplacerPokemon(int x, int y) {
    }
}
