package pokemon.modele.mouvement;

import java.util.LinkedList;
import java.util.Queue;

public interface Mouvement {
    public void Deplacement();


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
    default boolean isValid(boolean vis[][],int row, int col)
    {
        // If cell lies out of bounds
        if (row < 0 || col < 0 || row >= vis.length || col >= vis[0].length)
            return false;
    
        // If cell is already visited
        if (vis[row][col])
            return false;
    
        // Otherwise
        return true;
    }
    
    // Function to perform the BFS traversal
    default void BFS(int grid[][], boolean vis[][],int row, int col, int width, String type)
    {
        // Stores indices of the matrix cells
        Queue<pair > q = new LinkedList<>();
    
        // Mark the starting cell as visited
        // and push it into the queue
        q.add(new pair(row, col));
        vis[row][col] = true;
    
        // Iterate while the queue
        // is not empty
        while (!q.isEmpty())
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
                }
            }
        }
    }
 
}
