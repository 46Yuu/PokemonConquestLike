public class AttaqueEau extends Attaque {
    public void Attak(Pokemon p){
    if(p.type==Eau && p.spe == AbsorbEau){
        p.Pdv=p.Pdv + 10;
    }else if(p.type==Eau){
        p.Pdv=p.Pdv - this.Atk/2;
    }if(p.type==Feu){
            p.Pdv=p.Pdv - this.Atk*2;
       
        }if(p.type==Plante){
            p.Pdv=p.Pdv - this.Atk/2;
        }
    }
}
