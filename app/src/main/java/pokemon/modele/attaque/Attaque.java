package pokemon.modele.attaque;

import javax.swing.plaf.ColorUIResource;

import pokemon.audio.Audio;
import pokemon.modele.pokemon.Pokemon;


public abstract class Attaque {
    public void Attack(Pokemon p,Pokemon b){
        b.setPdv(b.getPdv() - p.getAtk()) ;
    }

    public int getDistanceMaxAttaque(){
        return 1;
    }

    public void crit(){
        try{
            Audio audioPlayer =new Audio("src/main/resources/IMHIT.wav",5f,false);
            audioPlayer.play();
        } 
        catch (Exception ex){
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void supEff(){
        try{
            Audio audioPlayer =new Audio("src/main/resources/IMHITSUPER.wav",5f,false);
            audioPlayer.play();
        } 
        catch (Exception ex){
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void pasEff(){
        try{
            Audio audioPlayer =new Audio("src/main/resources/IMHITWEAK.wav",5f,false);
            audioPlayer.play();
            
        } 
        catch (Exception ex){
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public abstract String getType();
    public abstract ColorUIResource getColorLabelType();

    public String getInfos(){
        return "L'ennemi est attaqué par une faible flamme. Peut aussi le brûler. \n(10%. Brulure = -1pv après chaque action.)";
    }

    /**
     * renvoie true si l'ataque ne peut pas être bloqué par un pokémon
     * @return true si l'ataque ne peut pas être bloqué par un pokémon
     */
    public boolean passeObstacle(){
        return false;
    }
}
