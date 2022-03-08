public class Sniper extends CapacitSpe{

    public Sniper(){
        this.nom = "Sniper";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
      p.Crit = p.Crit + 10;
         }
    }
}