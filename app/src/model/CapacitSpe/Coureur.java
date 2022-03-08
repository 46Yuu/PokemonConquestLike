public class Coureur extends CapacitSpe{

    public Coureur(){
        this.nom = "Coureur";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
          p.Vit = Vit +10;
    }
}