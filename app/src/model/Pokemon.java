import java.util.HashMap;

public class Pokemon{
    
	String nom;
	private int Pdv;
	private int Atk;
	private TypeTerrain type;
	boolean vivant;
	private int lvl;
	//Case Case;

	public Pokemon(int p,int a, TypeTerrain t) {
		this.setPdv(p);
		this.setAtk(a);
		this.setType(t);
		this.vivant = true;
		//this.Case = c;
	}

	public int getPdv() {
		return Pdv;
	}

	public void setPdv(int pdv) {
		Pdv = pdv;
	}

	public int getAtk() {
		return Atk;
	}

	public void setAtk(int atk) {
		Atk = atk;
	}

	public TypeTerrain getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean estVivant(){
		if(this.Pdv<=0){
			this.vivant = fale;
		}
		return this.vivant;
	}
	public void Deplacement (int x,int y){
		if(Case[x][y].type == Normal || Case[x][y].type == this.type)
		hashpokemon.replace( this, Case[x][y]);
		
          
		}

		public boolean PeutSeDeplacer(Pokemon p, Plateau p1){
			int [][]tab = new int[4][4];
			for(int i=0;i<tab.length;i++){
				for(int j=0;j<tab[i].length;i++){

				}
			}
		}

		public void Attak(Pokemon p){
			p.Pdv = p.Pdv - this.Atk;
		}
	}


