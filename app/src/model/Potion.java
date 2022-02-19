public class Potion extends Objets {
    public Potion(){
        this.nom="Potion";
    }

    public Utiliser(Pokemon p){
        p.Pdv=p.Pdv +10;
    }
}
