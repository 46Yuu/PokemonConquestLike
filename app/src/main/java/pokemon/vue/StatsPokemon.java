package pokemon.vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


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
  private JLabel cible;
  

  public StatsPokemon(String nom,String t,int p,int a){
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

    cible=new JLabel("CIBLE");
    add(cible);
    cible.setBounds(135,38,40,15);
    cible.setForeground(Color.RED);
    cible.setVisible(false);
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

  @Override
  public void repaint(){
    largeurBDV=(largeurBDV*85)/largeurPdvInitiale;
    if(barreDeVie!=null)
      barreDeVie.setBounds(90,5,(int)largeurBDV,5);
    if(backgroundBarreDevie!=null)
      backgroundBarreDevie.setBounds(90,5,(int)(largeurPdvInitiale-largeurBDV),5);
  }

  public void cibleVisible(boolean b){
    cible.setVisible(b);
    double width=getSize().getWidth();
    double height=getSize().getHeight();
    cible.setBounds((int)(2*width)/3,(int)(2*(height/4)+3*((height/4)/4)),(int)width/3,(int)height/4);
  }
}
