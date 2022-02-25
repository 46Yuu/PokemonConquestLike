package pokemon.modele.terrain;

import java.util.LinkedList;
import java.util.Queue;

import pokemon.modele.jeux.Jeux;
import pokemon.modele.terrain.Case.TypeCase;

public class Terrain{

	private TypeCase[][] typeCase = {
		{TypeCase.Rock, TypeCase.Rock , TypeCase.Rock,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock},
		{TypeCase.Rock, TypeCase.Grass , TypeCase.Grass,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock},
		{TypeCase.Roof, TypeCase.Roof , TypeCase.Grass,TypeCase.Grass, TypeCase.Lava , TypeCase.Lava},
		{TypeCase.Roof, TypeCase.Water , TypeCase.Grass,TypeCase.Grass, TypeCase.Lava , TypeCase.Lava},
		{TypeCase.Roof, TypeCase.Water , TypeCase.Water,TypeCase.Grass, TypeCase.Grass , TypeCase.Rock},
		{TypeCase.Roof, TypeCase.Water , TypeCase.Water,TypeCase.Rock, TypeCase.Rock , TypeCase.Rock},
	};

	public Case [][] tab;
	private Jeux jeux;
	
	public Terrain(int x, int y, Jeux jeux) {
		this.jeux=jeux;
		tab=new Case[x][y];
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++){
				tab[i][j]=new Case(i,j,null, typeCase[i][j]);
			}
		}
		jeux.poserPokemons(tab);
	}
	
    
    // Direction vectors
    static int dRow[] = { -1, 0, 1, 0 };
    static int dCol[] = { 0, 1, 0, -1 };
    
    // Function to check if a cell
    // is be visited or not
    private boolean isValid(Boolean vis[][],int row, int col)
    {
        // If cell lies out of bounds
        if (row < 0 || col < 0 || row >= vis.length || col >= vis[0].length)
            return false;
    
        // If cell is already visited
        if (vis[row][col])
            return false;

		//if(tab[row][col].getType()==TypeCase.Water)
		//	return false;
    
        // Otherwise
        return true;
    }
    
    // Function to perform the BFS traversal
    public LinkedList<Pair> BFS(int row, int col, int capaciteDeplacement, String type)
    {
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
        q.add(new Pair(row, col));
        vis[row][col] = true;
    
		

        // Iterate while the queue
        // is not empty
        while (!q.isEmpty() )
        {
            Pair cell = q.peek();
            int x = cell.first;
            int y = cell.second;
    
            System.out.print(tab[x][y] + " ");
    
            q.remove();
    
            // Go to the adjacent cells
            for(int i = 0; i < 4; i++)
            {
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];
    
                if (isValid(vis, adjx, adjy))
                {
                    q.add(new Pair(adjx, adjy));
                    vis[adjx][adjy] = true;
					res.add(new Pair(adjx,adjy));
                }
            }
			
        }
		return res;
    }

    public String getPathImageTile(int x, int y) {
        return tab[x][y].getPathImage();
    }

    public String getPathImageSelectTile(int x, int y) {
        return tab[x][y].getPathImageSelect();
    }
}
