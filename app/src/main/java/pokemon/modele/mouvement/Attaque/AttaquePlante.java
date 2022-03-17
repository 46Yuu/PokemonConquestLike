public class AttaquePlante extends Attaque{
    public void Attak(Pokemon p){
        if(p.type==Eau){
                p.Pdv=p.Pdv - this.Atk*2;
         }if(p.type==Roche){
            p.Pdv=p.Pdv - this.Atk*2;
        } if(p.type==Feu){
            p.Pdv=p.Pdv - this.Atk/2;
        } if(p.type==Plante){
            p.Pdv=p.Pdv - this.Atk/2;
        } if(p.type==Vol){
            p.Pdv=p.Pdv - this.Atk/2;
        }
    }
}
