package pokemon.modele;

public class Pokemon {

	private int Pdv;
	private int Atk;
	private String type;
	String etat;
	
	public Pokemon(int p,int a, String t) {
		this.setPdv(p);
		this.setAtk(a);
		this.setType(t);
		this.etat = "vivant";
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
}
