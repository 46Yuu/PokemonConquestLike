package pokemon.modele.pokemon;

public class Absol extends Pokemon {
    public Absol() {
        super("Absol",3,"Tenebres", "src/main/resources/absol.png");
        int randPDV = (int)(Math.random()*(172-125))+125; 
        int randATK = (int)(Math.random()*(29-19))+19; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Vive-Attaque", "Normal");
        this.addAttaqueListe("Morsure", "Tenebres");
    }
}
