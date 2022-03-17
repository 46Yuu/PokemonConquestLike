package pokemon.modele.attaque;

import pokemon.modele.pokemon.Pokemon;

public abstract class Attaque {
    public void Attack(Pokemon p,Pokemon b){
        b.setPdv(b.getPdv() - p.getAtk()) ;
    }
}
