package pokemon.vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinPartie extends JPanel{

    private String joueurGagnant;
    private JLabel label;

    public FinPartie(String joueurGagnant){
        this.joueurGagnant=joueurGagnant;
       
    }

    public void afficherVainqueur(){
        label=new JLabel();
        int height=getSize().height;
        int width=getSize().width;
        add(label);
        label.setText(joueurGagnant+" a gagné la partie");
        //label.setBounds(height/2, 0, width, 50);
        add(label);
        setBackground(Color.red);
    }
    
}
