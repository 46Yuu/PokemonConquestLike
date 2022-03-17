package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueCombat extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Normal"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Vol"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
