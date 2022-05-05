package pokemon.modele.attaque.ListeAttaques;

import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.pokemon.Pokemon;

public class vibraqua extends AttaqueEau{
    @Override
    public int getDistanceMaxAttaque(){
        return 2;
    }

    public String getInfo(){
        return "Le lanceur envoie un puissant jet d'eau sur l'ennemi. Peut le rendre confus. \n(20%. Confus = 33% de rater son attaque et se blesser , disparait entre 1 et 2 tour.";
    }

    public void effet(Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= 20){
            b.setConfus(true);
        }
    }

    @Override
    public void Attack(Pokemon p, Pokemon b){
        super.Attack(p,b);
        effet(b);
    }
}