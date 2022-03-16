public class RestaurationMax extends Objets {
    public RestaurationMax(){
        this.nom="RestaurationMax";
    }

    public void Utiliser(Pokemon p1,Pokemon p2){
        p1.setPdv(p1.getPdvdeBase);
        p2.setPdv(p1.getPdvdeBase);
    }
}
