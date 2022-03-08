public class ForceInterieur extends CapacitSpe{

    public ForceInterieur(){
        this.nom = "ForceInterieur";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
          p.Crit = Crit +10;
    }
}