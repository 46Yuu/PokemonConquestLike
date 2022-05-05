package pokemon.modele.pokemon;

public class Minidraco extends Pokemon {
    public Minidraco(int p, int a, String t) {
        super("Minidraco",3,p, a, t, "src/main/resources/minidraco.png");
        this.addAttaqueListe("Ouragan", "Dragon");
        this.addAttaqueListe("Draco-Charge", "Dragon");
        this.addAttaqueListe("Souplesse", "Normal");
    }
}
