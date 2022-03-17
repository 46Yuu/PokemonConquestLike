public class Potion extends Objets {
    public Potion(){
        this.nom="Potion";
    }

    public void Utiliser(Pokemon p){
        p.setPdv(p.getPdv() +20);
        if(p.getPdv() > p.getPdvdeBase()){
            p.setPdv(p.getPdvdeBase());
        }
    }
}
