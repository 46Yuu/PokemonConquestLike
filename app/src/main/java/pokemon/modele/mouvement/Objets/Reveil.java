public class Reveil extends Objets {
    public Reveil(){
        this.nom="Reveil";
    }

    public void Utiliser(Pokemon p){
        if(p.etat == "endormis"){
            p.etat ="";
        }
    }
}
