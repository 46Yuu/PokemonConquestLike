package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class picpic extends AttaqueVol{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Frappe l'ennemi d'un bec pointu ou d'une corne pour infliger des dégâts.";
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
    }
}