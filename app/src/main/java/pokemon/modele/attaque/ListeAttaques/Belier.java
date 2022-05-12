package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Belier extends AttaqueNormal{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Une charge violente qui blesse aussi légèrement le lanceur. (-1/16 des pdv actuel)";
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        int tmp = p.getAtk();
        p.setAtk(tmp+5);
        super.Attack(p,b);
        p.setAtk(tmp);
        p.setPdv(p.getPdv()-(p.getPdv()/16));
        hit();
    }
}