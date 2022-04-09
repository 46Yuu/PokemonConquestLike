package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaquePlante extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Eau" || b.getType()=="Roche" || b.getType()=="Sol"){
                b.setPdv(b.getPdv() - p.getAtk()*4);
            }
            else if(b.getType()=="Acier" || b.getType()=="Eau" || b.getType()=="Feu" || b.getType()=="Insecte" || b.getType()=="Plante" || b.getType()=="Poison" || b.getType()=="Vol" ){
                b.setPdv(b.getPdv() - p.getAtk());
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
        }
        else {
            if(b.getType()=="Eau" || b.getType()=="Roche" || b.getType()=="Sol"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
            }
            else if(b.getType()=="Acier" || b.getType()=="Eau" || b.getType()=="Feu" || b.getType()=="Insecte" || b.getType()=="Plante" || b.getType()=="Poison" || b.getType()=="Vol" ){
                b.setPdv(b.getPdv() - p.getAtk()/2);
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }
    }
}
