package pokemon.modele.pokemon;

public class Pikachu extends Pokemon {
    public Pikachu(int p, int a, String t) {
        super("Pikachu",3,p, a, t, "src/main/resources/pikachu.png");
        this.addAttaqueListe("Eclair", "Electrique");
        this.addAttaqueListe("Vive-Attaque", "Normal");
        this.addAttaqueListe("Double Pied", "Combat");
    }
}
