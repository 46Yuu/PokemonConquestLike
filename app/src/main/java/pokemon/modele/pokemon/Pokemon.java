package pokemon.modele.pokemon;

import pokemon.modele.attaque.*;
import pokemon.modele.attaque.Attaquetypes.*;
import pokemon.modele.attaque.ListeAttaques.*;
import pokemon.modele.terrain.Case.TypeCase;

import java.util.*;

public class Pokemon {
    
	String nom;
	private int crit;
	private int pdv;
	private int atk;
	private String type;
	private String cheminImage;
	private String effet=null;
	private boolean confus = false;
	private int confusTour = 2;
	private boolean peur = false;
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
		if(this.effet=="Poison"){
			this.setPdv(pdv-1);
		}
	}

	public void setCrit(int n){
		this.crit = n;
	}

	public boolean getConfus(){
		return this.confus;
	}

	public void setConfus(boolean confus){
		this.confus = confus;
	}

	public int getConfusTour(){
		return this.confusTour;
	}
	
	public void setConfusTour(int n){
		this.confusTour = n;
	}

	public boolean getPeur(){
		return this.peur;
	}

	public void setPeur(boolean peur){
		this.peur = peur;
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
		else if (nom == "Acide"){
			this.listeAttaques.put(nom, new acide());
		}
		else if (nom == "Ball'Ombre"){
			this.listeAttaques.put(nom, new ballOmbre());
		}
		else if (nom == "Belier"){
			this.listeAttaques.put(nom, new belier());
		}
		else if (nom == "Charge"){
			this.listeAttaques.put(nom, new charge());
		}
		else if (nom == "Choc Psy"){
			this.listeAttaques.put(nom, new chocPsy());
		}
		else if (nom == "Dard-Venin"){
			this.listeAttaques.put(nom, new dardVenin());
		}
		else if (nom == "Fouet Lianes"){
			this.listeAttaques.put(nom, new fouetLianes());
		}
		else if (nom == "Griffe"){
			this.listeAttaques.put(nom, new griffe());
		}
		else if (nom == "Morsure"){
			this.listeAttaques.put(nom, new morsure());
		}
		else if (nom == "Pistolet a O"){
			this.listeAttaques.put(nom, new pistoletAO());
		}
		else if (nom == "Tranch'Herbe"){
			this.listeAttaques.put(nom, new tranchHerbe());
		}
		else if (nom == "Vibraqua"){
			this.listeAttaques.put(nom, new vibraqua());
		}
		else if (nom == "Vive-Attaque"){
			this.listeAttaques.put(nom, new viveAttaque());
		}
		else if (nom == "Crocs Feu"){
			this.listeAttaques.put(nom, new crocsFeu());
		}
		else if (nom == "Coud'Boue"){
			this.listeAttaques.put(nom, new coudBoue());
		}
		else if (nom == "Double Pied"){
			this.listeAttaques.put(nom, new doublePied());
		}
		else if (nom == "Draco Charge"){
			this.listeAttaques.put(nom, new dracoCharge());
		}
		else if (nom == "Eclats Glace"){
			this.listeAttaques.put(nom, new eclatsGlace());
		}
		else if (nom == "Etonnement"){
			this.listeAttaques.put(nom, new etonnement());
		}
		else if (nom == "Lame de Roc"){
			this.listeAttaques.put(nom, new lameDeRoc());
		}
		else if (nom == "Meteores"){
			this.listeAttaques.put(nom, new meteores());
		}
		else if (nom == "Ouragan"){
			this.listeAttaques.put(nom, new ouragan());
		}
		else if (nom == "Piqure"){
			this.listeAttaques.put(nom, new piqure());
		}
		else if (nom == "Poudreuse"){
			this.listeAttaques.put(nom, new poudreuse());
		}
		else if (nom == "Souplesse"){
			this.listeAttaques.put(nom, new souplesse());
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


	public boolean peutAllerA(TypeCase typeCase){
		if(typeCase==TypeCase.Water){
			if(type!="Eau" && type!="Glace")
				return false;
		}
		if(typeCase==TypeCase.Lava){
            if(type!="Vol" && type!="Feu")
                return false;
        } 
		return true;
	}
}