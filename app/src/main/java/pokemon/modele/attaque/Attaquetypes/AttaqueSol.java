package pokemon.modele.attaque.Attaquetypes;

import pokemon.modele.attaque.Attaque;
import pokemon.modele.pokemon.Pokemon;

public class AttaqueSol extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        if(p.getEffet()=="Paralyse"){
            int tmp = (int)(Math.random()*100)+1;
            if(tmp>=25){
                attackBis(p,b);
            } 
        }
        else{
            attackBis(p, b);
        }
    }
                
    public void attackBis(Pokemon p, Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp <= p.getCrit()){
            if(b.getType()=="Vol"){
                b.setPdv(b.getPdv() - 0);
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
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }

    @Override
    public String getType() {
        return "Sol";
    }
}
