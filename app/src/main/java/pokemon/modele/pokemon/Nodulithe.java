package pokemon.modele.pokemon;

public class Nodulithe extends Pokemon {
    public Nodulithe(int p, int a, String t) {
        super("Nodulithe",3,p, a, t, "src/main/resources/nodulithe.png");
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Lame de Roc", "Roche");
        this.addAttaqueListe("Coud'Boue", "Sol");
    }
}
