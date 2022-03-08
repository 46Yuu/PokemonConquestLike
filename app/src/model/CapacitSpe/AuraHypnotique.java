public class AuraHypnotique extends CapacitSpe{

    public AuraHypnotique(){
        this.nom = "AuraHypnotique";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
    }
}