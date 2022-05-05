package pokemon.modele.attaque.Attaquetypes;

import javax.swing.plaf.ColorUIResource;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueRoche extends Attaque{
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
            if(b.getType()=="Acier" || b.getType()=="Combat" || b.getType()=="Sol"){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
            }
            else{
                if(b.getType()=="Feu" || b.getType()=="Glace" || b.getType()=="Insecte" || b.getType()=="Vol"){
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
            if(b.getType()=="Feu" || b.getType()=="Glace" || b.getType()=="Insecte" || b.getType()=="Vol"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
            }
            else if(b.getType()=="Acier" || b.getType()=="Combat" || b.getType()=="Sol"){
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
        return "Roche";
    }

    public ColorUIResource getColorLabelType(){
        return new ColorUIResource(182, 161, 54);
    }
    
    @Override
    public String getInfo() {
        return null;
    }
}
