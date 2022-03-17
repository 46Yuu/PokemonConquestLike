public class Intimidation extends CapacitSpe{

    public Intimidation(){
        this.nom = "Intimidation";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
      
         }
         public void Utiliser(Pokemon p1,Pokemon p2,Pokemon adv1,Pokemon adv2){
            adv1.setAtk(p.getAtk() -2);
          adv2.setAtk(p.getAtk() -2);

        }
    }
}