package pokemon.modele.terrain;

import java.util.HashMap;

import pokemon.modele.jeux.Jeux;

public class Terrain{

	
	public Case [][] tab;
	private Jeux jeux;
	
	public Terrain(int x, int y, Jeux jeux) {
		this.jeux=jeux;
		tab=new Case[x][y];
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++){
				tab[i][j]=new Case(i,j,null);
			}
		}
		jeux.poserPokemons(tab);
	}
}
