
public class Ronflement extends CapacitSpe{

    public Ronflement(){
        this.nom = "Ronflement";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
          
         }
         public void Utiliser(Pokemon p1,Pokemon p2,Pokemon adv1,Pokemon adv2){
            int b = (int)(Math.random()*(50)+1); 
            if(b == 50){
             adv1.etat == "som";
             adv2.etat == "som";
            }

        }
    }
}