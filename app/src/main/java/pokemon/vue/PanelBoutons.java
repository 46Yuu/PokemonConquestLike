package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.util.*;

public class PanelBoutons extends JPanel{

  private JButton boutonAttaquer = new JButton("Attaquer");
  private JButton boutonFin = new JButton("Fin de tour");
  private JButton boutonRetour = new JButton("Retour");
  private Map<String,JButton> listeBoutonsAttaques = new TreeMap<String,JButton>();
  
  public PanelBoutons(){
    setLayout(null);
    setBackground(Color.GRAY);
    boutonAttaquer.setBounds(0,0,100,30);
		add(boutonAttaquer);
    boutonFin.setBounds(100,0,100,30);
		add(boutonFin);
    boutonRetour.setBounds(200,0,100,30);
    add(boutonRetour);
    boutonAttaquer.setVisible(false);
    boutonFin.setVisible(false);
    boutonRetour.setVisible(false);

    boutonRetour.addActionListener(event ->{
			boutonFin.setVisible(true);
			boutonAttaquer.setVisible(true);
      boutonRetour.setVisible(false);
      for(JButton b : listeBoutonsAttaques.values()){
        b.setVisible(false);
      }
		});
  }

  public void addListeBouton(String nom){
    if (!this.listeBoutonsAttaques.containsKey(nom)){
      this.listeBoutonsAttaques.put(nom,new JButton(nom));
    }
  }
  public JButton getBoutonDeListe(String nom){
    if(listeBoutonsAttaques.containsKey(nom)){
			JButton tmp = listeBoutonsAttaques.get(nom);
			return tmp;
		}
    else {
      return null;
    }
  }
  public void setBoundsBouton(JButton b, int x, int y){
    b.setBounds(x,y,100,30);
  }

  public JButton getBoutonAttaque(){
    return this.boutonAttaquer;
  }

  public JButton getBoutonFin(){
    return this.boutonFin;
  }
  
  public JButton getBoutonRetour(){
    return this.boutonRetour;
  }
}
