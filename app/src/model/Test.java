public class Test {
    public void main(String [] args){
        Pokemon ratatak = new Pokemon("ratatak",20,20,"normal");
        Pokemon roucoups = new Pokemon("roucoups",20,20,"normal");
        var hashpokemon= new HAshMap< Case, Pokemon>();
        hashpokemon.put(Case[0][0], ratatak);
        hashpokemon.put(Case[0][1], roucoups);
    }
}
