package pokemon.modele.pokemon;

public class voltorbe extends Pokemon {
    public voltorbe() {
        super("Voltorbe",3,"Electrique", "src/main/resources/voltorbe.png");
        int randPDV = (int)(Math.random()*(147-100))+100; 
        int randATK = (int)(Math.random()*(14-6))+6; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Eclair", "Electrique");
    }
}
