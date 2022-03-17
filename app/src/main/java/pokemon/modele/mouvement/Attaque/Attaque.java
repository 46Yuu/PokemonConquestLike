import java.lang.Math;   

public abstract class Attaque {
    int coup;
    int degats;
    public void Attak(Pokemon p ){
        int b = (int)(Math.random()*(50-p.getCrit())+1); 
        if(b == 50 ){
      coup =  p.getDef() - this.getAtk()*2;
       }else{
            coup =  p.getDef() - this.getAtk();
       }
            if(coup < 0){
                p.setPdv(p.getPdv() + coup);
          

        }
    }
}

