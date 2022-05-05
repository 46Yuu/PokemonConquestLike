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

    public void hit(){
        try{
            Audio audioPlayer =new Audio("src/main/resources/Hit.wav",5f,false);
            audioPlayer.play();
        } 
        catch (Exception ex){
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
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

    public abstract void attackBis(Pokemon p,Pokemon b);

    public void paralyse(Pokemon p, Pokemon b){
        if(p.getEffet()=="Paralyse"){
            int tmp = (int)(Math.random()*100)+1;
            if(tmp>=25){
                attackBis(p,b);
            } 
        }
        else {
            attackBis(p, b);
        }
    }

    public abstract String getInfo();
    public abstract String getType();
    public abstract ColorUIResource getColorLabelType();
}
