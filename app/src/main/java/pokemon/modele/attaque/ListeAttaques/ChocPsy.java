package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class ChocPsy extends AttaquePsy{
    @Override
    public int getDistanceMaxAttaque(){
        return 3;
    }

    public String getInfo(){
        return "Le lanceur matérialise des ondes mystérieuses qu’il projette sur l’ennemi. Inflige des dégâts physiques.";
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
    }
}