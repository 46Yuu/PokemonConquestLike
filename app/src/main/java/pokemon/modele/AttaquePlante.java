package pokemon.modele;

public class AttaquePlante extends Attaque{
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Eau"){
            b.setPdv(b.getPdv() - (p.getAtk()*2));
        }
        else if(b.getType()=="Roche"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        } 
        else if(b.getType()=="Feu"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        } 
        else if(b.getType()=="Plante"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        } 
        else if(b.getType()=="Vol"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
