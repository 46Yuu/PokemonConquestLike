public class AbsorbPoison extends CapacitSpe {
    public AbsorbPoison(){
        this.nom = "AbsorbPoison";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
    }
    public void Utiliser(Pokemon p1,Pokemon p2,Pokemon adv1,Pokemon adv2){

    }
}
