package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueElectrique extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Eau" || b.getType()=="Vol"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Dragon" || b.getType()=="Electrique" || b.getType()=="Plante"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else if(b.getType()=="Sol"){
            b.setPdv(b.getPdv() - 0);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
