package pokemon.modele.terrain;

import java.util.HashMap;

import pokemon.modele.jeux.Jeux;
import pokemon.modele.terrain.Case.TypeCase;

public class Terrain{

	private TypeCase[][] typeCase = {
		{TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock},
		{TypeCase.Rock, TypeCase.Grass , TypeCase.Grass,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock},
		{TypeCase.Roof, TypeCase.Roof , TypeCase.Grass,TypeCase.Grass, TypeCase.Lava , TypeCase.Lava},
		{TypeCase.Roof, TypeCase.Water , TypeCase.Grass,TypeCase.Grass, TypeCase.Lava , TypeCase.Lava},
		{TypeCase.Roof, TypeCase.Water , TypeCase.Water,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock},
		{TypeCase.Roof, TypeCase.Water , TypeCase.Water,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock},
	};

	public Case [][] tab;
	private Jeux jeux;
	
	public Terrain(int x, int y, Jeux jeux) {
		this.jeux=jeux;
		tab=new Case[x][y];
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++){
				tab[i][j]=new Case(i,j,null, typeCase[i][j]);
			}
		}
		jeux.poserPokemons(tab);
	}
}
