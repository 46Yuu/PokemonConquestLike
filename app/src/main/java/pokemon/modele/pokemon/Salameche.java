package pokemon.modele.pokemon;

public class Salameche extends Pokemon {
    public Salameche(int p, int a, String t) {
        super("Salameche",3,p, a, t, "src/main/resources/salameche.png");
        this.addAttaqueListe("Griffe", "Normal");
        this.addAttaqueListe("Flammèche", "Feu");
        this.addAttaqueListe("Crocs Feu", "Feu");
    }
}
