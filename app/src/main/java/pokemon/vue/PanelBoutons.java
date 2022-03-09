package pokemon.vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class PanelBoutons extends JPanel{

  private JButton boutonAttaquer = new JButton("Attaquer");
  
  public PanelBoutons(){
    setLayout(null);
    setBackground(Color.GRAY);
    boutonAttaquer.setBounds(0,0,100,30);
		add(boutonAttaquer);
  }
}
