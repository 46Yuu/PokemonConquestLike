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
  private final int LARGEUR_BDV_TOTAL=80;
  private int largeurBDV;
  private JLabel labelPdv;

  public StatsPokemon(int x,int y,String nom,String t,int p,int a){
    nomPokemon=nom;
    type=t;
    pdvTotal=p;
    pdv=p;
    atk=a;
    largeurBDV=LARGEUR_BDV_TOTAL;
    

    setLayout(null);
    setBackground(Color.GRAY);
    setBounds(x,y,170,50);

    backgroundBarreDevie=new JPanel();
    backgroundBarreDevie.setBackground(Color.BLACK);
    add(backgroundBarreDevie);
    barreDeVie=new JPanel();
    barreDeVie.setBounds(80,5,largeurBDV,5);
    barreDeVie.setBackground(Color.GREEN);
    add(barreDeVie);

    JLabel labelNomPokemon=new JLabel(nomPokemon);
    add(labelNomPokemon);
    labelNomPokemon.setBounds(5,2,50,10);

    JLabel labelHP=new JLabel("HP");
    add(labelHP);
    labelHP.setBounds(60,2,50,10);

    labelPdv=new JLabel(pdv+"/"+pdvTotal);
    add(labelPdv);
    labelPdv.setBounds(130,12,50,10);
    labelPdv.setForeground(Color.WHITE);

    JLabel labelType=new JLabel(type);
    add(labelType);
    labelType.setBounds(5,15,90,15);
    if(type.equals("Eau")){
      labelType.setForeground(Color.BLUE);
    }else if(type.equals("Electrique")){
      labelType.setForeground(Color.YELLOW);
    }

    JLabel labelAtk=new JLabel("ATK: "+atk);
    add(labelAtk);
    labelAtk.setBounds(5,30,50,15);
    labelAtk.setForeground(Color.WHITE);
  }

  private String nomPokemon;
  public int getPdv() {
    return pdv;
  }

  public void setPdv(int newPdv) {
    pdv=newPdv;
    largeurBDV=largeurBDV*pdv/pdvTotal;
    if(pdv>0)
      labelPdv.setText(pdv+"/"+pdvTotal);
    else
      labelPdv.setText("éliminé");
    barreDeVie.setBounds(80,5,largeurBDV,5);
    backgroundBarreDevie.setBounds(80+largeurBDV,5,LARGEUR_BDV_TOTAL-largeurBDV,5);
    if(largeurBDV==0){
      barreDeVie.setSize(LARGEUR_BDV_TOTAL,5);
      barreDeVie.setBackground(Color.black);
    }else if(largeurBDV<=LARGEUR_BDV_TOTAL/2){
      barreDeVie.setBackground(Color.ORANGE);
    }else if(largeurBDV<=LARGEUR_BDV_TOTAL/10){
      barreDeVie.setBackground(Color.RED);
    }
  }

}
