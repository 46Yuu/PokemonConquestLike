package pokemon.modele.pokemon;

public class Oniglali extends Pokemon {
    public Oniglali() {
        super("Oniglali",3,"Glace", "src/main/resources/oniglali.png");
        int randPDV = (int)(Math.random()*(187-140))+140; 
        int randATK = (int)(Math.random()*(30-19))+19; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Eclats Glace", "Glace");
        this.addAttaqueListe("Etonnement", "Spectre");
        this.addAttaqueListe("Poudreuse", "Glace");
    }
}
