public class AntiGel extends Objets{
    public AntiGel(){
        this.nom="Anti Gel";
    }

    public void Utiliser(Pokemon p){
        if(p.etat == "gel"){
            p.etat ="";
        }
   }

}