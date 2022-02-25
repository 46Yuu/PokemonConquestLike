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
	static class pair
    {
        int first, second;
        
        public pair(int first, int second) 
        {
            this.first = first;
            this.second = second;
        }   
    }
    
    // Direction vectors
    static int dRow[] = { -1, 0, 1, 0 };
    static int dCol[] = { 0, 1, 0, -1 };
    
    // Function to check if a cell
    // is be visited or not
    private boolean isValid(boolean vis[][],int row, int col)
    {
        // If cell lies out of bounds
        if (row < 0 || col < 0 || row >= vis.length || col >= vis[0].length)
            return false;
    
        // If cell is already visited
        if (vis[row][col])
            return false;

		if(tab[row][col].getType()==TypeCase.Water)
			return false;
    
        // Otherwise
        return true;
    }
    
    // Function to perform the BFS traversal
    public LinkedList<pair> BFS(int grid[][], boolean vis[][],int row, int col, int capaciteDeplacement, String type)
    {

		LinkedList<pair> res=new LinkedList<>();

        // Stores indices of the matrix cells
        Queue<pair > q = new LinkedList<>();
    
        // Mark the starting cell as visited
        // and push it into the queue
        q.add(new pair(row, col));
        vis[row][col] = true;
    
		int compt=0;

        // Iterate while the queue
        // is not empty
        while (!q.isEmpty() && compt<capaciteDeplacement)
        {
            pair cell = q.peek();
            int x = cell.first;
            int y = cell.second;
    
            System.out.print(grid[x][y] + " ");
    
            q.remove();
    
            // Go to the adjacent cells
            for(int i = 0; i < 4; i++)
            {
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];
    
                if (isValid(vis, adjx, adjy))
                {
                    q.add(new pair(adjx, adjy));
                    vis[adjx][adjy] = true;
					res.add(new pair(adjx,adjy));
                }
            }
			compt++;
        }
		return res;
    }
}
