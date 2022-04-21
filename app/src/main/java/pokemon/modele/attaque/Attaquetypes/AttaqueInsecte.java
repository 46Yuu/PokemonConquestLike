package pokemon.modele.attaque.Attaquetypes;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueInsecte extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Acier" || b.getType()=="Combat" || b.getType()=="Fee" || b.getType()=="Feu" || b.getType()=="Poison" || b.getType()=="Spectre" || b.getType()=="Vol" ){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
            }
            else{
                if(b.getType()=="Plante" || b.getType()=="Psy" || b.getType()=="Tenebres"){
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
            if(b.getType()=="Plante" || b.getType()=="Psy" || b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
            }
            else if(b.getType()=="Acier" || b.getType()=="Combat" || b.getType()=="Fee" || b.getType()=="Feu" || b.getType()=="Poison" || b.getType()=="Spectre" || b.getType()=="Vol" ){
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
        return "Insecte";
    }
}