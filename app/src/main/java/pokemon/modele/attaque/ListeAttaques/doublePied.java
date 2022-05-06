package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class doublePied extends AttaqueCombat{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Deux coups de pied qui frappent l'ennemi deux fois d'affilée.";
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        int tmp = p.getAtk();
        p.setAtk((p.getAtk()/5)*3);
        super.Attack(p,b);
        super.Attack(p,b);
        p.setAtk(tmp);
    }
}