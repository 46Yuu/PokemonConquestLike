import java.util.HashMap;

public class Pokemon{
    
	String nom;
	private int Def;
	private int Crit;
	private int PdvdeBase;
	private int Pdv;
	private int Atk;
	 String etat;
	private TypeTerrain type;
	boolean vivant;
	private int lvl;
	CapacitSpe spe;
	//Case Case;

	public Pokemon(int p,int a, int d,int c,int v,TypeTerrain t) {
		this.setPdv(p);
		this.setPdvdeBase(p);
		this.setAtk(a);
		this.setType(t);
		this.setDef(d);
		this.setCrit(c);
	

		this.vivant = true;
		this.etat ="";
		//this.Case = c;
	}

	public int getPdv() {
		return Pdv;
	}

	public void setPdv(int pdv) {
		Pdv = pdv;
	}
	public int getPdvdeBase() {
		return PdvdeBase;
	}

	public void setPdvdeBase(int pdv) {
		PdvdeBase = pdv;
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
	public TypeTerrain getDef() {
		return Def;
	}

	public void setDef(int d) {
		this.Def = d;
	}
	public TypeTerrain getCrit() {
		return Crit;
	}

	public void setCrit(int c) {
		this.Crit = c;
	}


	public boolean estVivant(){
		if(this.Pdv<=0){
			this.vivant = false;
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


