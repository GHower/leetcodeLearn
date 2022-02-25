//[1034]边界着色

//给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
//。 
//
// 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。 
//
// 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。 
//
// 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//输出：[[3,3],[3,2]] 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//输出：[[1,3,3],[2,3,3]] 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//输出：[[2,2,2],[2,1,2],[2,2,2]] 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
// 👍 91 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ColoringABorder{
    public static void main(String[] args){
//        Solution solution = new ColoringABorder().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length,n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        // 边界数组
        List<int[]> borders = new ArrayList<>();
        int oldColor = grid[row][col];
        visited[row][col] = true;
        dfs(grid,row,col,visited,borders,oldColor);
        for (int i = 0; i < borders.size(); i++) {
            int x = borders.get(i)[0], y = borders.get(i)[1];
            grid[x][y] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited, List<int[]> borders, int color) {
        int m = grid.length,n = grid[0].length;
        boolean isBorder = false;
        // 四个方向
        int [][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < 4; i++) {
            int nx = direction[i][0] + row, ny = direction[i][1] + col;
            if(!(nx >= 0 && nx< m && ny >= 0 && ny< n && grid[nx][ny] == color)){
                isBorder = true;
            }else if (!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(grid,nx,ny,visited,borders,color);
            }
        }
        if(isBorder){
            borders.add(new int[]{row,col});
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
