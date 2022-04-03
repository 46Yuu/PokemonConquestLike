package pokemon.vue;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pokemon.controleur.Controleur;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;
import java.awt.Color;

public class PanelJoueurs extends JPanel{

    private HashMap<Pokemon,StatsPokemon> statsPokemonsJ1=new HashMap<>();
	private HashMap<Pokemon,StatsPokemon> statsPokemonsJ2=new HashMap<>();
	private JLabel j1=new JLabel("Pokemons du Joueur 1:");
	private JLabel j2=new JLabel("Pokemons du Joueur 2:");

    public PanelJoueurs(Controleur controleur) {

        Map<Pokemon,Case> pokemonsJ1 = controleur.jeux.getPokemonCaseJoueur1();
		j1.setForeground(Color.WHITE);
		add(j1);
		for(Pokemon p: pokemonsJ1.keySet()){
			StatsPokemon tmp=new StatsPokemon(p.getNom(),p.getType(),p.getPdv(),p.getAtk());
			tmp.initialiserLargeurPdv();
			add(tmp);
			statsPokemonsJ1.put(p,tmp);
		}

		Map<Pokemon,Case> pokemonsJ2 = controleur.jeux.getPokemonCaseJoueur2();
		j2.setForeground(Color.WHITE);
	    add(j2);
		for(Pokemon p: pokemonsJ2.keySet()){
			StatsPokemon tmp=new StatsPokemon(p.getNom(),p.getType(),p.getPdv(),p.getAtk());
			tmp.initialiserLargeurPdv();
			add(tmp);
			statsPokemonsJ2.put(p,tmp);
		}
    }

    public Map<Pokemon, StatsPokemon> getStatsPokemons(boolean joueur1) {
		if(!joueur1)
        	return statsPokemonsJ1;
		return statsPokemonsJ2;
    }

    @Override
    public void repaint(){
        int height=getSize().height;
        int width=getSize().width;
		if(j1!=null && j2!=null){
			j1.setBounds(width/10,30,width/3,15);
			j2.setBounds(width/2,30,width/3,15);
		}
		if(statsPokemonsJ1!=null && statsPokemonsJ2!=null){
			int i=0;
			for(StatsPokemon s : statsPokemonsJ1.values()){
				if(i!=0)
					s.setBounds(width/10, 50+(i*((height-50)/6))+((height/6)/5), width/3, (height-50)/6);
				else
					s.setBounds(width/10, 50+(i*((height-50)/6)), width/3, (height-50)/6);
				i++;
			}
			i=0;
			for(StatsPokemon s : statsPokemonsJ2.values()){
				if(i!=0)
					s.setBounds(width/2, 50+(i*((height-50)/6))+((height/6)/5), width/3, (height-50)/6);
				else
					s.setBounds(width/2, 50+(i*((height-50)/6)), width/3, (height-50)/6);
				i++;
			}
		}

    }
    
}
