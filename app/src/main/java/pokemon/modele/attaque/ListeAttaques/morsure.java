package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class morsure extends AttaqueTenebres{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "L'ennemi est mordu par de tranchantes canines. Peut l'apeurer. \n(30%. Peur = ne peut rien faire pendant 1 tour)";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 30){
            b.setEffet("Peur");
        }
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
        effet(b);
    }
}
