package pokemon.modele.pokemon;

public class Riolu extends Pokemon {
    public Riolu(int p, int a, String t) {
        super("Riolu",3,p, a, t, "src/main/resources/riolu.png");
        this.addAttaqueListe("Vive-Attaque", "Normal");
        this.addAttaqueListe("Forte-Paume", "Combat");
    }
}
