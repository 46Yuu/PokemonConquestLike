package pokemon.modele.attaque.Attaquetypes;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaquePoison extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Fee" || b.getType()=="Plante"){
                b.setPdv(b.getPdv() - p.getAtk()*4);
                supEff();
                crit();
            }
            else if(b.getType()=="Poison" || b.getType()=="Roche" || b.getType()=="Sol" || b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
                crit();
            }
            else if(b.getType()=="Acier"){
                b.setPdv(b.getPdv() - 0);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk()*2);
                crit();
            }
        }
        else {
            if(b.getType()=="Fee" || b.getType()=="Plante"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
            }
            else if(b.getType()=="Poison" || b.getType()=="Roche" || b.getType()=="Sol" || b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
                pasEff();
            }
            else if(b.getType()=="Acier"){
                b.setPdv(b.getPdv() - 0);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }
}
