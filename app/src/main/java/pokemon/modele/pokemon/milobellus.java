package pokemon.modele.pokemon;

public class milobellus extends Pokemon{
    public milobellus() {
        super("Milobellus",3,"Eau");
        int randPDV = (int)(Math.random()*(202-155))+155; 
        int randATK = (int)(Math.random()*(28-17))+17; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/milobellus_shiny.png", "src/main/resources/milobellus.png");
        this.addAttaqueListe("Ouragan", "Dragon");
        this.addAttaqueListe("Voix Enjoleuse", "Fee");
        this.addAttaqueListe("Vibraqua", "Eau");
    }

}
