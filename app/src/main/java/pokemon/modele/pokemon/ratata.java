package pokemon.modele.pokemon;

public class ratata extends Pokemon{
    public ratata() {
        super("Ratata",3,"Normal", "src/main/resources/ratata.png");
        int randPDV = (int)(Math.random()*(137-90))+90; 
        int randATK = (int)(Math.random()*(14-5))+5; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Vive-Attaque", "Normal");
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Morsure", "Tenebres");
    }

}
