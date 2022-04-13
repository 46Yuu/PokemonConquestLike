package pokemon.modele.pokemon;

public class Chenipan extends Pokemon {
    public Chenipan(int p, int a, String t) {
        super("Chenipan",3,p, a, t, "src/main/resources/chenipan.png");
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Piqure", "Insecte");
    }
}
