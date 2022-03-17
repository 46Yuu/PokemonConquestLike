public class AbsorbFeu extends CapacitSpe{
    public AbsorbFeu(){
        this.nom = "AbsorbEau";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
    }

}
