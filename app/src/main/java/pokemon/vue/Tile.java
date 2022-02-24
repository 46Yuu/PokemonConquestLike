package pokemon.vue;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import pokemon.controleur.Controleur;
import pokemon.modele.terrain.Terrain;

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
    private int posInList;
    private boolean pokemonPresent;
    private boolean select;
    private Terrain plateau;
    private Controleur controleur;

    public Tile(String path, String pathSelect,int x, int y, int posInList, Terrain plateau, Controleur controleur){
        this.posInList=posInList;
        this.plateau=plateau;
        this.controleur=controleur;
        try{
            image = ImageIO.read(new File(path));
            imageSelect=ImageIO.read(new File(pathSelect));
            if(plateau.tab[x][y].getPokemon()!=null){
                pokemonPresent=true;
                imagePokemon = ImageIO.read(new File((plateau.tab[x][y].getPokemon().getCheminImage())));
            }
        }catch(IOException e){
            System.out.println("File not found!");
        }
        this.x=x;
        this.y=y;
        setLayout(new BorderLayout());
        addMouseListener(new MouseDeplace());
    }

    public void miseAJour(){
        if(plateau.tab[x][y].getPokemon()!=null){
            pokemonPresent=true;
            try{
                imagePokemon = ImageIO.read(new File(plateau.tab[x][y].getPokemon().getCheminImage()));
            }catch(Exception e){
                System.out.println("File not found!");
            }
        }
        else{
            pokemonPresent=false;
            imagePokemon=null;
        }
        repaint();
    }

    private class MouseDeplace implements MouseInputListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(pokemonPresent && controleur.deplacerPokemon && controleur.anciennePosI==x && controleur.anciennePosY==y){
            //le pokémon n'est pas déplacé
                controleur.deplacerPokemon=false;
            }
            else if(pokemonPresent){
                controleur.deplacerPokemon=true;
                controleur.anciennePosI=x;
                controleur.anciennePosY=y;
            }
            else if(controleur.deplacerPokemon){
                controleur.deplacerPokemon(x,y);
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

    public void setPokemonPresent(boolean val){
        pokemonPresent=val;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height=getSize().height;
        int width=getSize().width;
        if(select)
            g.drawImage(imageSelect, 0, 0,width,height, this);
        else
            g.drawImage(image, 0, 0,width,height, this);
        if(pokemonPresent)//s'il y a un pokemon sur cette case, on le dessine 
            g.drawImage(imagePokemon, 0, 0,width,height, this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(this),image.getHeight(this));
    }

    public void select() {
        select=true;
        repaint();
    }

    public void deselect() {
        select=false;
        repaint();
    }
    
}

