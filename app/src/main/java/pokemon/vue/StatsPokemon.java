package pokemon.vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StatsPokemon extends JPanel{

  /**
   * le type du pokémon
   */
  private String type;
  private JLabel labelType;
  /**
   * le nombre de points de vie
   */
  private int pdv;
  private JLabel labelPdv;
  private double largeurBDV;
  private double largeurPdvInitiale;
  /**
   * le nombre de points de vie initial
   */
  private final int pdvTotal;
  private JPanel backgroundBarreDevie;
  private JPanel barreDeVie;
  private int atk;
  private JLabel labelAtk;
  private String nomPokemon;
  private JLabel labelNomPokemon;
  /**
   * dessiner un cadre vert sur le panel si cible=true,
   * ne pas dessiner sinon
   */
  private boolean cible;
  /**
   * dessiner un cadre rouge sur le panel si cibleEnnemi=true,
   * ne pas dessiner sinon
   */
  private boolean cibleEnnemi;
  /**
   * image pour selectionner les stats des pokémons ennemis
   */
  private BufferedImage cadreRouge;
  /**
   * image pour selectionner les stats des pokémons alliés 
   */
  private BufferedImage cadreVert;
  /**
   * largeur du panel
   */
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

    //ajouter et positionner le label du nom du pokémon
    labelNomPokemon=new JLabel(nomPokemon);
    add(labelNomPokemon);
    labelNomPokemon.setBounds(5,2,(largeur/2)-5,15);

    //ajouter et positionner le label Atk
    labelAtk=new JLabel("ATK: "+atk);
    add(labelAtk);
    labelAtk.setBounds(5,20,(largeur)/2-5,15);
    labelAtk.setForeground(Color.WHITE);

    //ajouter et positionner la barre de vie et son background
    backgroundBarreDevie=new JPanel();
    backgroundBarreDevie.setBackground(Color.BLACK);
    add(backgroundBarreDevie);
    barreDeVie=new JPanel();
    largeurBDV=(largeur)/2-5;
    largeurPdvInitiale=largeurBDV;
    barreDeVie.setBounds(largeur/2,5,(int)largeurBDV,5);
    barreDeVie.setBackground(Color.GREEN);
    add(barreDeVie);

    //ajouter et positionner le label des points de vie
    labelPdv=new JLabel(pdv+"/"+pdvTotal);
    add(labelPdv);
    labelPdv.setBounds(largeur/2,20,(largeur)/2-5,15);
    labelPdv.setForeground(Color.WHITE);

    //ajouter et positionner le label du type du pokémon
    labelType=new JLabel(type);
    add(labelType);
    labelType.setBounds(5,38,(largeur-10)/2,15);
    if(type.equals("Eau")){
      labelType.setForeground(Color.BLUE);
    }else if(type.equals("Electrique")){
      labelType.setForeground(Color.YELLOW);
    }

  }

  /**
   * renvoie le nombre de points de vie du pokémon auquel le stats appartient
   * @return le nombre de points de vie du pokémon auquel le stats appartient
   */
  public int getPdv() {
    return pdv;
  }

  /**
   * met à jour le nombre de points de vie, la largeur de la barre de vie et son background
   * si la nouvelle largeur de la barre de vie est inférieure à la moitié de sa largeur initiale, la barre de vie est colorée en orange
   * si la nouvelle largeur de la barre de vie est inférieure à 1/10 de sa largeur initiale, la barre de vie est colorée en rouge
   * @param newPdv le nouveau nombre de points de vie
   */
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
      //calculer la nouvelle largeur de la barre de vie après redimensionnement de la fenêtre
      largeurBDV=(largeurBDV*((largeur/2)-5))/largeurPdvInitiale;
      if(barreDeVie!=null)//redessiner la barre de vie
        barreDeVie.setBounds(largeur/2,5,(int)largeurBDV,5);
      if(backgroundBarreDevie!=null)//redessiner le background de la barre de vie
        backgroundBarreDevie.setBounds(largeur/2+(int)largeurBDV,5,(int)(largeurPdvInitiale-largeurBDV),5);
      super.paintComponent(g);
      if(cible)//si le stats d'un pokémon allié est selectionné, on dessine le cadre vert
        g.drawImage(cadreVert, 0, 0, width, height, this);
      else if(cibleEnnemi)//si le stats d'un pokémon ennemi est selectionné, on dessinne le cadre rouge
        g.drawImage(cadreRouge, 0, 0, width, height, this);
  }


  /**
   * selectionne le panel si afficheOuPas= true, déselectionne sinon, avec un cadre vert si pokAllieOuEnnemi=true, avec un cadre rouge sinon
   * @param afficherOuPas si true, on selectionne le stats 
   * @param pokAllieOuEnnemi si true on selectionne avec un cadre vert, sinon avec un cadre rouge
   */
  public void cibleVisible(boolean afficherOuPas, boolean pokAllieOuEnnemi){
    if(pokAllieOuEnnemi)
      cible=afficherOuPas; 
    else
      cibleEnnemi=afficherOuPas;
    repaint();
  }

}
