package pokemon.modele.pokemon;

public class Smogo extends Pokemon {
    public Smogo(int p, int a, String t) {
        super("Smogo",3,p, a, t, "src/main/resources/smogo.png");
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Puredpois", "Poison");
    }
}
