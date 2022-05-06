package pokemon.modele.pokemon;

public class Minidraco extends Pokemon {
    public Minidraco() {
        super("Minidraco",3,"Dragon", "src/main/resources/minidraco.png");
        int randPDV = (int)(Math.random()*(148-101))+101; 
        int randATK = (int)(Math.random()*(25-18))+18; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Ouragan", "Dragon");
        this.addAttaqueListe("Draco-Charge", "Dragon");
        this.addAttaqueListe("Souplesse", "Normal");
    }
}
