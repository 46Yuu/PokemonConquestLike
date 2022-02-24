package pokemon.modele.terrain;

import pokemon.modele.pokemon.Pokemon;

public class Case {


	public enum TypeCase{
		Grass("Grass"),Rock("Rock"),Lava("Lava"),Water("Water"),Roof("Roof");
		private final String type;
		private TypeCase(String type){
			this.type = type;
		}
	}

	TypeCase type;
	Pokemon pokemon; //null s'il n'y a pas de pokemons sur la case 
	int x;
	int y;

	public Case(int i, int j, Pokemon p, TypeCase type){
		this.type=type;
		x=i;
		y=j;
		pokemon=p;
	}

	public int getPosI(){
		return x;
	}
	public int getPosJ(){
		return y;
	}

    public void setPokemon(Pokemon k) {
		pokemon=k;
    }

	public Pokemon getPokemon() {
		return pokemon;
	}

	public TypeCase getType(){
		return type;
	}
}
