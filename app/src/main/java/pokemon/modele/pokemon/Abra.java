package pokemon.modele.pokemon;

public class Abra extends Pokemon {
    public Abra() {
        super("Abra",2,"Psy", "src/main/resources/abra.png");
        int randPDV = (int)(Math.random()*(132-85))+85; 
        int randATK = (int)(Math.random()*(14-6))+6; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Ball'Ombre", "Spectre");
        this.addAttaqueListe("Belier", "Normal");
        this.addAttaqueListe("Choc Psy", "Psy");
    }
}
