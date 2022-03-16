public class Orgeuil extends CapacitSpe{

    public Orgeuil(){
        this.nom = "Orgeuil";
    }
    public void Apprendre(Pokemon p){
          p.spe = this;
    }
    public void Utiliser(Pokemon p1,Pokemon p2,Pokemon adv1,Pokemon adv2){
     if(p1.etat != ""){
         p1.setAtk(p1.getAtk() + 2);
         p1.setDef(p1.getDef() + 2);

     }
    }

}