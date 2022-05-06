package pokemon.modele.pokemon;

public class Carapuce extends Pokemon {
    public Carapuce() {
        super("Carapuce",3,"Eau", "src/main/resources/carapuce.png");
        int randPDV = (int)(Math.random()*(151-104))+104; 
        int randATK = (int)(Math.random()*(24-13))+13; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Pistolet a O", "Eau");
        this.addAttaqueListe("Morsure", "Tenebres");
        this.addAttaqueListe("Vibraqua", "Eau");
    }
}
