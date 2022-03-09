package pokemon.modele.pokemon;

import pokemon.modele.attaque.*;
import pokemon.modele.mouvement.Mouvement;
import java.util.*;

public class Pokemon implements Mouvement{
    
	String nom;
	private int pdv;
	private int atk;
	private String type;
	private String cheminImage;
	Map<String,Attaque> listeAttaques = new TreeMap<String,Attaque>();
	/**
	 * le nombre de cases maximal qu'on peut déplacer le pokémon
	 */
	private int capaciteDeplacement;
	

	public Pokemon(String nom,int capaciteDeplacement, int pdv,int atk, String type, String chemin) {
		this.nom = nom;
		this.pdv = pdv;
		this.setAtk(atk);
		this.setType(type);
		cheminImage=chemin;
		this.capaciteDeplacement=capaciteDeplacement;
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
		else if (type  == "Combat"){
			this.type = type;
		}
	}

	public void addAttaqueListe(String nom,String type){
		if (type == "Eau"){
			this.listeAttaques.put(nom, new AttaqueEau());
		}
		else if (type == "Electrique"){
			this.listeAttaques.put(nom, new AttaqueElectrique());
		}
		else if (type == "Feu"){
			this.listeAttaques.put(nom, new AttaqueFeu());
		}
		else if (type == "Normal"){
			this.listeAttaques.put(nom, new AttaqueNormal());
		}
		else if (type == "Plante"){
			this.listeAttaques.put(nom, new AttaquePlante());
		}
		else if (type == "Vol"){
			this.listeAttaques.put(nom, new AttaqueVol());
		}
		else if (type == "Combat"){
			this.listeAttaques.put(nom, new AttaqueCombat());
		}
	}

	public int getCapaciteDeplacement(){
		return capaciteDeplacement;
	}
	public void setCapaciteDeplacement(int cap){
		this.capaciteDeplacement=cap;
	}


	public void Attack(Pokemon p, String nomAttack){
		if(listeAttaques.containsKey(nomAttack)){
			Attaque tmp = listeAttaques.get(nomAttack);
			tmp.Attack(this,p);
		}
		else {
			System.out.println("Ce pokemon ne connait pas cette attaque.");
		}
		if(p.getPdv()<=0){
            System.out.println(p.getNom() + " est KO !");
        }
	}

	@Override
	public void Deplacement() {
		// TODO Auto-generated method stub
		
	}
}