package pokemon.modele.pokemon;

public class Bulbizarre extends Pokemon {
    public Bulbizarre(int p, int a, String t) {
        super("Bulbizarre",3,p, a, t, "src/main/resources/bulbizarre.png");
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Fouet Lianes", "Plante");
        this.addAttaqueListe("Tranch'Herbe", "Plante");
    }
}
