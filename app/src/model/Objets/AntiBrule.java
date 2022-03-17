public class AntiBrule extends Objets{
    public AntiBrule(){
        this.nom="Anti Gel";
    }

    public void Utiliser(Pokemon p){
        if(p.etat == "brul"){
            p.etat ="";
        }
   }

} 
