package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import pokemon.controleur.Controleur;
import java.awt.*;
import java.util.*;

public class PanelBoutons extends JPanel{

  private JButton boutonAttaquer = new JButton("Attaquer");
  private JButton boutonFin = new JButton("Fin de tour");
  private JButton boutonRetour = new JButton("Retour");
  private JButton buttonRecommencer;
  private Map<String,JButton> listeBoutonsAttaques = new TreeMap<String,JButton>();
  private Controleur controleur;
  
  public PanelBoutons(Controleur controleur, JButton buttonRecommencer){
    this.controleur=controleur;
    setLayout(null);
    setBackground(Color.GRAY);
		add(boutonAttaquer);
		add(boutonFin);
    add(boutonRetour);
    boutonAttaquer.setVisible(false);
    boutonFin.setVisible(false);
    boutonRetour.setVisible(false);
    this.buttonRecommencer=buttonRecommencer;

    boutonRetour.addActionListener(event ->{
			boutonFin.setVisible(true);
			boutonAttaquer.setVisible(true);
      boutonRetour.setVisible(false);
      for(JButton b : listeBoutonsAttaques.values()){
        b.setVisible(false);
      }
      controleur.decolorerCasesAAttaquer();
		});
  }

  public void addListeBouton(String nom){
    if (!this.listeBoutonsAttaques.containsKey(nom)){
      this.listeBoutonsAttaques.put(nom,new JButton(nom));
    }
  }
  public JButton getBoutonDeListe(String nom){
    if(listeBoutonsAttaques.containsKey(nom)){
			return listeBoutonsAttaques.get(nom);
		}
    return null;
  }

  public Map<String,JButton> getListeBoutonAttaque(){
    return this.listeBoutonsAttaques;
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

  @Override
  public void repaint() {
    super.repaint();
    int width=getSize().width;
    int height=getSize().height;
    if(boutonAttaquer!=null)
      boutonAttaquer.setBounds(0,0,width/4,height/7);
    if(boutonFin!=null)
      boutonFin.setBounds(width/4+2,0,width/4,height/7);
    if(boutonRetour!=null)
      boutonRetour.setBounds(2*(width/4)+2,0,width/4,height/7);
    int i=0;
    if(listeBoutonsAttaques!=null){
      for(String s : listeBoutonsAttaques.keySet()){
        listeBoutonsAttaques.get(s).setBounds(0, i*(height/6), width/4, height/6);
        i++;
      }
    }
    if(buttonRecommencer!=null)
      buttonRecommencer.setBounds(width/3,height/3,width/3,height/3);
  }
}
