public class AttaqueNormal extends Attaque {
    public void Attak(Pokemon p){
        if(p.type==Roche){
            p.Pdv=p.Pdv - this.Atk/2;
    }
    
}
