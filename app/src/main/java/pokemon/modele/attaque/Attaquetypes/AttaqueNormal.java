package pokemon.modele.attaque.Attaquetypes;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueNormal extends Attaque {
    public void Attack(Pokemon p,Pokemon b){  
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - 0);
            }
            else{
                if(b.getType()=="Acier" || b.getType()=="Roche"){
                    b.setPdv(b.getPdv() - p.getAtk());
                    supEff();
                }
                else {
                    b.setPdv(b.getPdv() - p.getAtk()*2);
                }
                crit();
            }   
        } 
        else {
            if(b.getType()=="Acier" || b.getType()=="Roche"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
                supEff();
            }
            else if(b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - 0);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }
        
    @Override
    public String getType() {
        return "Normal";
    }
}
