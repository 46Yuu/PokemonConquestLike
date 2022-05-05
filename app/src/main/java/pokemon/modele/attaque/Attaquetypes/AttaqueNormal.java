package pokemon.modele.attaque.Attaquetypes;

import javax.swing.plaf.ColorUIResource;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueNormal extends Attaque {
    public void attackBis(Pokemon p, Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= p.getCrit()){
            if(b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - 0);
                hit();
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
        return "Normal";
    }

    public ColorUIResource getColorLabelType(){
        return new ColorUIResource(168, 167, 122);
    }
    
    @Override
    public String getInfo() {
        return null;
    }
}
