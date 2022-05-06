package pokemon.modele.pokemon;

public class Bulbizarre extends Pokemon {
    public Bulbizarre() {
        super("Bulbizarre",3,"Plante", "src/main/resources/bulbizarre.png");
        int randPDV = (int)(Math.random()*(152-105))+105; 
        int randATK = (int)(Math.random()*(23-15))+15; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Fouet Lianes", "Plante");
        this.addAttaqueListe("Tranch'Herbe", "Plante");
    }
}
