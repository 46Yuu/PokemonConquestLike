public class Brasier extends CapacitSpe{

    public Brasier(){
        this.nom = "Brasier";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
    }
    public void Utiliser(Pokemon p1,Pokemon p2,Pokemon adv1,Pokemon adv2){
     if(p1.getPdv() < p1.getPdvdeBase()/3){
         p1.setAtk(p1.getAtk + 2);
     }
    }

}