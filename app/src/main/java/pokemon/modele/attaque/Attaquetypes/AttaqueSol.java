package pokemon.modele.attaque.Attaquetypes;

import javax.swing.plaf.ColorUIResource;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueSol extends Attaque{        
    public void attackBis(Pokemon p, Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= p.getCrit()){
            if(b.getType()=="Vol"){
                b.setPdv(b.getPdv() - 0);
                hit();
            }
            else if(b.getType()=="Insecte" || b.getType()=="Plante"){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
            }
            else{
                if(b.getType()=="Acier" || b.getType()=="Electrique" || b.getType()=="Glace" || b.getType()=="Poison" || b.getType()=="Roche"){
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
            if(b.getType()=="Acier" || b.getType()=="Electrique" || b.getType()=="Glace" || b.getType()=="Poison" || b.getType()=="Roche"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
            }
            else if(b.getType()=="Insecte" || b.getType()=="Plante"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
                pasEff();
            }
            else if(b.getType()=="Vol"){
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
        return "Sol";
    }

    public ColorUIResource getColorLabelType(){
        return new ColorUIResource(226, 191, 101);
    }
    
    @Override
    public String getInfo() {
        return null;
    }
}
