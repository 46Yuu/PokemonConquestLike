package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueInsecte extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Plante" || b.getType()=="Psy" || b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - p.getAtk()*4);
            }
            else if(b.getType()=="Acier" || b.getType()=="Combat" || b.getType()=="Fee" || b.getType()=="Feu" || b.getType()=="Poison" || b.getType()=="Spectre" || b.getType()=="Vol" ){
                b.setPdv(b.getPdv() - p.getAtk());
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
        }
        else {
            if(b.getType()=="Plante" || b.getType()=="Psy" || b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
            else if(b.getType()=="Acier" || b.getType()=="Combat" || b.getType()=="Fee" || b.getType()=="Feu" || b.getType()=="Poison" || b.getType()=="Spectre" || b.getType()=="Vol" ){
                b.setPdv(b.getPdv() - p.getAtk()/2);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }
}