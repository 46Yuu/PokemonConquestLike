package pokemon.modele.pokemon;

public class Pikachu extends Pokemon {
    public Pikachu() {
        super("Pikachu",3, "Electrique", "src/main/resources/pikachu.png");
        int randPDV = (int)(Math.random()*(142-95))+95; 
        int randATK = (int)(Math.random()*(24-15))+15; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Eclair", "Electrique");
        this.addAttaqueListe("Vive-Attaque", "Normal");
        this.addAttaqueListe("Double Pied", "Combat");
    }
}
