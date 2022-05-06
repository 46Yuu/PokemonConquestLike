package pokemon.modele.pokemon;

public class Nodulithe extends Pokemon {
    public Nodulithe() {
        super("Nodulithe",3,"Roche", "src/main/resources/nodulithe.png");
        int randPDV = (int)(Math.random()*(162-115))+115; 
        int randATK = (int)(Math.random()*(25-19))+19; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Lame de Roc", "Roche");
        this.addAttaqueListe("Coud'Boue", "Sol");
    }
}
