package pokemon.modele.pokemon;

public class Abo extends Pokemon {
    public Abo() {
        super("Abo",2,"Poison", "src/main/resources/abo.png");
        int randPDV = (int)(Math.random()*(142-95))+95; 
        int randATK = (int)(Math.random()*(17-7))+7; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Morsure", "Tenebres");
        this.addAttaqueListe("Dard-Venin", "Poison");
        this.addAttaqueListe("Acide", "Poison");
    }
}
