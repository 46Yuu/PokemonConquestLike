package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class eclair extends AttaqueElectrique{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }

    public String getInfo(){
        return "Une décharge électrique tombe sur l'ennemi. Peut aussi le paralyser. (10%)";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 10){
            b.setEffet("Paralyse");
        }
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
        effet(b);
    }
}