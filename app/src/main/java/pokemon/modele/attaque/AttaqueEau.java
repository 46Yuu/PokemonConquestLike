package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueEau extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Feu" || b.getType()=="Roche" || b.getType()=="Sol"){
                b.setPdv(b.getPdv() - p.getAtk()*4);
            }
            else if(b.getType()=="Dragon" || b.getType()=="Eau" || b.getType()=="Plante"){
                b.setPdv(b.getPdv() - p.getAtk());
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
        }
        else {
            if(b.getType()=="Feu" || b.getType()=="Roche" || b.getType()=="Sol"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
            else if(b.getType()=="Dragon" || b.getType()=="Eau" || b.getType()=="Plante"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }
}
