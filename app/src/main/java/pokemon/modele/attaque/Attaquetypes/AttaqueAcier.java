package pokemon.modele.attaque.Attaquetypes;

import javax.swing.plaf.ColorUIResource;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueAcier extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        if(p.getConfus() == true){
            if (p.getConfusTour()>0){
                int nonConfus = (int)(Math.random()*100)+1;
                if(nonConfus<=33){
                    p.setConfusTour(2);
                    p.setConfus(false);
                    paralyse(p, b);
                } 
                else {
                    p.setConfusTour(p.getConfusTour()-1);
                    p.setPdv(p.getPdv()-1);
                }
            }
            else {
                p.setConfusTour(0);
                p.setConfus(false);
                paralyse(p, b);
            }
        }
        else{
            paralyse(p, b);
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
                        hit();
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
                    hit();
                }
            }
    }

    @Override
    public String getType() {
        return "Acier";
    }

    public ColorUIResource getColorLabelType(){
        return new ColorUIResource( 183, 183, 206);
    }
    
    @Override
    public String getInfo() {
        return null;
    }
}