package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueNormal extends Attaque {
    public void Attack(Pokemon p,Pokemon b){  
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Acier" || b.getType()=="Roche"){
                b.setPdv(b.getPdv() - p.getAtk());
            }
            else if(b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - 0);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
        } 
        else {
            if(b.getType()=="Acier" || b.getType()=="Roche"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
            }
            else if(b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - 0);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }
}
