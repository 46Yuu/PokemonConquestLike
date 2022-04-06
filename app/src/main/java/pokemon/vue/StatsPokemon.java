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

    backgroundBarreDevie=new JPanel();
    backgroundBarreDevie.setBackground(Color.BLACK);
    add(backgroundBarreDevie);
    barreDeVie=new JPanel();
    barreDeVie.setBounds(90,4,(int)largeurBDV,5);
    barreDeVie.setBackground(Color.GREEN);
    add(barreDeVie);

    labelNomPokemon=new JLabel(nomPokemon);
    add(labelNomPokemon);
    labelNomPokemon.setBounds(5,2,60,15);

    labelHP=new JLabel("HP");
    add(labelHP);
    labelHP.setBounds(65,2,25,15);

    labelPdv=new JLabel(pdv+"/"+pdvTotal);
    add(labelPdv);
    labelPdv.setBounds(95,20,80,15);
    labelPdv.setForeground(Color.WHITE);

    labelType=new JLabel(type);
    add(labelType);
    labelType.setBounds(5,20,90,15);
    if(type.equals("Eau")){
      labelType.setForeground(Color.BLUE);
    }else if(type.equals("Electrique")){
      labelType.setForeground(Color.YELLOW);
    }

    labelAtk=new JLabel("ATK: "+atk);
    add(labelAtk);
    labelAtk.setBounds(5,38,50,15);
    labelAtk.setForeground(Color.WHITE);
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
    barreDeVie.setBounds(getSize().width/2,(2*((getSize().height/4)))/4,(int)largeurBDV,5);
    backgroundBarreDevie.setBounds((int)(getSize().getWidth()/2+largeurBDV),(2*((getSize().height/4)))/4,(int)(largeurPdvInitiale-largeurBDV),5);
    if(largeurBDV<=0){
      barreDeVie.setSize((int)largeurPdvInitiale,5);
      barreDeVie.setBackground(Color.black);
    }else if(largeurBDV<=largeurPdvInitiale/2){
      barreDeVie.setBackground(Color.ORANGE);
    }else if(largeurBDV<=largeurPdvInitiale/10){
      barreDeVie.setBackground(Color.RED);
    }
  }


  public void initialiserLargeurPdv(){
    largeurBDV=85;
    largeurPdvInitiale=largeurBDV;
  }

  public void cibleVisible(boolean afficherOuPas, boolean pokAllieOuEnnemi){
    if(pokAllieOuEnnemi)
      cible=afficherOuPas; 
    else
      cibleEnnemi=afficherOuPas;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
      int height=getSize().height;
      int width=getSize().width;
      largeurBDV=(largeurBDV*85)/largeurPdvInitiale;
      if(barreDeVie!=null)
        barreDeVie.setBounds(90,5,(int)largeurBDV,5);
      if(backgroundBarreDevie!=null)
        backgroundBarreDevie.setBounds(90,5,(int)(largeurPdvInitiale-largeurBDV),5);
      super.paintComponent(g);
      if(cible)
        g.drawImage(cadreVert, 0, 0, width, height, this);
      else if(cibleEnnemi)
        g.drawImage(cadreRouge, 0, 0, width, height, this);
  }
}
