package pokemon.vue;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.util.ElementScanner6;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import pokemon.controleur.Controleur;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case;

public class PanelJoueurs extends JPanel{

    private HashMap<Pokemon,StatsPokemon> statsPokemonsJ1=new HashMap<>();
	private HashMap<Pokemon,StatsPokemon> statsPokemonsJ2=new HashMap<>();
	private JLabel j1=new JLabel("Pokemons du Joueur 1:");
	private JLabel j2=new JLabel("Pokemons du Joueur 2:");
	private JScrollPane jScrollPane;
	private JPanel panel;
	private JPanel panelJ1,panelJ2;

    public PanelJoueurs(Controleur controleur) {
		panel=new JPanel();
		panel.setLayout(null);
		jScrollPane=new JScrollPane(panel);
		add(jScrollPane);
		panelJ1=new JPanel();
		panelJ2=new JPanel();
		panelJ1.setLayout(null);
		panelJ2.setLayout(null);
		panel.add(panelJ1);
		panel.add(panelJ2);
		panel.setBackground(Color.DARK_GRAY);
		panelJ1.setBackground(Color.DARK_GRAY);
		panelJ2.setBackground(Color.DARK_GRAY);

        Map<Pokemon,Case> pokemonsJ1 = controleur.jeux.getPokemonCaseJoueur1();
		j1.setForeground(Color.WHITE);
		panelJ1.add(j1);
		j1.setBounds(5,0,190,15);
		for(Pokemon p: pokemonsJ1.keySet()){
			StatsPokemon tmp=new StatsPokemon(p.getNom(),p.getType(),p.getPdv(),p.getAtk());
			tmp.initialiserLargeurPdv();
			panelJ1.add(tmp);
			statsPokemonsJ1.put(p,tmp);
		}

		Map<Pokemon,Case> pokemonsJ2 = controleur.jeux.getPokemonCaseJoueur2();
		j2.setForeground(Color.WHITE);
	    panelJ2.add(j2);
		j2.setBounds(5,0,190,15);
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
		if(jScrollPane!=null){
			jScrollPane.setBounds(0,20,width,height-20);
		}
		
		if(panelJ1!=null && panelJ2!=null && panel!=null){
			int countJ1=15+(statsPokemonsJ1.values().size()*(55+10))+10,countJ2=15+(statsPokemonsJ2.values().size()*(55+10))+10;
			int max;
			if(countJ1>=countJ2)
				max=countJ1;
			else
				max=countJ2;
			if(width>380)
				panel.setPreferredSize(new Dimension(width,max));
			else
				panel.setPreferredSize(new Dimension(380,max));

			if(width>380){
				panelJ1.setBounds((width-380)/2,0,190,max);
				panelJ2.setBounds(190+(width-380)/2,0,190,max);
			}
			else{
				panelJ1.setBounds(0,0,190,max);
				panelJ2.setBounds(190,0,190,max);
			}
		}
		
		if(statsPokemonsJ1!=null && statsPokemonsJ2!=null){
			int i=0;
			for(StatsPokemon s : statsPokemonsJ1.values()){
				s.setBounds(5, i*(55+10)+25, 180, 55);
				s.repaint();
				i++;
			}
			i=0;
			for(StatsPokemon s : statsPokemonsJ2.values()){
				s.setBounds(5, i*(55+10)+25, 180, 55);
				s.repaint();
				i++;
			}
		}

    }
    
}
