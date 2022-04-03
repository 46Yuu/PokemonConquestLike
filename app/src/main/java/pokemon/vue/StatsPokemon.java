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
    barreDeVie.setBounds(80,5,(int)largeurBDV,5);
    barreDeVie.setBackground(Color.GREEN);
    add(barreDeVie);

    labelNomPokemon=new JLabel(nomPokemon);
    add(labelNomPokemon);
    labelNomPokemon.setBounds(5,2,50,10);

    labelHP=new JLabel("HP");
    add(labelHP);
    labelHP.setBounds(60,2,50,10);

    labelPdv=new JLabel(pdv+"/"+pdvTotal);
    add(labelPdv);
    labelPdv.setBounds(130,12,50,10);
    labelPdv.setForeground(Color.WHITE);

    labelType=new JLabel(type);
    add(labelType);
    labelType.setBounds(5,15,90,15);
    if(type.equals("Eau")){
      labelType.setForeground(Color.BLUE);
    }else if(type.equals("Electrique")){
      labelType.setForeground(Color.YELLOW);
    }

    labelAtk=new JLabel("ATK: "+atk);
    add(labelAtk);
    labelAtk.setBounds(5,30,50,15);
    labelAtk.setForeground(Color.WHITE);

    cible=new JLabel("CIBLE");
    add(cible);
    cible.setBounds(135,35,50,10);
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
    largeurBDV=(getSize().width/2)-5;
    largeurPdvInitiale=largeurBDV;
  }

  @Override
  public void repaint(){
    double width=getSize().getWidth();
    double height=getSize().getHeight();
    if(largeurPdvInitiale==0)
      largeurPdvInitiale=(width/2)-5;
    largeurBDV=(largeurBDV*((width/2)-5))/largeurPdvInitiale;
    largeurPdvInitiale=(width/2)-5;
    if(barreDeVie!=null)
      barreDeVie.setBounds((int)width/2,(int)(2*((height/4))/4),(int)largeurBDV,5);
    if(backgroundBarreDevie!=null)
      backgroundBarreDevie.setBounds((int)(width/2+largeurBDV),(int)((2*(height/4))/4),(int)(largeurPdvInitiale-largeurBDV),5);
    if(labelNomPokemon!=null)
      labelNomPokemon.setBounds(0,(int)(height/4)/4,(int)(4*(width/2))/5,(int)height/4);
    if(labelHP!=null)
      labelHP.setBounds((int)(4*(width/2))/5,(int)(height/4)/4,(int)(width/2)/5,(int)height/4);
    if(labelPdv!=null)
      labelPdv.setBounds((int)width/2,(int)(height/4+2*((height/4)/4)),(int)width/2,(int)height/4);
    if(labelType!=null)
      labelType.setBounds(0,(int)((height/4)+2*((height/4)/4)),(int)width/2,(int)height/4);
    if(labelAtk!=null)
      labelAtk.setBounds(0,(int)(2*(height/4)+3*((height/4)/4)),(int)(2*width)/3,(int)height/4);
    if(cible!=null)
      cible.setBounds((int)(2*width)/3,(int)(2*(height/4)+3*((height/4)/4)),(int)width/3,(int)height/4);
  }

  public void cibleVisible(boolean b){
    cible.setVisible(b);
    double width=getSize().getWidth();
    double height=getSize().getHeight();
    cible.setBounds((int)(2*width)/3,(int)(2*(height/4)+3*((height/4)/4)),(int)width/3,(int)height/4);
  }
}
