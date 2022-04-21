package pokemon.modele.attaque.Attaquetypes;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueVol extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Acier" || b.getType()=="Electrique" || b.getType()=="Roche"){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
            }
            else{
                if(b.getType()=="Combat" || b.getType()=="Insecte" || b.getType()=="Plante"){
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
            if(b.getType()=="Combat" || b.getType()=="Insecte" || b.getType()=="Plante"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
            }
            else if(b.getType()=="Acier" || b.getType()=="Electrique" || b.getType()=="Roche"){
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
        return "Vol";
    }
}
