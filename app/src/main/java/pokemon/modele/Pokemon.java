package pokemon.modele;

public class Pokemon implements Mouvement,Attaque {
    
	String nom;
	private int Pdv;
	private int Atk;
	private String type;
	private int lvl;
	private String cheminImage;
	

	public Pokemon(int p,int a, String t, String chemin) {
		this.setPdv(p);
		this.setAtk(a);
		this.setType(t);
		cheminImage=chemin;
	}

    public String getCheminImage(){
        return cheminImage;
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

	@Override
	public void Attak() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deplacement() {
		// TODO Auto-generated method stub
		
	}

}
