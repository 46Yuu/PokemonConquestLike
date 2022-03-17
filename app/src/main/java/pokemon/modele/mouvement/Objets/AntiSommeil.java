public class AntiSommeil extends Objets{
    public AntiSommeil(){
        this.nom="Anti Sommeil";
    }

    public void Utiliser(Pokemon p){
        if(p.etat == "som"){
            p.etat ="";
        }
   }
}

