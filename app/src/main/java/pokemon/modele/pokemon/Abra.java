package pokemon.modele.pokemon;

public class Abra extends Pokemon {
    public Abra(int p, int a, String t) {
        super("Abra",2,p, a, t, "src/main/resources/abra.png");
        this.addAttaqueListe("Ball'Ombre", "Spectre");
        this.addAttaqueListe("Bélier", "Normal");
        this.addAttaqueListe("Choc Psy", "Psy");
    }
}
