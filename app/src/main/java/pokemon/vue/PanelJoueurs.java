package pokemon.vue;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import pokemon.controleur.Controleur;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;

import java.awt.BorderLayout;
import java.awt.Color;

public class PanelJoueurs extends JPanel{

    private HashMap<Pokemon,StatsPokemon> statsPokemonsJ1=new HashMap<>();
	private HashMap<Pokemon,StatsPokemon> statsPokemonsJ2=new HashMap<>();
	private JLabel j1=new JLabel("Pokemons du Joueur 1:");
	private JLabel j2=new JLabel("Pokemons du Joueur 2:");
	private JScrollPane jScrollPaneJ1,jScrollPaneJ2;
	private JPanel panelJ1, panelJ2;

    public PanelJoueurs(Controleur controleur) {
		panelJ1=new JPanel();
		panelJ2=new JPanel();
		panelJ1.setLayout(null);
		panelJ2.setLayout(null);
		jScrollPaneJ1=new JScrollPane(panelJ1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPaneJ2=new JScrollPane(panelJ2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelJ1.setBackground(Color.DARK_GRAY);
		panelJ2.setBackground(Color.DARK_GRAY);
		add(jScrollPaneJ1);
		add(jScrollPaneJ2);
		

        Map<Pokemon,Case> pokemonsJ1 = controleur.jeux.getPokemonCaseJoueur1();
		j1.setForeground(Color.WHITE);
		panelJ1.add(j1);
		for(Pokemon p: pokemonsJ1.keySet()){
			StatsPokemon tmp=new StatsPokemon(p.getNom(),p.getType(),p.getPdv(),p.getAtk());
			tmp.initialiserLargeurPdv();
			panelJ1.add(tmp);
			statsPokemonsJ1.put(p,tmp);
		}

		Map<Pokemon,Case> pokemonsJ2 = controleur.jeux.getPokemonCaseJoueur2();
		j2.setForeground(Color.WHITE);
	    panelJ2.add(j2);
		for(Pokemon p: pokemonsJ2.keySet()){
			StatsPokemon tmp=new StatsPokemon(p.getNom(),p.getType(),p.getPdv(),p.getAtk());
			tmp.initialiserLargeurPdv();
			panelJ2.add(tmp);
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
		if(jScrollPaneJ1!=null && jScrollPaneJ2!=null){
			jScrollPaneJ1.setBounds(0,20,width/2,height-20);
			jScrollPaneJ2.setBounds(width/2,20,width/2,height-20);
			jScrollPaneJ1.setForeground(Color.DARK_GRAY);
			jScrollPaneJ2.setForeground(Color.DARK_GRAY);
			height=jScrollPaneJ1.getSize().height;
			width=jScrollPaneJ2.getSize().width-jScrollPaneJ1.getVerticalScrollBar().getSize().width;
		}
		if(j1!=null && j2!=null){
			j1.setBounds(0,0,width,15);
			j2.setBounds(0,0,width,15);
		}
		if(statsPokemonsJ1!=null && statsPokemonsJ2!=null){
			int i=0;
			for(StatsPokemon s : statsPokemonsJ1.values()){
				s.setBounds(0, i*(70+10)+25, width, 70);
				i++;
			}
			i=0;
			for(StatsPokemon s : statsPokemonsJ2.values()){
				s.setBounds(0, i*(70+10)+25, width, 70);
				i++;
			}
		}

    }
    
}
