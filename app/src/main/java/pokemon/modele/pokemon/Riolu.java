package pokemon.modele.pokemon;

public class Riolu extends Pokemon {
    public Riolu() {
        super("Riolu",3,"Combat", "src/main/resources/riolu.png");
        int randPDV = (int)(Math.random()*(147-100))+100; 
        int randATK = (int)(Math.random()*(25-16))+16; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Vive-Attaque", "Normal");
        this.addAttaqueListe("Forte-Paume", "Combat");
    }
}
