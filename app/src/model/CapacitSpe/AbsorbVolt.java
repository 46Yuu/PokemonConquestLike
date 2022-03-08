public class AbsorbVolt extends CapacitSpe{

    public AbsorbVolt(){
        this.nom = "AbsorbVolt";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
    }
}