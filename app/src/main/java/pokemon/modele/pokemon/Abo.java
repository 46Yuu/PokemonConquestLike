package pokemon.modele.pokemon;

public class Abo extends Pokemon {
    public Abo(int p, int a, String t) {
        super("Abo",2,p, a, t, "src/main/resources/abo.png");
        this.addAttaqueListe("Morsure", "Tenebres");
        this.addAttaqueListe("Dard-Venin", "Poison");
        this.addAttaqueListe("Acide", "Poison");
    }
}
