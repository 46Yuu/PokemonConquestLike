package pokemon.modele;

import java.util.HashMap;

public class Terrain{

	
	public Case [][] tab;
	public HashMap<Case, Pokemon> list=new HashMap<>();
	private Jeux jeux;
	
	public Terrain(int x, int y, Jeux jeux) {
		this.jeux=jeux;
		
		tab=new Case[x][y];
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++){
				tab[i][j]=new Case(i,j);
				list.put(tab[i][j], null);
			}
		}
		jeux.poserPokemons(tab,list);
	}
}
