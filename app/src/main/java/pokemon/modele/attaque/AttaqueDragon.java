package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueDragon extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Dragon"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Acier"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else if(b.getType()=="Fee"){
            b.setPdv(b.getPdv() - 0);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
