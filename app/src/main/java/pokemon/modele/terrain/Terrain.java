package pokemon.modele.terrain;

import java.util.LinkedList;
import java.util.Queue;
import pokemon.modele.pokemon.Pokemon;
import pokemon.modele.terrain.Case.TypeCase;

public class Terrain{

	private TypeCase[][] typeCase = {
		{TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Water,TypeCase.Water,TypeCase.Rock},
		{TypeCase.Rock, TypeCase.Grass , TypeCase.Grass,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock,TypeCase.Rock,TypeCase.Grass,TypeCase.Grass, TypeCase.Lava},
		{TypeCase.Roof, TypeCase.Roof , TypeCase.Grass,TypeCase.Grass, TypeCase.Lava , TypeCase.Lava,TypeCase.Rock,TypeCase.Water,TypeCase.Grass, TypeCase.Grass},
		{TypeCase.Roof, TypeCase.Water , TypeCase.Grass,TypeCase.Grass, TypeCase.Lava , TypeCase.Lava,TypeCase.Rock,TypeCase.Roof, TypeCase.Water , TypeCase.Water},
		{TypeCase.Roof, TypeCase.Water , TypeCase.Water,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock,TypeCase.Rock,TypeCase.Roof, TypeCase.Water , TypeCase.Water},
		{TypeCase.Roof, TypeCase.Water , TypeCase.Water,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock,TypeCase.Roof, TypeCase.Water , TypeCase.Water},
        {TypeCase.Roof, TypeCase.Water , TypeCase.Water,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock,TypeCase.Rock,TypeCase.Roof, TypeCase.Water , TypeCase.Water},
        {TypeCase.Rock, TypeCase.Grass , TypeCase.Grass,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock,TypeCase.Rock,TypeCase.Grass,TypeCase.Grass, TypeCase.Lava},
        {TypeCase.Roof, TypeCase.Water , TypeCase.Water,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock,TypeCase.Roof, TypeCase.Water , TypeCase.Water},
        {TypeCase.Roof, TypeCase.Water , TypeCase.Water,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock,TypeCase.Roof, TypeCase.Water , TypeCase.Water},
    };

	public Case [][] tab;
	
	public Terrain(int x, int y) {
		tab=new Case[x][y];
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++){
				tab[i][j]=new Case(i,j,null, typeCase[i][j]);
			}
		}
	}
	
    
    // Direction vectors
    static int dRow[] = { -1, 0, 1, 0 };
    static int dCol[] = { 0, 1, 0, -1 };
    
    // Function to check if a cell
    // is be visited or not
    private boolean isValid(Boolean vis[][],int rowPokemon, int colPokemon, int row, int col,int distance, int capaciteDeplacement, String TypePokemon)
    {
        // If cell lies out of bounds
        if (row < 0 || col < 0 || row >= vis.length || col >= vis[0].length)
            return false;
    
        // If cell is already visited
        if (vis[row][col])
            return false;

		//vérifier si le pokémon a la capacité de déplacement néccessaire
        if(distance>capaciteDeplacement)
            return false;

        //vérifier si le pokémon peut se déplacer dans la case
        if(tab[row][col].getType()==TypeCase.Water){
            if(!TypePokemon.equals("Eau"))
                return false;
        } 
        if(tab[row][col].getType()==TypeCase.Lava){
            if( !(TypePokemon.equals("Eau") || TypePokemon.equals("Vol") || TypePokemon.equals("Feu") ) )
                return false;
        } 

        //vérifier si il y a un pokémon sur la case
        if(tab[row][col].getPokemon()!=null)
            return false;

        // Otherwise
        return true;
    }
    
    // Function to perform the BFS traversal
    public LinkedList<Pair> BFS(int row, int col)
    {
        //avoir le type et capacité de déplacement du pokemon se trouvant sur la case row,col
        Pokemon p=tab[row][col].getPokemon();
        int capaciteDeplacement=p.getCapaciteDeplacement();
        String typePokemon=p.getType();
        
        //création d'un tableau de boolean de la taille de tab avec valeur false pour toute les case
		Boolean vis[][]=new Boolean[tab.length][tab[0].length];
		for(int i=0; i<vis.length; i++){
			for(int j=0; j<vis[0].length; j++){
				vis[i][j]=false;
			}
		}

		LinkedList<Pair> res=new LinkedList<>();

        // Stores indices of the matrix cells
        Queue<Pair > q = new LinkedList<>();
    
        // Mark the starting cell as visited
        // and push it into the queue
        q.add(new Pair(row, col,0));
        res.add(new Pair(row,col,0));
        vis[row][col] = true;
    
        // Iterate while the queue
        // is not empty
        while (!q.isEmpty() )
        {
            Pair cell = q.peek();
            int x = cell.getFirst();
            int y = cell.getSecond();
            int distance  = cell.getDistance();
    
            q.remove();
            // Go to the adjacent cells
            for(int i = 0; i < 4; i++)
            {
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];
                
                if (isValid(vis, row, col, adjx, adjy,distance+1, capaciteDeplacement, typePokemon))
                {
                    q.add(new Pair(adjx, adjy,distance+1));
                    vis[adjx][adjy] = true;
					res.add(new Pair(adjx,adjy,distance+1));
                }
            }
        }
		return res;
    }

    /**
     * renvoie le chemin d'accès à l'image du tile correspondant a la case x,y
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return le chemin d'accés à l'image du tile correspondant à la case x,y
     */
    public String getPathImageTile(int x, int y) {
        return tab[x][y].getPathImage();
    }

    /**
     * renvoie le chemin d'accès à l'image de sélection du tile correspondant a la case x,y
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case
     * @return le chemin d'accés à l'image de sélection du tile correspondant à la case x,y
     */
    public String getPathImageSelectTile(int x, int y) {
        return tab[x][y].getPathImageSelect();
    }

    /**
     * renvoie la case x,y du plateau
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case 
     * @return la case x,y
     */
    public Case getCase(int x, int y){
        return tab[x][y];
    }

    /**
     * renvoie la hauteur du plateau
     * @return la hauteur du plateau
     */
    public int getHeight() {
        return tab.length;
    }

    /**
     * renvoie la largeur du plateau
     * @return la largeur du plateau
     */
    public int getWidth() {
        return tab[0].length;
    }

    /**
     * met le pokémon p sur la case x,y, ou enlève le pokémon présent si p=null
     * @param x coordonnée x de la case
     * @param y coordonnée y de la case 
     * @param p pokémon à mettre sur la case, ou null
     */
    public void setPokemon(int x, int y, Pokemon p){
        tab[x][y].setPokemon(p);
    }
}