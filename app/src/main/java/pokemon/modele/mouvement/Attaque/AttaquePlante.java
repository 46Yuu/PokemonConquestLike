public class AttaquePlante extends Attaque{
    public void Attak(Pokemon p){
   
            int b = (int)(Math.random()*(50-p.getCrit())+1); 
            coup = 0;
            if(b == 50 ){
                coup = this.getAtk()*2;
                 }else{
                      coup =this.getAtk();
                 }
                 degats = p.getDef() - coup;
           if(p.geType()==Feu || p.geType()==Plante || p.getType() == Vol){
                if(degats < 0){
                p.setPdv(p.getPdv() + degats/2);
                }
            }
            else if(p.geType()==Eau || p.getType()== Roche){
                if(degats < 0){
                    p.setPdv(p.getPdv() + degats*2);
                    }
                }else{
                    if(degats < 0){
                        p.setPdv(p.getPdv() + degats); 
                }
                   
            }
        }
        }
        
 
