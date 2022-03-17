public class AbsorbPoison extends CapacitSpe {
    public AbsorbPoison(){
        this.nom = "AbsorbPoison";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
    }
}

