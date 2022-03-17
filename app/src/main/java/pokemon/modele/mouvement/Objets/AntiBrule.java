public class AntiBrule extends Objets{
    public AntiBrule(){
        this.nom="Anti Brule";
    }

    public void Utiliser(Pokemon p){
        if(p.etat == "brule"){
            p.etat ="";
        }
   }
}
