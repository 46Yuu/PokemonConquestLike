public class Antidote extends Objets{
    public Antidote(){
        this.nom="Max Potion";
    }

    public void Utiliser(Pokemon p){
         if(p.etat == "poisoned"){
             p.etat ="";
         }
    }
}


