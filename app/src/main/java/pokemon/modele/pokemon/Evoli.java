package pokemon.modele.pokemon;

public class Evoli extends Pokemon{


    public Evoli(int p, int a, String t) {
        super("Evoli",4,p, a, t, "src/main/resources/evoli.png");
        this.addAttaqueListe("Vive-Attaque", "Normal");
        this.addAttaqueListe("Double Pied", "Combat");
        this.addAttaqueListe("Meteores", "Normal");
    }

}
