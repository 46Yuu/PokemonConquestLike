
public class AuraDeRegeneration extends CapacitSpe{

    public AuraDeRegeneration(){
        this.nom = "AuraDeRegeneration";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
          
         }
         public void Utiliser(Pokemon p1,Pokemon p2,Pokemon adv1,Pokemon adv2){
            
            if(p1.getPdv() != p1.getPdvdeBase()){
             p1.setPdv(p1.getPdv()+10);
             if(p1.getPdv() > p1.PdvdeBase() ){
                p1.setPdv(p1.getPdvdeBase());
             }
            }

        }
    }
}