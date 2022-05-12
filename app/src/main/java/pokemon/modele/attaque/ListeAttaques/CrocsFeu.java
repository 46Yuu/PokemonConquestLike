package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class CrocsFeu extends AttaqueFeu{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Le lanceur utilise une morsure enflammée. Peut aussi brûler ou apeurer l'ennemi.\n(10% / 10%. Brulure = 1/16 des pdv actuel après chaque action. Peur = ne peut rien faire pendant un tour.)";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 10){
            b.setEffet("Brule");
        }
        int tmp2 = (int)(Math.random()*100)+1; 
        if(tmp2 <= 10){
            b.setPeur(true);
        }
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
        effet(b);
    }
}