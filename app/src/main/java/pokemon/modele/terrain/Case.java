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

	private TypeCase typeCase;
	private Pokemon pokemon; //null s'il n'y a pas de pokemons sur la case 
	private int x;
	private int y;
	/**
	 * le chemin de l'image du tile correspondant à la case 
	 */
	private String pathImage;
	/**
	 * le chemin de l'image de sellection du tile correspondant à la case 
	 */
	private String pathImageSelect;

	public Case(int i, int j, Pokemon p, TypeCase type){
		typeCase=type;
		x=i;
		y=j;
		pokemon=p;
		
		switch(typeCase){
			case Grass:
				pathImage="src/main/resources/grass_texture.png";
				pathImageSelect="src/main/resources/grass_texture_select.png";
				break;
			case Rock:
				pathImage="src/main/resources/rock_texture.png";
				pathImageSelect="src/main/resources/rock_texture_select.png";
				break;
			case Lava:
				pathImage="src/main/resources/lava_texture.png";
				pathImageSelect="src/main/resources/lava_texture_select.png";
				break;
			case Water:
				pathImage="src/main/resources/water_texture.png";
				pathImageSelect="src/main/resources/water_texture_select.png";
				break;
			case Roof:
				pathImage="src/main/resources/roof_texture.png";
				pathImageSelect="src/main/resources/roof_texture_select.png";
				break;
		}
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
		return typeCase;
	}

	public String getPathImage(){
		return pathImage;
	}
	public String getPathImageSelect(){
		return pathImageSelect;
	}
}
