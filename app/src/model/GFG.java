import java.util.*;

public class GFG {
    static class pair
{
    int first, second;
     
    public pair(int first, int second) 
    {
        this.first = first;
        this.second = second;
    }   
}
 
static final int ROW = 4;
static final int COL = 4;
 
// Direction vectors
static int dRow[] = { -1, 0, 1, 0 };
static int dCol[] = { 0, 1, 0, -1 };
 
// Function to check if a cell
// is be visited or not
static boolean isValid(boolean vis[][],
                       int row, int col)
{
     
    // If cell lies out of bounds
    if (row < 0 || col < 0 ||
        row >= ROW || col >= COL)
        return false;
 
    // If cell is already visited
    if (vis[row][col])
        return false;
 
    // Otherwise
    return true;
}
 
// Function to perform the BFS traversal
static void BFS(int grid[][], boolean vis[][],
                int row, int col)
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
 
// Driver Code
public static void main(String[] args)
{
     
    // Given input matrix
    int grid[][] = { { 1, 2, 3, 4 },
                     { 5, 6, 7, 8 },
                     { 9, 10, 11, 12 },
                     { 13, 14, 15, 16 } };
 
    // Declare the visited array
    boolean [][]vis = new boolean[ROW][COL];
 
    BFS(grid, vis, 0, 0);
}
}
}
