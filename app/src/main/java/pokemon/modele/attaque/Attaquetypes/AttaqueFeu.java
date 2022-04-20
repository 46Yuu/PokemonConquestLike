package pokemon.modele.attaque.Attaquetypes;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueFeu extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Acier" || b.getType()=="Glace" || b.getType()=="Insecte" || b.getType()=="Plante"){
                b.setPdv(b.getPdv() - p.getAtk()*4);
                supEff();
                crit();
            }
            else if(b.getType()=="Dragon" || b.getType()=="Eau" || b.getType()=="Feu" || b.getType()=="Roche"){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
                crit();
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk()*2);
                crit();
            }
        }
        else {
            if(b.getType()=="Acier" || b.getType()=="Glace" || b.getType()=="Insecte" || b.getType()=="Plante"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
            }
            else if(b.getType()=="Dragon" || b.getType()=="Eau" || b.getType()=="Feu" || b.getType()=="Roche"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
                pasEff();
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }
}