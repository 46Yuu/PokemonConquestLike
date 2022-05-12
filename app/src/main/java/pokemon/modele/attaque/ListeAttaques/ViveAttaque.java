package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class ViveAttaque extends AttaqueNormal{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Le lanceur fonce sur l'ennemi si rapidement qu'on parvient à peine à le discerner.";
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
    }
}