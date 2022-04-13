package pokemon.modele.pokemon;

public class Absol extends Pokemon {
    public Absol(int p, int a, String t) {
        super("Absol",3,p, a, t, "src/main/resources/absol.png");
        this.addAttaqueListe("Vive-Attaque", "Normal");
        this.addAttaqueListe("Morsure", "Tenebres");
    }
}
