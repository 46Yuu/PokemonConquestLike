package pokemon.modele.attaque.Attaquetypes;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueAcier extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        if(p.getEffet()=="Paralyse"){
            int tmp = (int)(Math.random()*100)+1;
            if(tmp>=25){
                attackBis(p,b);
            } 
        }
        else{
            attackBis(p, b);
        }
    }

    public void attackBis(Pokemon p, Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
            if(tmp <= p.getCrit()){
                if(b.getType()=="Acier" || b.getType()=="Eau" || b.getType()=="Electrique" || b.getType()=="Feu"){
                    b.setPdv(b.getPdv() - p.getAtk());
                    pasEff();
                }
                else {
                    if(b.getType()=="Fee" || b.getType()=="Glace" || b.getType()=="Roche"){
                        b.setPdv(b.getPdv() - p.getAtk()*4);
                        supEff();
                    }
                    else {
                        b.setPdv(b.getPdv() - p.getAtk()*2);
                    }
                    crit();
                }
            }
            else {
                if(b.getType()=="Fee" || b.getType()=="Glace" || b.getType()=="Roche"){
                    b.setPdv(b.getPdv() - p.getAtk()*2);
                    supEff();
                }
                else if(b.getType()=="Acier" || b.getType()=="Eau" || b.getType()=="Electrique" || b.getType()=="Feu"){
                    b.setPdv(b.getPdv() - p.getAtk()/2);
                    pasEff();
                }
                else {
                    b.setPdv(b.getPdv() - p.getAtk());
                }
            }
    }

    @Override
    public String getType() {
        return "Acier";
    }
}
