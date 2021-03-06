package fb;

/**
 *  You are given a m x n 2D grid initialized with these three possible values.
 *
 *     -1 - A wall or an obstacle.
 *     0 - A gate.
 *     INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
 *
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * For example, given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 * Understand the problem:
 * It is very classic backtracking problem. We can start from each gate (0 point), and searching for its neighbors. We can either use DFS or BFS solution.
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length<=0) {
            return;
        }

        for(int row=0;row<rooms.length;row++) {
            for(int col=0;col<rooms[row].length;col++) {
                dfs(row,col,0,rooms);
            }
        }
    }

    public void dfs(int row, int column, int distance,int[][] rooms) {
        if(row<0 || row>rooms.length || column <0 || column>=rooms[row].length|| rooms[row][column]>distance)  {
            return;
        }
        rooms[row][column]=distance;
        dfs(row+1,column,distance+1, rooms);
        dfs(row -1 ,column,distance+1, rooms);
        dfs(row,column+1,distance+1, rooms);
        dfs(row,column -1 ,distance+1, rooms);
    }

}
