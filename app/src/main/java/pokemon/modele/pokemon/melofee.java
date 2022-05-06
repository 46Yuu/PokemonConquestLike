package pokemon.modele.pokemon;

public class melofee extends Pokemon{
    public melofee() {
        super("Melofee",2,"Fee", "src/main/resources/melofee.png");
        int randPDV = (int)(Math.random()*(177-130))+130; 
        int randATK = (int)(Math.random()*(15-6))+6; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Voix Enjoleuse", "Fee");
        this.addAttaqueListe("Vent Feerique", "Fee");
    }

}
