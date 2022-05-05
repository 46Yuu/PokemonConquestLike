package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class belier extends AttaqueNormal{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Une charge violente qui blesse aussi légèrement le lanceur. (-1 pv)";
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
        p.setPdv(p.getPdv()-1);
        hit();
    }
}