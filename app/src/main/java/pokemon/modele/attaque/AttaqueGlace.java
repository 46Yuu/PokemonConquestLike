package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;
import pokemon.audio.Audio;

public class AttaqueGlace extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        int tmp = (int)(Math.random()*100)+1; 
        if(tmp < p.getCrit()){
            if(b.getType()=="Dragon" || b.getType()=="Plante" || b.getType()=="Sol" || b.getType()=="Vol"){
                b.setPdv(b.getPdv() - p.getAtk()*4);
                supEff();
                crit();
            }
            else if(b.getType()=="Acier" || b.getType()=="Eau" || b.getType()=="Feu" || b.getType()=="Glace"){
                b.setPdv(b.getPdv() - p.getAtk());
                pasEff();
                crit();
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk()*2);
                crit();
            }
        }
        else {
            if(b.getType()=="Dragon" || b.getType()=="Plante" || b.getType()=="Sol" || b.getType()=="Vol"){
                b.setPdv(b.getPdv() - p.getAtk()*2);
                supEff();
            }
            else if(b.getType()=="Acier" || b.getType()=="Eau" || b.getType()=="Feu" || b.getType()=="Glace"){
                b.setPdv(b.getPdv() - p.getAtk()/2);
                pasEff();
            }
            else {
                b.setPdv(b.getPdv() - p.getAtk());
            }
        }   
    }
}