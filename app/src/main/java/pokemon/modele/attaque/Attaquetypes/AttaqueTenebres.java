package pokemon.modele.attaque.Attaquetypes;

import javax.swing.plaf.ColorUIResource;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueTenebres extends Attaque{         
    public void attackBis(Pokemon p, Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= p.getCrit()){
            if(b.getType()=="Combat" || b.getType()=="Fee" || b.getType()=="Tenebres"){
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
            else if(b.getType()=="Combat" || b.getType()=="Fee" || b.getType()=="Tenebres"){
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
        return "Tenebres";
    }

    public ColorUIResource getColorLabelType(){
        return new ColorUIResource(112, 87, 70);
    }
    
    @Override
    public String getInfo() {
        return null;
    }
}
