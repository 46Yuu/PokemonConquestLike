public class Antidote extends Objets{
    public Antidote(){
        this.nom="Antidote";
    }

    public void Utiliser(Pokemon p){
         if(p.etat == "pois"){
             p.etat ="";
         }
    }
}


