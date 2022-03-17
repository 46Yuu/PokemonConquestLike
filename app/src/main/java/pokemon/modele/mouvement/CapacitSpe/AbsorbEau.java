public class AbsorbEau extends CapacitSpe{

    public AbsorbEau(){
        this.nom = "AbsorbEau";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
    }
}