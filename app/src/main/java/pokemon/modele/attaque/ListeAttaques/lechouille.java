package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class lechouille extends AttaqueSpectre{
    @Override
    public int getDistanceMaxAttaque(){
        return 1;
    }

    public String getInfo(){
        return "Un grand coup de langue qui inflige des dégâts à l'ennemi. Peut aussi le paralyser. \n(30%. Paralysie = 25% de rater son attaque et avance de 1 case de moins.)";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 30){
            b.setEffet("Paralyse");
        }
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
        effet(b);
    }
}
