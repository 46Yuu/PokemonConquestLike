package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueFee extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Combat" || b.getType()=="Dragon" || b.getType()=="Tenebres"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Acier" || b.getType()=="Feu" || b.getType()=="Poison"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
