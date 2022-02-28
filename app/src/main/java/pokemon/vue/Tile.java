package pokemon.vue;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import pokemon.controleur.Controleur;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class Tile extends JPanel{
    private BufferedImage image;
    private BufferedImage imageSelect;
    private BufferedImage imagePokemon;
    private int x;
    private int y;
    private boolean pokemonPresent;
    private boolean select;
    private Controleur controleur;

    public Tile(String path, String pathSelect,int x, int y, Controleur controleur){
        this.controleur=controleur;
        try{
            image = ImageIO.read(new File(path));
            imageSelect=ImageIO.read(new File(pathSelect));
        }catch(IOException e){
            System.out.println("File not found!");
        }
        this.x=x;
        this.y=y;
        setLayout(new BorderLayout());
        addMouseListener(new MouseDeplace());
    }

    private class MouseDeplace implements MouseInputListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(select && pokemonPresent && !controleur.deplacerPokemon){
                controleur.deplacerPokemon=true;
                controleur.selectionnerCasePossibles(x,y);
            }
            //si on peut déplacer le pokémon et le tile est selectionné
            else if(select && controleur.deplacerPokemon){
                controleur.deplacerPokemon(x,y);
                controleur.deplacerPokemon=false;
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height=getSize().height;
        int width=getSize().width;
        if(select)//dessine image de selection du tile
            g.drawImage(imageSelect, 0, 0,width,height, this);
        else//sinon dessine image normale du tile
            g.drawImage(image, 0, 0,width,height, this);
        if(pokemonPresent)//s'il y a un pokemon sur cette case, on le dessine 
            g.drawImage(imagePokemon, 0, 0,width,height, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(this),image.getHeight(this));
    }

    /**
     * sélectionne le tile
     */
    public void select() {
        select=true;
        repaint();
    }

    /**
     * désélectionne le tile
     */
    public void deselect() {
        select=false;
        repaint();
    }

    /**
     * dessine si b=true ou enleve si b=false, le pokémon sur le tile
     * @param b true pour mettre le pokémon dans le tile, ou false pour enlever le pokémon
     * @param pathImagePokemon chemin de l'image du pokémon si b==true, sinon chaine vide
     */
    public void setPokemonPresent(Boolean b, String pathImagePokemon){
        pokemonPresent=b;
        if(b){
            try{
                imagePokemon=ImageIO.read(new File(pathImagePokemon));
            }catch(IOException e){
                System.out.println("File not found!");
            }
        }
        else{
            imagePokemon=null;
        }
        repaint();
    }

}

