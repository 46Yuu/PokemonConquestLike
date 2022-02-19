public class AttaqueElectric extends Attaque {
    public void Attak(Pokemon p){
        if(p.type==Vol){
            p.Pdv=p.Pdv - this.Atk*2;
         }if(p.type==Eau){
            p.Pdv=p.Pdv - this.Atk*2;
         }if(p.type==Plante){
                p.Pdv=p.Pdv - this.Atk/2;
        }if(p.type==Electrique){
                p.Pdv=p.Pdv - this.Atk/2;

        }
    }
}
