package pokemon.modele.attaque.Attaquetypes;

import javax.swing.plaf.ColorUIResource;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueSpectre extends Attaque{
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
            if(b.getType()=="Normal"){
                b.setPdv(b.getPdv() - 0);
                hit();
            }
            else if(b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
            }
            else{
                if(b.getType()=="Psy" || b.getType()=="Spectre"){
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
            if(b.getType()=="Psy" || b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
            }
            else if(b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
                pasEff();
            }
            else if(b.getType()=="Normal"){
                b.setPdv(b.getPdv() - 0);
                hit();
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
                hit();
            }
        }
    }

    @Override
    public String getType() {
        return "Spectre";
    }

    public ColorUIResource getColorLabelType(){
        return new ColorUIResource(115, 87, 151);
    }
    
    @Override
    public String getInfo() {
        return null;
    }
}
