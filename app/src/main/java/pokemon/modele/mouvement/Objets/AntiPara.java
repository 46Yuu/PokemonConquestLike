public class AntiPara extends Objets{
    public AntiPara(){
        this.nom="Anti Para";
    }

    public void Utiliser(Pokemon p){
        if(p.etat == "para"){
            p.etat ="";
        }
   }
}

