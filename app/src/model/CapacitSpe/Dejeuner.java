public class Dejeuner extends CapacitSpe{

    public Dejeuner(){
        this.nom = "Dejeuner";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
    }
    public void Utiliser(Pokemon p1,Pokemon p2,Pokemon adv1,Pokemon adv2){
     if(p1.getPdv() < p1.getPdvdeBase()){
         p1.setPdv(p1.getAtk + 2);
     }
    }

}