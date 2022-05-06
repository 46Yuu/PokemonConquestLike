package pokemon.modele.pokemon;

public class nidoranF extends Pokemon {
    public nidoranF() {
        super("NidoranF",3,"Poison");
        int randPDV = (int)(Math.random()*(162-115))+115; 
        int randATK = (int)(Math.random()*(15-5))+5; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/nidoranF_shiny.png", "src/main/resources/nidoranF.png");
        this.addAttaqueListe("Griffe", "Normal");
        this.addAttaqueListe("Dard-Venin", "Poison");
        this.addAttaqueListe("Double Pied", "Poison");
    }
}
