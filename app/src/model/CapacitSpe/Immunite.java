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
}