package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class poudreuse extends AttaqueGlace{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }

    public String getInfo(){
        return "Le lanceur projette de la neige poudreuse.";
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
    }
}