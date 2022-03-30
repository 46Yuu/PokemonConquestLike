package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaquePoison extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Fee" || b.getType()=="Plante"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Poison" || b.getType()=="Roche" || b.getType()=="Sol" || b.getType()=="Spectre"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else if(b.getType()=="Acier"){
            b.setPdv(b.getPdv() - 0);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
