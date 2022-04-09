package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaquePsy extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Combat" || b.getType()=="Poison"){
                b.setPdv(b.getPdv() - p.getAtk()*4);
            }
            else if(b.getType()=="Acier" || b.getType()=="Psy"){
                b.setPdv(b.getPdv() - p.getAtk());
            }
            else if(b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - 0);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
        }
        else {
            if(b.getType()=="Combat" || b.getType()=="Poison"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
            else if(b.getType()=="Acier" || b.getType()=="Psy"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
            }
            else if(b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - 0);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }
}
