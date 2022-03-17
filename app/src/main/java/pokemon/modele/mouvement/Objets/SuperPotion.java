public class SuperPotion extends Objets {
    public SuperPotion(){
        this.nom="Super Potion";
    }

    public void Utiliser(Pokemon p){
        p.setPdv(p.getPdv() +50);
        if(p.getPdv() > p.getPdvdeBase()){
            p.setPdv(p.getPdvdeBase());
    }
}
}
