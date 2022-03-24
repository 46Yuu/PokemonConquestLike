package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public class AttaqueSol extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Acier" || b.getType()=="Electrique" || b.getType()=="Glace" || b.getType()=="Poison" || b.getType()=="Roche"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Insecte" || b.getType()=="Plante"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else if(b.getType()=="Vol"){
            b.setPdv(b.getPdv() - 0);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
