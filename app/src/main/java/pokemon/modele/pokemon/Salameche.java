package pokemon.modele.pokemon;

public class Salameche extends Pokemon {
    public Salameche() {
        super("Salameche",3,"Feu", "src/main/resources/salameche.png");
        int randPDV = (int)(Math.random()*(146-99))+99; 
        int randATK = (int)(Math.random()*(22-14))+14; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Griffe", "Normal");
        this.addAttaqueListe("Flammeche", "Feu");
        this.addAttaqueListe("Crocs Feu", "Feu");
    }
}
