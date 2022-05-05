package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class tranchHerbe extends AttaquePlante{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Des feuilles aiguisées comme des rasoirs entaillent l’ennemi. Taux de critiques élevé.";
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        p.setCrit(p.getCrit()*2);
        super.Attack(p,b);
        p.setCrit(p.getCrit()/2);
    }
}