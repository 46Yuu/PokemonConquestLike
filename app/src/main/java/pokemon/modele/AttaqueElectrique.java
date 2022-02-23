package pokemon.modele;

public class AttaqueElectrique extends Attaque {
    public void Attack(Pokemon p,Pokemon b){
        if(b.getType()=="Vol"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Eau"){
            b.setPdv(b.getPdv() - p.getAtk()*2);
        }
        else if(b.getType()=="Plante"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else if(b.getType()=="Electrique"){
            b.setPdv(b.getPdv() - p.getAtk()/2);
        }
        else {
            b.setPdv(b.getPdv() - p.getAtk());
        }
    }
}
