public class Test {
    public void main(String [] args){
        Pokemon ratatak = new Pokemon("ratatak",20,20,Normal);
        Pokemon roucoups = new Pokemon("roucoups",20,20,Normal);
        var hashpokemon= new HAshMap< Pokemon, Case>();
        hashpokemon.put(ratatak, Case[0][0]);
        hashpokemon.put(roucoups,Case[0][1]);
        Case[][]casetab = new Case[4][4];
        Plateau p1= new Plateau(casetab );

       Case casefeu = new Case(Feu);
       Case casenormal = new Case(Noramal);
       Case caseeau = new Case(Eau);
        Case casemontagne = new Case(Montagne);
       Case  casefleuve = new Case(Fleuve);
        Case caseObstacle = new Case(Obstacle);
         casetab[0][0] = casefeu;
         casetab[0][1] = casefeu;
         casetab[0][2] = casefeu;
         casetab[0][3] = casefeu;
         casetab[1][0] = casefeu;
         casetab[1][1] = casefeu;
         casetab[1][2] = casefeu;
         casetab[1][3] = casefeu;
         casetab[2][0] = casefeu;
         casetab[2][1] = casefeu;
         casetab[2][2] = casefeu;
         casetab[2][3] = casefeu;
         casetab[3][0] = casefeu;
         casetab[3][1] = casefeu;
         casetab[3][2] = casefeu;
         casetab[3][3] = casefeu;
       


       
       



    }
}
