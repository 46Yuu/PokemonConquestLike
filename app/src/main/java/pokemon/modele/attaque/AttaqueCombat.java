package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueCombat extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Acier" || b.getType()=="Glace" || b.getType()=="Normal" || b.getType()=="Roche" || b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - p.getAtk()*4);
            }
            else if(b.getType()=="Fee" || b.getType()=="Insecte" || b.getType()=="Poison" || b.getType()=="Psy" || b.getType()=="Vol"){
                b.setPdv(b.getPdv() - p.getAtk());
            }
            else if(b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - 0);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
        }
        else {
            if(b.getType()=="Acier" || b.getType()=="Glace" || b.getType()=="Normal" || b.getType()=="Roche" || b.getType()=="Tenebres"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
            else if(b.getType()=="Fee" || b.getType()=="Insecte" || b.getType()=="Poison" || b.getType()=="Psy" || b.getType()=="Vol"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
            }
            else if(b.getType()=="Spectre"){
                b.setPdv(b.getPdv() - 0);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }
}
