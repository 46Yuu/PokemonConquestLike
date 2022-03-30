package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueFeu extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Acier" || b.getType()=="Glace" || b.getType()=="Insecte" || b.getType()=="Plante"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Dragon" || b.getType()=="Eau" || b.getType()=="Feu" || b.getType()=="Roche"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}