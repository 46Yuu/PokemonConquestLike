package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class Souplesse extends AttaqueNormal{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Fouette l’ennemi avec la queue ou une liane, par exemple, pour infliger des dégâts.";
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
    }
}