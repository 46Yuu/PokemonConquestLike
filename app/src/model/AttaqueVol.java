public class AttaqueVol extends Attaque{
    public void Attak(Pokemon p){
        if(p.type==Plante){
            p.Pdv=p.Pdv - this.Atk*2;
         }if(p.type==Roche){
            p.Pdv=p.Pdv - this.Atk/2;
}
