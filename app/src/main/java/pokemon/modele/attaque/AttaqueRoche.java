package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueRoche extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Feu" || b.getType()=="Glace" || b.getType()=="Insecte" || b.getType()=="Vol"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Acier" || b.getType()=="Combat" || b.getType()=="Sol"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
