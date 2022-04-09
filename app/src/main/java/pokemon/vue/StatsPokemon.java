package pokemon.vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StatsPokemon extends JPanel{

  private String type;
  private int pdv;
  private final int pdvTotal;
  private int atk;
  private JPanel backgroundBarreDevie;
  private JPanel barreDeVie;
  private double largeurPdvInitiale;
  private double largeurBDV;
  private JLabel labelPdv;
  private JLabel labelNomPokemon;
  private JLabel labelHP;
  private JLabel labelType;
  private JLabel labelAtk;

  private boolean cible;
  private boolean cibleEnnemi;
  private BufferedImage cadreRouge;
  private BufferedImage cadreVert;
  private int largeur=PanelJoueurs.largeurStats;

  

  public StatsPokemon(String nom,String t,int p,int a){
    try{
			cadreRouge=ImageIO.read(new File("src/main/resources/selection_stat_rouge.png"));
			cadreVert=ImageIO.read(new File("src/main/resources/selection_stat_vert.png"));
		}catch(IOException e){
			System.out.println("erreur lecture photo cadre");
		}

    nomPokemon=nom;
    type=t;
    pdvTotal=p;
    pdv=p;
    atk=a;

    setLayout(null);
    setBackground(Color.GRAY);


    labelNomPokemon=new JLabel(nomPokemon);
    add(labelNomPokemon);
    labelNomPokemon.setBounds(5,2,(largeur/2)-5,15);

    labelAtk=new JLabel("ATK: "+atk);
    add(labelAtk);
    labelAtk.setBounds(5,20,(largeur)/2-5,15);
    labelAtk.setForeground(Color.WHITE);

    backgroundBarreDevie=new JPanel();
    backgroundBarreDevie.setBackground(Color.BLACK);
    add(backgroundBarreDevie);
    barreDeVie=new JPanel();
    largeurBDV=(largeur)/2-5;
    largeurPdvInitiale=largeurBDV;
    barreDeVie.setBounds(largeur/2,5,(int)largeurBDV,5);
    barreDeVie.setBackground(Color.GREEN);
    add(barreDeVie);

    labelPdv=new JLabel(pdv+"/"+pdvTotal);
    add(labelPdv);
    labelPdv.setBounds(largeur/2,20,(largeur)/2-5,15);
    labelPdv.setForeground(Color.WHITE);

    labelType=new JLabel(type);
    add(labelType);
    labelType.setBounds(5,38,(largeur-10)/2,15);
    if(type.equals("Eau")){
      labelType.setForeground(Color.BLUE);
    }else if(type.equals("Electrique")){
      labelType.setForeground(Color.YELLOW);
    }

  }

  private String nomPokemon;
  public int getPdv() {
    return pdv;
  }

  public void setPdv(int newPdv) {
    pdv=newPdv;
    if(pdv>0)
      labelPdv.setText(pdv+"/"+pdvTotal);
    else{
      labelPdv.setText("KO");
      pdv=0;//pour ne pas avoir de valeurs négatives
    }
    largeurBDV=(largeurPdvInitiale*pdv)/pdvTotal;
    barreDeVie.setBounds(largeur/2,5,(int)largeurBDV,5);
    backgroundBarreDevie.setBounds(largeur/2+(int)largeurBDV,5,(int)(largeurPdvInitiale-largeurBDV),5);
    if(largeurBDV<=0){
      barreDeVie.setSize((int)largeurPdvInitiale,5);
      barreDeVie.setBackground(Color.black);
    }else if(largeurBDV<=largeurPdvInitiale/2){
      barreDeVie.setBackground(Color.ORANGE);
    }else if(largeurBDV<=largeurPdvInitiale/10){
      barreDeVie.setBackground(Color.RED);
    }
  }


  @Override
  protected void paintComponent(Graphics g) {
      int height=getSize().height;
      int width=getSize().width;
      largeurBDV=(largeurBDV*((largeur/2)-5))/largeurPdvInitiale;
      if(barreDeVie!=null)
        barreDeVie.setBounds(largeur/2,5,(int)largeurBDV,5);
      if(backgroundBarreDevie!=null)
        backgroundBarreDevie.setBounds(largeur/2+(int)largeurBDV,5,(int)(largeurPdvInitiale-largeurBDV),5);
      super.paintComponent(g);
      if(cible)
        g.drawImage(cadreVert, 0, 0, width, height, this);
      else if(cibleEnnemi)
        g.drawImage(cadreRouge, 0, 0, width, height, this);
  }


  public void cibleVisible(boolean afficherOuPas, boolean pokAllieOuEnnemi){
    if(pokAllieOuEnnemi)
      cible=afficherOuPas; 
    else
      cibleEnnemi=afficherOuPas;
    repaint();
  }

}
