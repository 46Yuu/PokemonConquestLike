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
import java.awt.Dimension;

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
		jScrollPaneJ1=new JScrollPane(panelJ1);
		jScrollPaneJ2=new JScrollPane(panelJ2);
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
		}
		if(j1!=null && j2!=null){
			j1.setBounds(0,0,190,15);
			j2.setBounds(0,0,190,15);
		}
		
		if(panelJ1!=null && panelJ2!=null){
			int countJ1=15+(statsPokemonsJ1.values().size()*70),countJ2=15+(statsPokemonsJ2.values().size()*70);
			panelJ1.setPreferredSize(new Dimension(190,countJ1));
			panelJ1.setSize(new Dimension(190,countJ1));
			panelJ2.setPreferredSize(new Dimension(190,countJ2));
			panelJ2.setSize(new Dimension(190,countJ2));
		}
		
		if(statsPokemonsJ1!=null && statsPokemonsJ2!=null){
			int i=0;
			for(StatsPokemon s : statsPokemonsJ1.values()){
				s.setBounds(0, i*(70+10)+25, 190, 70);
				s.repaint();
				i++;
			}
			i=0;
			for(StatsPokemon s : statsPokemonsJ2.values()){
				s.setBounds(0, i*(70+10)+25, 190, 70);
				s.repaint();
				i++;
			}
		}

    }
    
}
