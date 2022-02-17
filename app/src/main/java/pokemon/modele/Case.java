package pokemon.modele;

public class Case {

	TypeTerrain type;
	int x;
	int y;

	public Case(int i, int j){
		x=i;
		y=j;
	}

	public int getPosI(){
		return x;
	}
	public int getPosJ(){
		return y;
	}
}
