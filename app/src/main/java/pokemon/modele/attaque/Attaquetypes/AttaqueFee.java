package pokemon.modele.attaque.Attaquetypes;

import javax.swing.plaf.ColorUIResource;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueFee extends Attaque {
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
            if(b.getType()=="Acier" || b.getType()=="Feu" || b.getType()=="Poison"){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
            }
            else {
                if(b.getType()=="Combat" || b.getType()=="Dragon" || b.getType()=="Tenebres"){
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
            if(b.getType()=="Combat" || b.getType()=="Dragon" || b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
            }
            else if(b.getType()=="Acier" || b.getType()=="Feu" || b.getType()=="Poison"){
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
        return "Fee";
    }

    public ColorUIResource getColorLabelType(){
        return new ColorUIResource(214, 133, 173);
    }
}
