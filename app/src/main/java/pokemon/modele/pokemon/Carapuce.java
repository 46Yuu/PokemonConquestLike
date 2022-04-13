package pokemon.modele.pokemon;

public class Carapuce extends Pokemon {
    public Carapuce(int p, int a, String t) {
        super("Carapuce",3,p, a, t, "src/main/resources/carapuce.png");
        this.addAttaqueListe("Pistolet à O", "Eau");
        this.addAttaqueListe("Morsure", "Tenebres");
        this.addAttaqueListe("Vibraqua", "Eau");
    }
}
