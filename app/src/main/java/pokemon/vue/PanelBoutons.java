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
  private JButton boutonAnnulerD = new JButton("Annuler");
  private JButton buttonRecommencer;
  private Map<String,JButton> listeBoutonsAttaques = new TreeMap<String,JButton>();
  private Controleur controleur;
  private PanelFinPartie panelFinPartie;
  
  private JLabel labelType=new JLabel();
  private JLabel labelRange=new JLabel();
  private JPanel infosAttaque=new JPanel();
  private JLabel labelNomAttaque=new JLabel();
  
  public PanelBoutons(Controleur controleur, JButton buttonRecommencer){
    this.controleur=controleur;
    setLayout(null);
    setBackground(Color.GRAY);
		add(boutonAttaquer);
		add(boutonFin);
    add(boutonRetour);
    add(boutonAnnulerD);
    boutonAttaquer.setVisible(false);
    boutonFin.setVisible(false);
    boutonRetour.setVisible(false);
    boutonAnnulerD.setVisible(false);
    this.buttonRecommencer=buttonRecommencer;

    boutonRetour.addActionListener(event ->{
			boutonFin.setVisible(true);
			boutonAttaquer.setVisible(true);
      boutonAnnulerD.setVisible(true);
      boutonRetour.setVisible(false);
      for(JButton b : listeBoutonsAttaques.values()){
        b.setVisible(false);
      }
      controleur.decolorerCasesAAttaquer();
		});

    boutonAnnulerD.addActionListener(event ->{
			boutonFin.setVisible(false);
			boutonAttaquer.setVisible(false);
      boutonAnnulerD.setVisible(false);
      controleur.annulerD();
		});

    add(infosAttaque);
    infosAttaque.setBackground(Color.DARK_GRAY);
    infosAttaque.setLayout(null);
    infosAttaque.setVisible(false);
    infosAttaque.add(labelNomAttaque);
    labelNomAttaque.setForeground(Color.WHITE);
    infosAttaque.add(labelType);
    infosAttaque.add(labelRange);

  }

  public void addListeBouton(String nom){
    if (!this.listeBoutonsAttaques.containsKey(nom)){
      this.listeBoutonsAttaques.put(nom,new JButton(nom));
    }
    
  }

  public void setVisibleInfosAttaque(String nom,Attaque atk){
    infosAttaque.setVisible(true);
    labelNomAttaque.setText(nom);
    labelType.setText("Type : "+atk.getType());
    labelType.setForeground(atk.getColorLabelType());
    labelRange.setText("Range : "+atk.getDistanceMaxAttaque());
    labelRange.setForeground(Color.WHITE);
  }

  public void setInvisibleInfosAttaque(){
    infosAttaque.setVisible(false);
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

  public JButton getBoutonAnnulerD(){
    return this.boutonAnnulerD;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int width=getSize().width;
    int height=getSize().height;
    if(boutonAttaquer!=null)
      boutonAttaquer.setBounds(0,0,width/4,height/7);
    if(boutonFin!=null)
      boutonFin.setBounds(width/4+2,0,width/4,height/7);
    if(boutonRetour!=null)
      boutonRetour.setBounds(2*(width/4)+2,0,width/4,height/7);
    if(boutonAnnulerD!=null)
      boutonAnnulerD.setBounds(0,height/7,width/4,height/7);
    int i=0;
    if(listeBoutonsAttaques!=null){
      for(String s : listeBoutonsAttaques.keySet()){
        listeBoutonsAttaques.get(s).setBounds(0, i*(height/5), width/4, height/5);
        i++;
      }
    }
    if(infosAttaque!=null){
      infosAttaque.setBounds(0,4*height/5,width/4,height/5);
      labelNomAttaque.setBounds(0,0,width/4,(height/5)/3);
      labelType.setBounds(0,(height/5)/3,width/4,(height/5)/3);
      labelRange.setBounds(0,2*(height/5)/3,width/4,(height/5)/3);
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
  
}
