public class Potion extends Objets {
    public Potion(){
        this.nom="Potion";
    }

    public void Utiliser(Pokemon p){
        p.Pdv=p.Pdv +20;
    }
}
