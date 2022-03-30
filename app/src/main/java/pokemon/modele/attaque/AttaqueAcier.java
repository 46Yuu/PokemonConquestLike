package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueAcier extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Fee" || b.getType()=="Glace" || b.getType()=="Roche"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Acier" || b.getType()=="Eau" || b.getType()=="Electrique" || b.getType()=="Feu"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
