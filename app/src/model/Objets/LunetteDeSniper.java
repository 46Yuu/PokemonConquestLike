public class LunetteDeSniper extends Objets{
    public LunetteDeSniper(){
        this.nom="Lunette de sniper";
    }

    public void Utiliser(Pokemon p){
        int x = p.getCrit();
       p.setCrit(50);
        }
   
}


