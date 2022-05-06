package pokemon.modele.pokemon;

public class nidoranM extends Pokemon {
    public nidoranM() {
        super("NidoranM",3,"Poison", "src/main/resources/nidoranM.png");
        int randPDV = (int)(Math.random()*(153-106))+106; 
        int randATK = (int)(Math.random()*(17-8))+8; 
        this.setPdv(randPDV);
        this.setAtk(randATK);
        this.addAttaqueListe("Picpic", "Vol");
        this.addAttaqueListe("Dard-Venin", "Poison");
        this.addAttaqueListe("Double Pied", "Poison");
    }
}
