package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueTenebres extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Psy" || b.getType()=="Spectre"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Combat" || b.getType()=="Fee" || b.getType()=="Tenebres"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
