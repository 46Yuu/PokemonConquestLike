package pokemon.modele;

public class Pokemon implements Mouvement{
    
	String nom;
	private int pdv;
	private int atk;
	private String type;
	private int lvl;
	private String cheminImage;
	private Attaque attaque;
	

	public Pokemon(String nom, int pdv,int atk, String type, String chemin) {
		this.nom = nom;
		this.pdv = pdv;
		this.setAtk(atk);
		this.setType(type);
		this.setAttaque(type);
		cheminImage=chemin;
	}

	public String getNom(){
		return this.nom;
	}
	
    public String getCheminImage(){
        return cheminImage;
    }


	public int getPdv() {
		return this.pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	public int getAtk() {
		return this.atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		if (type == "Eau"){
			this.type = type;
		}
		else if (type == "Electrique"){
			this.type = type;
		}
		else if (type == "Feu"){
			this.type = type;
		}
		else if (type == "Normal"){
			this.type = type;
		}
		else if (type == "Plante"){
			this.type = type;
		}
		else if (type  == "Vol"){
			this.type = type;
		}
	}

	public void setAttaque(String typeAtk){
		if (typeAtk == "Eau"){
			this.attaque = new AttaqueEau();
		}
		else if (typeAtk == "Electrique"){
			this.attaque = new AttaqueElectrique();
		}
		else if (typeAtk == "Feu"){
			this.attaque = new AttaqueFeu();
		}
		else if (typeAtk == "Normal"){
			this.attaque = new AttaqueNormal();
		}
		else if (typeAtk == "Plante"){
			this.attaque = new AttaquePlante();
		}
		else if (typeAtk == "Vol"){
			this.attaque = new AttaqueVol();
		}
	}

	public void Attack(Pokemon p){
		this.attaque.Attack(this,p);
		if(p.getPdv()<=0){
            System.out.println(p.getNom() + " est KO !");
        }
	}

	@Override
	public void Deplacement() {
		// TODO Auto-generated method stub
		
	}

}
