import java.util.HashMap;

public class Pokemon implements Mouvement,Attaque {
    
	String nom;
	private int Pdv;
	private int Atk;
	private String type;
	boolean vivant;
	private int lvl;
	//Case Case;

	public Pokemon(int p,int a, String t) {
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

	public String getType() {
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

}
