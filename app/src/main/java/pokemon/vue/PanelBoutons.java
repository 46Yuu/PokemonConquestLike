package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pokemon.controleur.Controleur;
import pokemon.modele.attaque.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class PanelBoutons extends JPanel{

  private JButton boutonAttaquer = new JButton("Attaquer");
  private JButton boutonFin = new JButton("Wait");
  private JButton boutonRetour = new JButton("Retour");
  private JButton buttonRecommencer;
  private Map<String,JButton> listeBoutonsAttaques = new TreeMap<String,JButton>();
  private Map<String,JPanel> listeInfosAttaques = new TreeMap<String,JPanel>();
  private Controleur controleur;
  private PanelFinPartie panelFinPartie;
  
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

  public void addAttaqueInfos(String nom,Attaque atk){
    if (!this.listeInfosAttaques.containsKey(nom)){
      JPanel infosAttaque =new JPanel();
      infosAttaque.setBackground(Color.DARK_GRAY);
      infosAttaque.setBounds(0,300,200,80);
      add(infosAttaque);
      infosAttaque.setLayout(null);
      infosAttaque.setVisible(false);

      JLabel labelNomAttaque=new JLabel(nom);
      infosAttaque.add(labelNomAttaque);
      labelNomAttaque.setBounds(5,5,100,15);
      labelNomAttaque.setForeground(Color.WHITE);

      addLabelType(atk,infosAttaque);


      this.listeInfosAttaques.put(nom,infosAttaque);
    }
  }

  public void addLabelType(Attaque atk,JPanel infosAttaque){
    if(atk instanceof AttaqueElectrique){
      JLabel labelType=new JLabel("Type : Electrique");
      infosAttaque.add(labelType);
      labelType.setBounds(5,30,200,15);
      labelType.setForeground(Color.WHITE);
    }

    if(atk instanceof AttaqueCombat){
      JLabel labelType=new JLabel("Type : Combat");
      infosAttaque.add(labelType);
      labelType.setBounds(5,30,200,15);
      labelType.setForeground(Color.WHITE);
    }

    if(atk instanceof AttaqueNormal){
      JLabel labelType=new JLabel("Type : Normal");
      infosAttaque.add(labelType);
      labelType.setBounds(5,30,200,15);
      labelType.setForeground(Color.WHITE);
    }

    JLabel range=new JLabel("Range : "+atk.getDistanceMaxAttaque());
      infosAttaque.add(range);
      range.setBounds(5,55,200,15);
      range.setForeground(Color.WHITE);
  }

  public JButton getBoutonDeListe(String nom){
    if(listeBoutonsAttaques.containsKey(nom)){
			return listeBoutonsAttaques.get(nom);
		}
    return null;
  }

  public JPanel getAttaqueInfos(String nom){
    if(listeInfosAttaques.containsKey(nom)){
			return listeInfosAttaques.get(nom);
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
      buttonRecommencer.setBounds(0,5*height/6,width,height/6);
    if(panelFinPartie!=null)
      panelFinPartie.setBounds(0,0, width, 5*height/6);
  }

  public void afficherFinPartie(BufferedImage imageFinPartie){
    panelFinPartie=new PanelFinPartie(imageFinPartie);
    add(panelFinPartie);
  }

  public void enleverAttaqueInfos(String a) {
		listeInfosAttaques.get(a).setVisible(false);
	}
  
}
