import java.lang.Math;   

public abstract class Attaque {
    int degats;

    public void Attak(Pokemon p ){
        int b = (int)(Math.random()*(50-p.Crit)+1); 
        if(b == 50 ){
      degats =  p.getDef - this.getAtk*2;
       }else{
            degats =  p.getDef - this.getAtk;
       }
            if(degats < 0){
                p.setPdv (p.getPdv + degats);
          

        }
    }
}

