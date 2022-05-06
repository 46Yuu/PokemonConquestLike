package pokemon.modele.pokemon;

public class Evoli extends Pokemon{
    public Evoli() {
        super("Evoli",4,"Normal", "src/main/resources/evoli.png");
        int randPDV = (int)(Math.random()*(162-115))+115; 
        int randATK = (int)(Math.random()*(23-16))+16; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Vive-Attaque", "Normal");
        this.addAttaqueListe("Double Pied", "Combat");
        this.addAttaqueListe("Meteores", "Normal");
    }

}
