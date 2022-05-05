package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class flammeche extends AttaqueFeu{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }

    @Override 
    public boolean jusquADistanceMax(){
        return false;
    }

    public String getInfo(){
        return "L'ennemi est attaqué par une faible flamme. Peut aussi le brûler. \n(10%. Brulure = -1pv après chaque action.)";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 10){
            b.setEffet("Brule");
        }
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
        effet(b);
    }
}