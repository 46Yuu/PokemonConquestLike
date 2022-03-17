public class MaxPotion extends Objets{
        public MaxPotion(){
            this.nom="Max Potion";
        }
    
        public void Utiliser(Pokemon p){
            p.Pdv=p.PdvdeBase;
        }
    }
    

