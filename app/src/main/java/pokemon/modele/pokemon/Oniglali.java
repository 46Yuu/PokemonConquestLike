package pokemon.modele.pokemon;

public class Oniglali extends Pokemon {
    public Oniglali(int p, int a, String t) {
        super("Oniglali",3,p, a, t, "src/main/resources/oniglali.png");
        this.addAttaqueListe("Eclats Glace", "Glace");
        this.addAttaqueListe("Etonnement", "Spectre");
        this.addAttaqueListe("Poudreuse", "Glace");
    }
}
