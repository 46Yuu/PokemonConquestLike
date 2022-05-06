package pokemon.modele.pokemon;

public class ronflex extends Pokemon{
    public ronflex() {
        super("Ronflex",2,"Normal");
        int randPDV = (int)(Math.random()*(217-170))+170; 
        int randATK = (int)(Math.random()*(31-17))+17; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        randShiny("src/main/resources/ronflex_shiny.png", "src/main/resources/ronflex.png");
        this.addAttaqueListe("Lechouille", "Spectre");
        this.addAttaqueListe("Charge", "Normal");
        this.addAttaqueListe("Morsure", "Tenebres");
    }

}
