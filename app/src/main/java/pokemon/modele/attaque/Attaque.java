package pokemon.modele.attaque;

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
}
