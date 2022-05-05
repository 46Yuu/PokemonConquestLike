package pokemon.modele.pokemon;

import pokemon.modele.attaque.*;
import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.attaque.ListeAttaques.eclair;
import pokemon.modele.attaque.ListeAttaques.flammeche;
import pokemon.modele.mouvement.Mouvement;
import pokemon.modele.terrain.Case.TypeCase;

import java.util.*;

public class Pokemon implements Mouvement{
    
	String nom;
	private int crit;
	private int pdv;
	private int atk;
	private String type;
	private String cheminImage;
	private String effet=null;
	Map<String,Attaque> listeAttaques = new TreeMap<String,Attaque>();
	/**
	 * le nombre de cases maximal qu'on peut déplacer le pokémon
	 */
	private int capaciteDeplacement;
	

	public Pokemon(String nom,int capaciteDeplacement, int pdv,int atk, String type, String chemin) {
		this.nom = nom;
		this.pdv = pdv;
		this.crit = 15;
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

	public int getCrit(){
		return this.crit;
	}

	public void setEffet(String effet){
		this.effet=effet;
	}

	public void removeEffet(){
		this.effet=null;
	}

	public String getEffet(){
		return this.effet;
	}
	
	public void testEffet(){
		if(this.effet=="Brule"){
			this.setPdv(pdv-1);
		}
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
		else if (type  == "Poison"){
			this.type = type;
		}
		else if (type  == "Combat"){
			this.type = type;
		}
		else if (type  == "Psy"){
			this.type = type;
		}
		else if (type  == "Tenebres"){
			this.type = type;
		}
		else if (type  == "Insecte"){
			this.type = type;
		}
		else if (type  == "Dragon"){
			this.type = type;
		}
		else if (type  == "Roche"){
			this.type = type;
		}else if (type  == "Glace"){
			this.type = type;
		}
	}

	public Map<String,Attaque> getListeAttaque(){
		return this.listeAttaques;
	}
	
	public void addAttaqueListe(String nom,String type){
		if(nom == "Flammeche"){
			this.listeAttaques.put(nom, new flammeche());
		}
		else if (nom == "Eclair"){
			this.listeAttaques.put(nom, new eclair());
		}
		else if (type == "Eau"){
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
		else if (type == "Psy"){
			this.listeAttaques.put(nom, new AttaquePsy());
		}
		else if (type == "Tenebres"){
			this.listeAttaques.put(nom, new AttaqueTenebres());
		}
		else if (type == "Insecte"){
			this.listeAttaques.put(nom, new AttaqueInsecte());
		}
		else if (type == "Dragon"){
			this.listeAttaques.put(nom, new AttaqueDragon());
		}
		else if (type == "Roche"){
			this.listeAttaques.put(nom, new AttaqueRoche());
		}
		else if (type == "Glace"){
			this.listeAttaques.put(nom, new AttaqueGlace());
		}
		else if (type == "Poison"){
			this.listeAttaques.put(nom, new AttaquePoison());
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

	public boolean peutAllerA(TypeCase typeCase){
		if(typeCase==TypeCase.Water){
			if(type!="Eau" && type!="Glace")
				return false;
		}
		if(typeCase==TypeCase.Lava){
            if(type!="Eau" && type!="Vol" && type!="Feu")
                return false;
        } 
		return true;
	}
}