public class Immunite extends CapacitSpe{

    public Immunite(){
        this.nom = "Immunite";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
         if (p.etat == "pois"){
             p.etat =="";
         }
    }
    public void Utiliser(Pokemon p1,Pokemon p2,Pokemon adv1,Pokemon adv2){
        if (p1.etat == "pois"){
            p1.etat =="";
        }
    }
}