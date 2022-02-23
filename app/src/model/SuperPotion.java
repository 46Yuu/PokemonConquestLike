public class SuperPotion extends Objets {
    public SuperPotion(){
        this.nom="Super Potion";
    }

    public void Utiliser(Pokemon p){
        p.Pdv=p.Pdv +50;
    }
}
