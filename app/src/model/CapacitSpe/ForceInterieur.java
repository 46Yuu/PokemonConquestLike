public class ForceInterieur extends CapacitSpe{

    public ForceInterieur(){
        this.nom = "ForceInterieur";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
          p.setCrit(p.getCrit() +10);
    }
    public void Utiliser(Pokemon p1,Pokemon p2,Pokemon adv1,Pokemon adv2){

    }
}